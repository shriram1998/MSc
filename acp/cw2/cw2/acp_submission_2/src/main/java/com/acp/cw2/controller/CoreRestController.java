package com.acp.cw2.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.acp.cw2.controller.ApiExceptionHandler.BadRequestException;

/**
 * This class represents the REST controller for the core functionality.
 */
@RestController
public class CoreRestController {
    final String keySID="s2598967";

    private static final Properties properties = new Properties();

    static {
        // Servers and security configuration
        properties.put("bootstrap.servers", "pkc-l6wr6.europe-west2.gcp.confluent.cloud:9092");
        properties.put("security.protocol", "SASL_SSL");
        properties.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username='WETVZSV7HG3F5R6S' password='sOxKkE5haw4txluOn1pkYy769EM5xmHZDKXIKmYvQzoveIEDnYReM+Q6xHO3PmtQ';");
        properties.put("sasl.mechanism", "PLAIN");

        // Client-specific configurations
        properties.put("client.dns.lookup", "use_all_dns_ips");
        properties.put("max.block.ms", "7000");
        properties.put("acks", "all");

        // Serializer and deserializer configurations
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        // Additional server for storage
        properties.put("storage.server", "https://acp-storage.azurewebsites.net/");
    }

    /**
     * Reads the last message from the specified Kafka topic.
     *
     * @param topicName The name of the Kafka topic.
     * @param propertiesList The list of properties to configure the Kafka client.
     * @return The last message from the Kafka topic.
     */
    @PostMapping(value="/readTopic/{topicName}", produces = MediaType.TEXT_PLAIN_VALUE, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public String readTopic(@PathVariable String topicName, @RequestBody String propertiesList) {
        List<Map<String, String>> jsonProperties;

        //check if body contains a json or json text
        if(!isJson(propertiesList)) {
            throw new BadRequestException("Invalid Body Format");
        }

        try{
            Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();
            jsonProperties = new Gson().fromJson(propertiesList, listType);
            for (Map<String, String> property : jsonProperties) {
                for (Map.Entry<String, String> entry : property.entrySet()) {
                    properties.setProperty(entry.getKey(), entry.getValue());
                }
            }
        } catch(Exception ex){
            throw new BadRequestException("Invalid Body Format");
        }

        properties.put("group.id","readTopic");
        String lastMessage = null;

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)) {
            consumer.subscribe(Collections.singletonList(topicName));
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(5));
            for (ConsumerRecord<String, String> record : records) {
                lastMessage = record.value();
            }
        } catch (Exception e) {
            throw new BadRequestException("Error reading from Kafka topic");
        }

        if(lastMessage==null){
            throw new BadRequestException("No new messages in the topic");
        }
        return lastMessage;
    }

    
    /**
     * Writes the specified data to the specified Kafka topic.
     *
     * @param topicName The name of the Kafka topic.
     * @param data The data to write to the Kafka topic.
     * @param propertiesList The list of properties to configure the Kafka client.
     * @param response The HTTP response object.
     */
    @PostMapping(value="/writeTopic/{topicName}/{data}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public void writeTopic(@PathVariable String topicName, @PathVariable String data, @RequestBody String propertiesList, HttpServletResponse response) {
        List<Map<String, String>> jsonProperties;

        //check if body contains a json or json text
        if(!isJson(propertiesList)) {
            throw new BadRequestException("Invalid Body Format");
        }

        try{
            Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();
            jsonProperties = new Gson().fromJson(propertiesList, listType);
            for (Map<String, String> property : jsonProperties) {
                for (Map.Entry<String, String> entry : property.entrySet()) {
                    properties.setProperty(entry.getKey(), entry.getValue());
                }
            }
        } catch(Exception ex){
            throw new BadRequestException("Invalid Body Format");
        }

        properties.put("acks","all");
        properties.put("group.id","writeTopic");
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
            producer.send(new ProducerRecord<>(topicName, keySID, data), (recordMetadata, ex) -> {
                if (ex != null)
                    throw new BadRequestException("Error sending message to Kafka topic");
                else{
                    response.setStatus(HttpServletResponse.SC_OK);
                }
            });
        } catch (Exception e) {
            throw new BadRequestException("Error sending message to Kafka");
        }
    }

    /**
     * Transforms the message from read topic by applying toUpperCase and writes to write topic
     *
     * @param readTopic The name of the Kafka topic to read from.
     * @param writeTopic The name of the Kafka topic to write to after transformation.
     * @param propertiesList The list of properties to configure the Kafka client.
     * @param response The HTTP response object.
     */
    @PostMapping(value="/transformMessage/{readTopic}/{writeTopic}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public void transformMessage(@PathVariable String readTopic, @PathVariable String writeTopic, @RequestBody String propertiesList, HttpServletResponse response) {
        List<Map<String, String>> jsonProperties;

        //check if body contains a json or json text
        if(!isJson(propertiesList)) {
            throw new BadRequestException("Invalid Body Format");
        }

        try{
            Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();
            jsonProperties = new Gson().fromJson(propertiesList, listType);
            for (Map<String, String> property : jsonProperties) {
                for (Map.Entry<String, String> entry : property.entrySet()) {
                    properties.setProperty(entry.getKey(), entry.getValue());
                }
            }
        } catch(Exception ex){
            throw new BadRequestException("Invalid Body Format");
        }

        properties.put("group.id","transformMessageRead");
        String lastMessage = null;
        //read from readTopic
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)) {
            consumer.subscribe(Collections.singletonList(readTopic));
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(5));
            for (ConsumerRecord<String, String> record : records) {
                lastMessage = record.value();
            }
        } catch (Exception e) {
            throw new BadRequestException("Error reading from Kafka topic");
        }

        if(lastMessage==null){
            throw new BadRequestException("No new messages in the topic");
        }

        properties.put("group.id","transformMessageWrite");
        properties.put("acks","all");
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
            String data=lastMessage.toUpperCase();
            producer.send(new ProducerRecord<>(writeTopic, keySID, data), (recordMetadata, ex) -> {
                if (ex != null)
                    throw new BadRequestException("Error sending message to Kafka topic");
                else{
                    response.setStatus(HttpServletResponse.SC_OK);
                }
            });
        } catch (Exception e) {
            throw new BadRequestException("Error sending message to Kafka");
        }
    }

    /**
     * Store the message from read topic and writes the storage server UUID to write topic
     *
     * @param readTopic The name of the Kafka topic to read from.
     * @param writeTopic The name of the Kafka topic to write to after transformation.
     * @param propertiesList The list of properties to configure the Kafka client.
     * @param response The HTTP response object.
     */
    @PostMapping(value="/store/{readTopic}/{writeTopic}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public void store(@PathVariable String readTopic, @PathVariable String writeTopic, @RequestBody String propertiesList, HttpServletResponse response) {
        List<Map<String, String>> jsonProperties;

        //check if body contains a json or json text
        if(!isJson(propertiesList)) {
            throw new BadRequestException("Invalid Body Format");
        }

        try{
            Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();
            jsonProperties = new Gson().fromJson(propertiesList, listType);
            for (Map<String, String> property : jsonProperties) {
                for (Map.Entry<String, String> entry : property.entrySet()) {
                    properties.setProperty(entry.getKey(), entry.getValue());
                }
            }
        } catch(Exception ex){
            throw new BadRequestException("Invalid Body Format");
        }

        properties.put("group.id","storeRead");
        String lastMessage = null;
        //read from readTopic
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)) {
            consumer.subscribe(Collections.singletonList(readTopic));
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(5));
            for (ConsumerRecord<String, String> record : records) {
                lastMessage = record.value();
            }
        } catch (Exception e) {
            throw new BadRequestException("Error reading from Kafka topic");
        }

        if(lastMessage==null){
            throw new BadRequestException("No new messages in the topic");
        }

        //write to azure blob
        URL combinedUrl;
        try {
            URL baseUrl= new URL(properties.getProperty("storage.server"));
            combinedUrl = new URL(baseUrl,"write/blob");
        } catch (Exception ex) {
            throw new BadRequestException("Invalid URL");
        }

        // Create the JSON object
        Map<String, String> jsonObject = new HashMap<>();
        jsonObject.put("uid", keySID);
        jsonObject.put("datasetName", "storeAPI");
        jsonObject.put("data", lastMessage);

        // Convert the JSON object to a JSON string
        String json = new Gson().toJson(jsonObject);

        // Create the HTTP request
        String responseBody;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
            
            ResponseEntity<UUID> responseEntity = new RestTemplate().postForEntity(combinedUrl.toString(), requestEntity, UUID.class);
            
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                responseBody = responseEntity.getBody().toString();
            } else {
                throw new BadRequestException("Storage server error");
            }
        } catch (Exception e) {
            throw new BadRequestException("Storage server error");
        }

        properties.put("group.id","storeWrite");
        properties.put("acks","all");
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {;
            producer.send(new ProducerRecord<>(writeTopic, keySID, responseBody), (recordMetadata, ex) -> {
                if (ex != null)
                    throw new BadRequestException("Error sending message to Kafka topic");
                else{
                    response.setStatus(HttpServletResponse.SC_OK);
                }
            });
        } catch (Exception e) {
            throw new BadRequestException("Error sending message to Kafka");
        }
    }

    /**
     * Retreive the specified data from storage server and write it to write topic
     *
     * @param writeTopic The name of the Kafka topic.
     * @param uuid UUID of the blob.
     * @param propertiesList The list of properties to configure the Kafka client.
     * @param response The HTTP response object.
     */
    @PostMapping(value="/retrieve/{writeTopic}/{uuid}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public void retrieve(@PathVariable String writeTopic, @PathVariable String uuid, @RequestBody String propertiesList, HttpServletResponse response) {
        List<Map<String, String>> jsonProperties;

        //check if body contains a json or json text
        if(!isJson(propertiesList)) {
            throw new BadRequestException("Invalid Body Format");
        }

        try{
            Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();
            jsonProperties = new Gson().fromJson(propertiesList, listType);
            for (Map<String, String> property : jsonProperties) {
                for (Map.Entry<String, String> entry : property.entrySet()) {
                    properties.setProperty(entry.getKey(), entry.getValue());
                }
            }
        } catch(Exception ex){
            throw new BadRequestException("Invalid Body Format");
        }

        //write to azure blob
        URL combinedUrl;
        try {
            URL baseUrl= new URL(properties.getProperty("storage.server"));
            combinedUrl = new URL(baseUrl,"read/blob/"+uuid);
        } catch (Exception ex) {
            throw new BadRequestException("Invalid URL");
        }

        // Get the data from azure blob
        String responseBody;
        try {
            ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(combinedUrl.toString(), String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                responseBody = responseEntity.getBody();
            } else {
                throw new BadRequestException("Storage server error");
            }
        } catch (Exception e) {
            throw new BadRequestException("Storage server error");
        }

        properties.put("acks","all");
        properties.put("group.id","writeTopic");
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
            producer.send(new ProducerRecord<>(writeTopic, keySID, responseBody), (recordMetadata, ex) -> {
                if (ex != null)
                    throw new BadRequestException("Error sending message to Kafka topic");
                else{
                    response.setStatus(HttpServletResponse.SC_OK);
                }
            });
        } catch (Exception e) {
            throw new BadRequestException("Error sending message to Kafka");
        }
    }

    public boolean isJson(String json) {
        try {
            JsonParser.parseString(json);
        } catch (JsonSyntaxException e) {
            return false;
        }
        return true;
    }

}

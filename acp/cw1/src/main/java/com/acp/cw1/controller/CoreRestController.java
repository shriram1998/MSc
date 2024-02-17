package com.acp.cw1.controller;

import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class CoreRestController {
    //variable to store the value
    private String value = "";

    /**
     * get uuid
     *
     * @return student id in an HTML page embedded in a h1 tag
     */
    @GetMapping(value="/uuid",produces = MediaType.TEXT_HTML_VALUE)
    public String getUuid() {
        return "<html>" +
                "<body>" +
                "<h1>s2598967</h1>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("/writevalue")
    public void writeValue(@RequestParam String value, HttpServletResponse response){
        // sanity checks
        if (value != null && !value.isEmpty()) {
            this.value = value;
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @GetMapping("/readvalue")
    public void readValue(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.getWriter().write(this.value);
    }

    @PostMapping("/callservice")
    public ResponseEntity callService(@RequestBody ServiceRequest request) throws IOException {
        if (request != null && request.getExternalBaseUrl() != null && request.getParameters() != null) {
            URL url = new URL(request.getExternalBaseUrl() + request.getParameters());
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<byte[]> response = null;
            try {
                try {
                    response = restTemplate.exchange(
                            url.toString(), HttpMethod.GET, null, byte[].class);
                }  catch(Exception ex){
                    HttpHeaders responseHeaders = new HttpHeaders();
                    responseHeaders.setContentType(MediaType.TEXT_PLAIN);
                    return new ResponseEntity<>("Invalid URL", responseHeaders,HttpStatus.BAD_REQUEST);
                }

                HttpHeaders responseHeaders = response.getHeaders();
                HttpStatus statusCode = (HttpStatus) response.getStatusCode();

                return new ResponseEntity<>(response.getBody(), responseHeaders, statusCode);

            } catch (Exception ex) {
                HttpHeaders responseHeaders = new HttpHeaders();
                responseHeaders.setContentType(MediaType.TEXT_PLAIN);
                return new ResponseEntity<>("",responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        else{
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setContentType(MediaType.TEXT_PLAIN);
            return new ResponseEntity<>("", responseHeaders,HttpStatus.BAD_REQUEST);
        }
    }
//    @PostMapping("/callservic")
//    public ResponseEntity<byte[]> callService(@RequestBody ServiceRequest request) throws IOException {
//        // Check if the request body is valid
//        ResponseEntity<byte[]> response = null;
//        if (request != null && request.getExternalBaseUrl() != null && request.getParameters() != null) {
//            try {
//                URL url = new URL(request.getExternalBaseUrl() + request.getParameters());
//                RestTemplate restTemplate = new RestTemplate();
//
////                List<HttpMessageConverter<?>> converters = new ArrayList<>();
////                converters.add(new MappingJackson2HttpMessageConverter()); // For JSON
////                converters.add(new Jaxb2RootElementHttpMessageConverter()); // For XML
////                restTemplate.setMessageConverters(converters);
//
//
//                // Get the response as a string
////                String result = restTemplate.getForObject(url.toString(), String.class);
//                response = restTemplate.exchange(url.toURI(), HttpMethod.GET, null, byte[].class);
//
//                if (response.getStatusCode() == HttpStatus.OK) {
//                    HttpHeaders headers = response.getHeaders();
//                    MediaType contentType = headers.getContentType();
//
//                    if (contentType != null) {
//                        System.out.println(contentType+contentType.getSubtype());
//                        String type = contentType.toString();
//                        if (type.equals("text/plain")) {
//                            return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(response.getBody());
//                        } else if (type.equals("application/json")) {
//                            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response.getBody());
//                        } else {
//                            // Unhandled content type, maybe log it for analysis
//                            System.out.println("Unsupported content type: " + type);
//                        }
//                    }
//                    return ResponseEntity.ok(response.getBody());
//                } else {
//                    return ResponseEntity.status(response.getStatusCode()).build();
//                }
//
////                // Set the status code to 200 OK
////                response.setStatus(HttpServletResponse.SC_OK);
////                // Return the result
////                return result;
//            } catch (MalformedURLException e) {
//                // Set the status code to 400 Bad Request
////                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                // Return the error message
//                return ResponseEntity.status(response.getStatusCode()).build();
//            } catch (URISyntaxException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            // Set the status code to 400 Bad Request
////            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return ResponseEntity.status(response.getStatusCode()).build();
//
//        }
//    }

    // A class to represent the request body for the callservice endpoint
    public static class ServiceRequest {
        private String externalBaseUrl;
        private String parameters;

        public String getExternalBaseUrl() {
            return externalBaseUrl;
        }

        public void setExternalBaseUrl(String externalBaseUrl) {
            this.externalBaseUrl = externalBaseUrl;
        }

        public String getParameters() {
            return parameters;
        }

        public void setParameters(String parameters) {
            this.parameters = parameters;
        }
    }
}

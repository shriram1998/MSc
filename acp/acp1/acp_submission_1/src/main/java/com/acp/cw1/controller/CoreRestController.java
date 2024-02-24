package com.acp.cw1.controller;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletResponse;
import java.net.URL;
import com.acp.cw1.controller.ApiExceptionHandler.BadRequestException;

@RestController
public class CoreRestController {
    //variable to store the value
    private String value = "";

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
            throw new BadRequestException("Value must be provided");
        }
    }

    @GetMapping(value = "/readvalue", produces = MediaType.TEXT_PLAIN_VALUE)
    public String readValue(){
        return this.value;
    }

    @PostMapping(value="/callservice", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> callService(@RequestBody String stringRequest){
        if (isJson(stringRequest)) {
            ServiceRequest request;
            try{
                request = new Gson().fromJson(stringRequest, ServiceRequest.class);
            } catch(Exception ex){
                throw new BadRequestException("Invalid Body Format");
            }
            if (request != null && request.getExternalBaseUrl() != null && request.getParameters() != null) {
                URL url;
                ResponseEntity<byte[]> response=null;
                try {
                    url = new URL(request.getExternalBaseUrl() + request.getParameters());
                } catch (Exception ex) {
                    throw new BadRequestException("Invalid URL");
                }
                RestTemplate restTemplate = new RestTemplate();
                try{
                    response = restTemplate.exchange(
                            url.toString(), HttpMethod.GET, null, byte[].class);
                } catch(HttpClientErrorException | HttpServerErrorException ex){
                    //fail with 4xx or 5xx errors
                    HttpStatus statusCode=(HttpStatus) ex.getStatusCode();
                    byte[] errorBody = ex.getResponseBodyAsByteArray();
                    HttpHeaders responseHeaders = ex.getResponseHeaders();
                    return new ResponseEntity<>(errorBody, responseHeaders, statusCode);
                } catch (Exception ex) {
                    //unexpected errors
                    throw new BadRequestException("Unexpected error");
                }
                HttpHeaders responseHeaders = response.getHeaders();
                HttpStatus statusCode = (HttpStatus) response.getStatusCode();
                return new ResponseEntity<>(response.getBody(), responseHeaders, statusCode);
            } else {
                throw new BadRequestException("Invalid Body");
            }
        } else{
            throw new BadRequestException("Invalid Body Format");
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

    /*
 Test cases
    @GetMapping("/xml")
    public void xml(HttpServletResponse response){
        response.setContentType("application/xml");
        response.setStatus(HttpServletResponse.SC_OK);
        try{
            response.getWriter().write("<?xml version=\"1.0\"?><catalog></catalog>");
        } catch(Exception ignored){
        }
    }

    @GetMapping("/3xx")
    public void three(HttpServletResponse response){
        response.setContentType("application/octet-stream");
        response.setStatus(HttpServletResponse.SC_FOUND);
        try{
            response.getWriter().write("10");
        } catch(Exception ignored){
        }
    }

    @GetMapping("/css")
    public void css(HttpServletResponse response){
        response.setContentType("text/css");
        response.setStatus(HttpServletResponse.SC_OK);
        try{
            response.getWriter().write("html{display:flex}");
        } catch(Exception ignored){
        }
    }

    @GetMapping("/4xx")
    public void four(HttpServletResponse response) throws IOException{
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().write("{\"name\":\"John\", \"age\":30, \"car\":null}");
    }

    @GetMapping("/5xx")
    public void five(HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write("{\"name\":\"John\", \"age\":30, \"car\":null}");
        response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }
*/
package com.ecairo.apimock.controllers;

import com.ecairo.apimock.models.Echo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EchoController {

    private Echo getResponseEcho(HttpHeaders headers, HttpServletRequest request) {
        Echo responseEcho = new Echo();

        responseEcho.setHeaders(headers.toSingleValueMap());
        responseEcho.setMethod(request.getMethod());
        responseEcho.setUrl(request.getRequestURI());
        responseEcho.setBody("");
        return responseEcho;
    }

    @GetMapping("/echo")
    public Echo getEcho(@RequestHeader HttpHeaders headers, HttpServletRequest request){
        Echo responseEcho = getResponseEcho(headers, request);

        return responseEcho;
    }

    @PostMapping("/echo")
    public Echo postEcho(@RequestHeader HttpHeaders headers, HttpServletRequest request,
        @RequestBody Object body) throws JsonProcessingException {
        Echo responseEcho = getResponseEcho(headers, request);

        ObjectMapper mapper = new ObjectMapper();
        responseEcho.setBody(mapper.writeValueAsString(body));

        return responseEcho;
    }
}

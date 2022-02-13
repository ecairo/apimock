package com.ecairo.apimock.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusCodeController {

    @GetMapping(path = "/statuscode/{code}")
    public ResponseEntity<String> getStatusCode(@PathVariable("code") int code){
        if(code < 100 || code > 599){
            return new ResponseEntity("The specified code is not a valid number between 100 and 599",
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.resolve(code));
    }
}

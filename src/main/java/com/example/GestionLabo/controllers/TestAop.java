package com.example.GestionLabo.controllers;


import com.example.GestionLabo.utils.LogExecutionTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")

public class TestAop {
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @LogExecutionTime(additionalMessage = "This is a Get Method")
    public ResponseEntity<String> getData(){
        return new ResponseEntity<>("Success Message", HttpStatus.OK);
    }


}

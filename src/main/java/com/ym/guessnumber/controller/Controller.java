package com.ym.guessnumber.controller;

import com.ym.guessnumber.reqandres.BeginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
    @GetMapping
    public String[] helloWorld(){
        String[] result = {"Hello", "world","!"};
        return result;
    }

    @PostMapping("/begin")
    public ResponseEntity<BeginResponse> startGame(){
        BeginResponse response = new BeginResponse();
        return ResponseEntity.ok(response);
    }
}

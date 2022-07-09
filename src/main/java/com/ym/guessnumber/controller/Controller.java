package com.ym.guessnumber.controller;

import com.ym.guessnumber.reqandres.BeginResponse;
import com.ym.guessnumber.reqandres.GuessRequest;
import com.ym.guessnumber.reqandres.GuessResponse;
import com.ym.guessnumber.service.GuessRoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    GuessRoundService guessRoundService;

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

    @PostMapping("/guess")
    public ResponseEntity<GuessResponse> guessARound(@Valid @RequestBody GuessRequest request) {
        GuessResponse response = guessRoundService.guess(request);

        return ResponseEntity.ok(response);
    }
}

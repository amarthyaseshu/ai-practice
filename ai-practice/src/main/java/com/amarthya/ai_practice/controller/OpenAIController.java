package com.amarthya.ai_practice.controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin("*")
public class OpenAIController {

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @PostMapping
    public ResponseEntity<String> getAnswer(@RequestBody String message){

        String response = openAiChatModel.call(message);

        return ResponseEntity.ok(response);
    }

}

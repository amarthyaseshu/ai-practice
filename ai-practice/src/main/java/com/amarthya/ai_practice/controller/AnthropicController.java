package com.amarthya.ai_practice.controller;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anthropic")
@CrossOrigin("*")
public class AnthropicController {

    @Autowired
    private AnthropicChatModel anthropicChatModel;

    @PostMapping
    public ResponseEntity<String> getAnswer(@RequestBody String message){

        String response = anthropicChatModel.call(message);

        return ResponseEntity.ok(response);
    }

}

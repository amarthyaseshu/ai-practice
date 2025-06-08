package com.amarthya.ai_practice.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ollama")
@CrossOrigin("*")
public class OllamaController {

    @Autowired
    OllamaChatModel ollamaChatModel;

    @PostMapping
    public ResponseEntity<String> getAnswer(@RequestBody String message){

        String response = ollamaChatModel.call(message);

        return ResponseEntity.ok(response);
    }

}

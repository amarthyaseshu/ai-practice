package com.amarthya.ai_practice.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ollama2")
@CrossOrigin("*")
public class OllamaController2 {

    private ChatClient chatClient;

    public OllamaController2(OllamaChatModel chatModel){
        this.chatClient = ChatClient.create(chatModel);
    }

    @PostMapping
    public ResponseEntity<String> getAnswer(@RequestBody String message){

        ChatResponse chatResponse = chatClient
                .prompt(message)
                .call()
                .chatResponse();

        System.out.println(chatResponse.getMetadata().getModel());

        String response = chatResponse.getResult().getOutput().getText();

        return ResponseEntity.ok(response);
    }

}

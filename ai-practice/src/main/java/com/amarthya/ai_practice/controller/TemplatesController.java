package com.amarthya.ai_practice.controller;


import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/anthropic")
@CrossOrigin("*")
public class TemplatesController {

    @Autowired
    OllamaChatModel chatClient;

    @GetMapping("/")
    public String findPopularSportsPerson (@RequestParam String sports) {
        String message = """
        List of 5 most popular personalities in {sports} along
        with their Career Achievements.
        Show the details in the proper Readable format. """;

                PromptTemplate template
                = new PromptTemplate(message);
        Prompt prompt = template.create(Map.of(  "sports", sports));
        return chatClient.call(prompt).getResult().getOutput().getText();
    }

    @GetMapping("/")
    public String find2(@RequestParam String sports){
        var userMessage = new UserMessage(
                String.format("List of 5 most popular personalities in %s along with. their Career Achievements."+
                        "Show the details in the proper Readable format.", sports));
        Prompt prompt = new Prompt (userMessage);
        return chatClient.call(prompt).getResult().getOutput().getText();
    }

    @GetMapping("/")
    public String find3(@RequestParam String sports){
        /*
        SystemMessage is used to give a default Msg, when prompt from user is not as expected
         */
        var systemMessage = new SystemMessage(""" 
                Your primary function is to share the information about the sports per If someone ask about anything else, you can say you only share about """);
        var userMessage = new UserMessage(
                String.format("List of 5 most popular personalities in %s along with" +
                        "Show the details in the proper Readable format.", sports));
        Prompt prompt = new Prompt(List. of (systemMessage, userMessage));
        return chatClient.call(prompt).getResult().getOutput().getText();
    }

}

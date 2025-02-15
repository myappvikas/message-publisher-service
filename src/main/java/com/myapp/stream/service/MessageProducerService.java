package com.myapp.stream.service;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProducerService {

    private final StreamBridge streamBridge;

    public MessageProducerService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        streamBridge.send("message-out", message);
        return "Message Sent: " + message;
    }
}

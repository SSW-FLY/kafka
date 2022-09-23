package com.example.kafka.controller;

import javax.annotation.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imp
 * @date 2022/9/23
 */
@RestController
public class KafkaProducer {

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @GetMapping("/api/kafka/normal/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("topic-test-llc", message);
        return "ok";
    }

}

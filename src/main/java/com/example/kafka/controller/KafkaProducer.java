package com.example.kafka.controller;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.TopicListing;
import org.apache.kafka.common.KafkaFuture;
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

    @Resource
    private AdminClient adminClient;

    @GetMapping("/api/kafka/normal/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("topic-test-llc", message);
        ListTopicsResult result = adminClient.listTopics();
        KafkaFuture<Set<String>> names = result.names();
        KafkaFuture<Collection<TopicListing>> listings = result.listings();
        KafkaFuture<Map<String, TopicListing>> future = result.namesToListings();
        return "ok";
    }

}

package com.example.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author imp
 * @date 2022/9/23
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "topic-test-llc")
    public void onMessage1(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        long offset = record.offset();
        System.out.println("offset : " + offset);
        System.out.println("简单消费Topic：" + record.topic() + "**分区" + record.partition() + "**值内容" + record.value());
    }


}

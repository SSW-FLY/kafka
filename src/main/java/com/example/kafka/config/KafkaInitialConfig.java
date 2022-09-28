package com.example.kafka.config;

import java.util.Properties;
import javax.annotation.Resource;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author imp
 * @date 2022/9/23
 */
@Configuration
public class KafkaInitialConfig {

    private String bootstrap;

    private String keySerializer;

    private String valueSerializer;

    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("topic-test-llc", 3, (short) 1);
    }

    // 如果要修改分区数，只需修改配置值重启项目即可
    // 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
    @Bean
    public NewTopic updateTopic() {
        return new NewTopic("testtopic", 10, (short) 1);
    }

    @Bean
    public AdminClient adminClient() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "cdh6-kafka-01.hypers.cc:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return AdminClient.create(properties);
    }


}

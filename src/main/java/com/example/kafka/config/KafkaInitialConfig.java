package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author imp
 * @date 2022/9/23
 */
@Configuration
public class KafkaInitialConfig {

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


}

package com.tariel.franz.kafkajson;

import com.tariel.franz.customer.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class JsonKafkaProducer {

    @Value("${spring.kafka.template.default-topic}")
    private String topicName;

    private final KafkaTemplate<String, Customer> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Customer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Customer data) {
        kafkaTemplate.send(MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build());
    }
}

package com.tariel.franz.kafkajson;

import com.tariel.franz.customer.Customer;
import com.tariel.franz.customer.CustomerRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class JsonKafkaConsumer {

    private final CustomerRepository customerRepository;

    public JsonKafkaConsumer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Customer customer) {
        System.out.println("After consuming: " + customer.getFirstName());
        Customer savedCustomer = customerRepository.save(customer);
        System.out.println("Message saved with ID: " + savedCustomer.getCustomerId());
    }
}

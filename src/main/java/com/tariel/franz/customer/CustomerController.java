package com.tariel.franz.customer;

import com.tariel.franz.kafkajson.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/kafka")
public class CustomerController {

    private final JsonKafkaProducer jsonKafkaProducer;

    public CustomerController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody CustomerRequest request) {
        jsonKafkaProducer.send(Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build());
        return ResponseEntity.ok("Message Successfully Sent!");
    }

}

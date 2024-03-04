package com.tariel.franz.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Data
@Entity(name = "customers")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;
    private String firstName;
    private String lastName;

}

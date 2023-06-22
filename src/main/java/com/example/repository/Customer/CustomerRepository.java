package com.example.repository.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}

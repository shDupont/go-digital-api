package com.example.repository.InsurancePolicy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.InsurancePolicy.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long>{
    
}

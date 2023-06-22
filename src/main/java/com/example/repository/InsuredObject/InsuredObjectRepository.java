package com.example.repository.InsuredObject;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.InsuredObject.InsuredObject;

public interface InsuredObjectRepository extends JpaRepository<InsuredObject, Long>{
    
}

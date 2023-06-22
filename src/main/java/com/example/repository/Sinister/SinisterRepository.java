package com.example.repository.Sinister;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Sinister.Sinister;

public interface SinisterRepository extends JpaRepository<Sinister, Long> {
    
}
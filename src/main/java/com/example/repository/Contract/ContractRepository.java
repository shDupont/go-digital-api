package com.example.repository.Contract;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Contract.Contract;

public interface ContractRepository  extends JpaRepository<Contract, Long>{
    
}

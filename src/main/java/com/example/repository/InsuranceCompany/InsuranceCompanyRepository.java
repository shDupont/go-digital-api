package com.example.repository.InsuranceCompany;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.InsuranceCompany.InsuranceCompany;

public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Long> {
    
}

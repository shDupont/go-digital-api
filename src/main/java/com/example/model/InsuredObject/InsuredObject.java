package com.example.model.InsuredObject;

import javax.persistence.*;

@Entity
@Table(name = "insured_object")
public class InsuredObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "insurance_policy_id")
    private long insurancePolicyId;

    public InsuredObject() {
    }

    public InsuredObject(long insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(long insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }
}

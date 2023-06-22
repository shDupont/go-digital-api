package com.example.model.InsurancePolicy;

import javax.persistence.*;

@Entity
@Table(name = "insurance_policy")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "policy_type")
    private String policyType;

    @Column(name = "contract_id")
    private long contractId;

    @Column(name = "insurance_company_id")
    private long insuranceCompanyId;

    @Column(name = "insured_object_id")
    private long insuredObjectId;

    public InsurancePolicy() {
    }

    public InsurancePolicy(String policyType, long contractId, long insuranceCompanyId, long insuredObjectId) {
        this.policyType = policyType;
        this.contractId = contractId;
        this.insuranceCompanyId = insuranceCompanyId;
        this.insuredObjectId = insuredObjectId;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public long getInsuranceCompanyId() {
        return insuranceCompanyId;
    }

    public void setInsuranceCompanyId(long insuranceCompanyId) {
        this.insuranceCompanyId = insuranceCompanyId;
    }

    public long getInsuredObjectId() {
        return insuredObjectId;
    }

    public void setInsuredObjectId(long insuredObjectId) {
        this.insuredObjectId = insuredObjectId;
    }
}


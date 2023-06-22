package com.example.model.InsuranceCompany;

import javax.persistence.*;

@Entity
@Table(name = "insurance_company")
public class InsuranceCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "name")
    private String name;

    @Column(name = "insurance_policy")
    private long insurancePolicyId;

    public InsuranceCompany() {
    }

    public InsuranceCompany(String cnpj, String name, long insurancePolicyId) {
        this.cnpj = cnpj;
        this.name = name;
        this.insurancePolicyId = insurancePolicyId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(long insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }
}
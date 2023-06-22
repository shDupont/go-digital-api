package com.example.model.Sinister;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sinister")
public class Sinister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "occurrence")
    private Date occurrence;

    @Column(name = "insurance_policy_id")
    private long insurancePolicyId;

    public Sinister() {
    }

    public Sinister(Date occurrence, long insurancePolicyId) {
        this.occurrence = occurrence;
        this.insurancePolicyId = insurancePolicyId;
    }

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Date occurrence) {
        this.occurrence = occurrence;
    }

    public long getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(long insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }
}

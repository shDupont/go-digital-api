package com.example.model.Contract;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "expiration")
	private Date expiration;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "insurance_policy")
	private long insurancePolicyId;

    @Column(name = "customer")
	private long customerId;
	
	public Contract() {}
	
	public Contract(Date expiration, String cnpj, long insurancePoliceId, long customerId) {
		this.expiration = expiration;
        this.cnpj = cnpj;
        this.insurancePolicyId = insurancePoliceId;
        this.customerId = customerId;
	}
	
	public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public long getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(long insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}




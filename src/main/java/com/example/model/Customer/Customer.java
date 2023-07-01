package com.example.model.Customer;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "state")
    private String state;

    @Column(name = "contract")
    private long contractId;

    public Customer(String cnpj, String state, long contractId) {
        this.cnpj = cnpj;
        this.state = state;
        this.contractId = contractId;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public void Customer(Customer customerDetails) {
    }
}

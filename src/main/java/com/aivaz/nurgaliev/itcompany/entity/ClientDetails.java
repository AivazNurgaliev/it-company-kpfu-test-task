package com.aivaz.nurgaliev.itcompany.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "client_details")
public class ClientDetails implements Serializable {

    @Column(name = "client_email")
    @NotNull
    private String clientEmail;

    @Column(name = "client_phone_number")
    @NotNull
    private String clientPhoneNumber;

    @Column(name = "client_budget")
    @NotNull
    private BigDecimal client_budget;

    @Id
    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    @JsonIgnore
    private Client client;

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public BigDecimal getClient_budget() {
        return client_budget;
    }

    public void setClient_budget(BigDecimal client_budget) {
        this.client_budget = client_budget;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDetails that = (ClientDetails) o;
        return clientEmail.equals(that.clientEmail) && clientPhoneNumber.equals(that.clientPhoneNumber) && client_budget.equals(that.client_budget) && client.equals(that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientEmail, clientPhoneNumber, client_budget, client);
    }

    @Override
    public String toString() {
        return "ClientDetails{" +
                "clientEmail='" + clientEmail + '\'' +
                ", clientPhoneNumber='" + clientPhoneNumber + '\'' +
                ", client_budget=" + client_budget +
                ", client=" + client +
                '}';
    }
}

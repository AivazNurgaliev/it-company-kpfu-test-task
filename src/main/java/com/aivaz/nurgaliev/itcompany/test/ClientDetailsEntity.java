/*
package com.aivaz.nurgaliev.itcompany.test;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "client_details", schema = "public", catalog = "test_task_KPFU")
public class ClientDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "client_id")
    private int clientId;
    @Basic
    @Column(name = "client_email")
    private String clientEmail;
    @Basic
    @Column(name = "client_phone_number")
    private String clientPhoneNumber;
    @Basic
    @Column(name = "client_budget")
    private BigInteger clientBudget;
    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    private ClientEntity clientByClientId;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

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

    public BigInteger getClientBudget() {
        return clientBudget;
    }

    public void setClientBudget(BigInteger clientBudget) {
        this.clientBudget = clientBudget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientDetailsEntity that = (ClientDetailsEntity) o;

        if (clientId != that.clientId) return false;
        if (clientEmail != null ? !clientEmail.equals(that.clientEmail) : that.clientEmail != null) return false;
        if (clientPhoneNumber != null ? !clientPhoneNumber.equals(that.clientPhoneNumber) : that.clientPhoneNumber != null)
            return false;
        if (clientBudget != null ? !clientBudget.equals(that.clientBudget) : that.clientBudget != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (clientEmail != null ? clientEmail.hashCode() : 0);
        result = 31 * result + (clientPhoneNumber != null ? clientPhoneNumber.hashCode() : 0);
        result = 31 * result + (clientBudget != null ? clientBudget.hashCode() : 0);
        return result;
    }

    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }
}
*/

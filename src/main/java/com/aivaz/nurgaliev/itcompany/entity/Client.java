package com.aivaz.nurgaliev.itcompany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "client_name")
    @NotNull
    private String clientName;

    @Column(name = "client_start_cooperation_date")
    @NotNull
    private Date clientStartCooperationDate;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @JsonIgnore
    private ItCompanyDepartment itCompanyDepartment;

    @OneToOne(mappedBy = "client")
    private ClientDetails clientDetails;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getClientStartCooperationDate() {
        return clientStartCooperationDate;
    }

    public void setClientStartCooperationDate(Date clientStartCooperationDate) {
        this.clientStartCooperationDate = clientStartCooperationDate;
    }

    public ItCompanyDepartment getItCompanyDepartment() {
        return itCompanyDepartment;
    }

    public void setItCompanyDepartment(ItCompanyDepartment itCompanyDepartment) {
        this.itCompanyDepartment = itCompanyDepartment;
    }

    public ClientDetails getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientId, client.clientId) && clientName.equals(client.clientName) && clientStartCooperationDate.equals(client.clientStartCooperationDate) && Objects.equals(itCompanyDepartment, client.itCompanyDepartment) && Objects.equals(clientDetails, client.clientDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, clientName, clientStartCooperationDate, itCompanyDepartment, clientDetails);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", clientStartCooperationDate=" + clientStartCooperationDate +
                ", itCompanyDepartment=" + itCompanyDepartment +
                ", clientDetails=" + clientDetails +
                '}';
    }
}

package com.aivaz.nurgaliev.itcompany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//TODO HASH EQUALS TOSTRING EVERYWHERE
@Entity
@Table(name = "it_company_department")
public class ItCompanyDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_location_city")
    @NotNull
    private String departmentLocationCity;

    @Column(name = "department_address")
    @NotNull
    private String departmentAddress;

    @Column(name = "department_phone_number")
    @NotNull
    private String departmentPhoneNumber;

    @Column(name = "department_email")
    @NotNull
    private String departmentEmail;

    @OneToMany(mappedBy = "itCompanyDepartment")
    //@JsonIgnore
    private List<DeveloperTeam> developerTeams = new ArrayList<>();

    @OneToMany(mappedBy = "itCompanyDepartment")
    //@JsonIgnore
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentLocationCity() {
        return departmentLocationCity;
    }

    public void setDepartmentLocationCity(String departmentLocationCity) {
        this.departmentLocationCity = departmentLocationCity;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentPhoneNumber() {
        return departmentPhoneNumber;
    }

    public void setDepartmentPhoneNumber(String departmentPhoneNumber) {
        this.departmentPhoneNumber = departmentPhoneNumber;
    }

    public String getDepartmentEmail() {
        return departmentEmail;
    }

    public void setDepartmentEmail(String departmentEmail) {
        this.departmentEmail = departmentEmail;
    }

    public List<DeveloperTeam> getDeveloperTeams() {
        return developerTeams;
    }

    public void setDeveloperTeams(List<DeveloperTeam> developerTeams) {
        this.developerTeams = developerTeams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItCompanyDepartment that = (ItCompanyDepartment) o;
        return Objects.equals(departmentId, that.departmentId) && departmentLocationCity.equals(that.departmentLocationCity) && departmentAddress.equals(that.departmentAddress) && departmentPhoneNumber.equals(that.departmentPhoneNumber) && departmentEmail.equals(that.departmentEmail) && Objects.equals(developerTeams, that.developerTeams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentLocationCity, departmentAddress, departmentPhoneNumber, departmentEmail, developerTeams);
    }

    @Override
    public String toString() {
        return "ItCompanyDepartment{" +
                "departmentId=" + departmentId +
                ", departmentLocationCity='" + departmentLocationCity + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentPhoneNumber='" + departmentPhoneNumber + '\'' +
                ", departmentEmail='" + departmentEmail + '\'' +
                ", developerTeams=" + developerTeams +
                '}';
    }
}

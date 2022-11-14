package com.aivaz.nurgaliev.itcompany.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "developer_details")
public class DeveloperDetails {

    @Id
    @Column(name = "developer_id")
    private Integer developerId;

    @Column(name = "developer_firstname")
    @NotNull
    private String developerFirstname;

    @Column(name = "developer_lastname")
    @NotNull
    private String developerLastname;

    @Column(name = "developer_email")
    @NotNull
    private String developerEmail;

    @Column(name = "developer_phone_number")
    @NotNull
    private String developerPhoneNumber;

    @Column(name = "developer_salary")
    @NotNull
    private int developerSalary;

    @OneToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "developer_id", nullable = false)
    private Developer developer;

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperFirstname() {
        return developerFirstname;
    }

    public void setDeveloperFirstname(String developerFirstname) {
        this.developerFirstname = developerFirstname;
    }

    public String getDeveloperLastname() {
        return developerLastname;
    }

    public void setDeveloperLastname(String developerLastname) {
        this.developerLastname = developerLastname;
    }

    public String getDeveloperEmail() {
        return developerEmail;
    }

    public void setDeveloperEmail(String developerEmail) {
        this.developerEmail = developerEmail;
    }

    public String getDeveloperPhoneNumber() {
        return developerPhoneNumber;
    }

    public void setDeveloperPhoneNumber(String developerPhoneNumber) {
        this.developerPhoneNumber = developerPhoneNumber;
    }

    public int getDeveloperSalary() {
        return developerSalary;
    }

    public void setDeveloperSalary(int developerSalary) {
        this.developerSalary = developerSalary;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeveloperDetails that = (DeveloperDetails) o;
        return developerSalary == that.developerSalary && Objects.equals(developerId, that.developerId) && developerFirstname.equals(that.developerFirstname) && developerLastname.equals(that.developerLastname) && developerEmail.equals(that.developerEmail) && developerPhoneNumber.equals(that.developerPhoneNumber) && developer.equals(that.developer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(developerId, developerFirstname, developerLastname, developerEmail, developerPhoneNumber, developerSalary, developer);
    }

    @Override
    public String toString() {
        return "DeveloperDetails{" +
                "developerId=" + developerId +
                ", developerFirstname='" + developerFirstname + '\'' +
                ", developerLastname='" + developerLastname + '\'' +
                ", developerEmail='" + developerEmail + '\'' +
                ", developerPhoneNumber='" + developerPhoneNumber + '\'' +
                ", developerSalary=" + developerSalary +
                ", developer=" + developer +
                '}';
    }
}

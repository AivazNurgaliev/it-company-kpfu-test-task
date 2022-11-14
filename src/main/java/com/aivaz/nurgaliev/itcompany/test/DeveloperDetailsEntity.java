/*
package com.aivaz.nurgaliev.itcompany.test;

import javax.persistence.*;

@Entity
@Table(name = "developer_details", schema = "public", catalog = "test_task_KPFU")
public class DeveloperDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "developer_id")
    private int developerId;
    @Basic
    @Column(name = "developer_firstname")
    private String developerFirstname;
    @Basic
    @Column(name = "developer_secondname")
    private String developerSecondname;
    @Basic
    @Column(name = "developer_email")
    private String developerEmail;
    @Basic
    @Column(name = "developer_phone_number")
    private String developerPhoneNumber;
    @Basic
    @Column(name = "developer_salary")
    private int developerSalary;
    @OneToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "developer_id", nullable = false)
    private DeveloperEntity developerByDeveloperId;

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperFirstname() {
        return developerFirstname;
    }

    public void setDeveloperFirstname(String developerFirstname) {
        this.developerFirstname = developerFirstname;
    }

    public String getDeveloperSecondname() {
        return developerSecondname;
    }

    public void setDeveloperSecondname(String developerSecondname) {
        this.developerSecondname = developerSecondname;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeveloperDetailsEntity that = (DeveloperDetailsEntity) o;

        if (developerId != that.developerId) return false;
        if (developerSalary != that.developerSalary) return false;
        if (developerFirstname != null ? !developerFirstname.equals(that.developerFirstname) : that.developerFirstname != null)
            return false;
        if (developerSecondname != null ? !developerSecondname.equals(that.developerSecondname) : that.developerSecondname != null)
            return false;
        if (developerEmail != null ? !developerEmail.equals(that.developerEmail) : that.developerEmail != null)
            return false;
        if (developerPhoneNumber != null ? !developerPhoneNumber.equals(that.developerPhoneNumber) : that.developerPhoneNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = developerId;
        result = 31 * result + (developerFirstname != null ? developerFirstname.hashCode() : 0);
        result = 31 * result + (developerSecondname != null ? developerSecondname.hashCode() : 0);
        result = 31 * result + (developerEmail != null ? developerEmail.hashCode() : 0);
        result = 31 * result + (developerPhoneNumber != null ? developerPhoneNumber.hashCode() : 0);
        result = 31 * result + developerSalary;
        return result;
    }

    public DeveloperEntity getDeveloperByDeveloperId() {
        return developerByDeveloperId;
    }

    public void setDeveloperByDeveloperId(DeveloperEntity developerByDeveloperId) {
        this.developerByDeveloperId = developerByDeveloperId;
    }
}
*/

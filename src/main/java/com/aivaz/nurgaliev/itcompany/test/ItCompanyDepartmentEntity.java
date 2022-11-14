/*
package com.aivaz.nurgaliev.itcompany.test;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "it_company_department", schema = "public", catalog = "test_task_KPFU")
public class ItCompanyDepartmentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "department_id")
    private int departmentId;
    @Basic
    @Column(name = "department_location_city")
    private String departmentLocationCity;
    @Basic
    @Column(name = "department_address")
    private String departmentAddress;
    @Basic
    @Column(name = "department_phone_number")
    private String departmentPhoneNumber;
    @Basic
    @Column(name = "department_email")
    private String departmentEmail;
    @OneToMany(mappedBy = "itCompanyDepartmentByDepartmentId")
    private Collection<DeveloperTeamEntity> developerTeamsByDepartmentId;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItCompanyDepartmentEntity that = (ItCompanyDepartmentEntity) o;

        if (departmentId != that.departmentId) return false;
        if (departmentLocationCity != null ? !departmentLocationCity.equals(that.departmentLocationCity) : that.departmentLocationCity != null)
            return false;
        if (departmentAddress != null ? !departmentAddress.equals(that.departmentAddress) : that.departmentAddress != null)
            return false;
        if (departmentPhoneNumber != null ? !departmentPhoneNumber.equals(that.departmentPhoneNumber) : that.departmentPhoneNumber != null)
            return false;
        if (departmentEmail != null ? !departmentEmail.equals(that.departmentEmail) : that.departmentEmail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId;
        result = 31 * result + (departmentLocationCity != null ? departmentLocationCity.hashCode() : 0);
        result = 31 * result + (departmentAddress != null ? departmentAddress.hashCode() : 0);
        result = 31 * result + (departmentPhoneNumber != null ? departmentPhoneNumber.hashCode() : 0);
        result = 31 * result + (departmentEmail != null ? departmentEmail.hashCode() : 0);
        return result;
    }

    public Collection<DeveloperTeamEntity> getDeveloperTeamsByDepartmentId() {
        return developerTeamsByDepartmentId;
    }

    public void setDeveloperTeamsByDepartmentId(Collection<DeveloperTeamEntity> developerTeamsByDepartmentId) {
        this.developerTeamsByDepartmentId = developerTeamsByDepartmentId;
    }
}
*/

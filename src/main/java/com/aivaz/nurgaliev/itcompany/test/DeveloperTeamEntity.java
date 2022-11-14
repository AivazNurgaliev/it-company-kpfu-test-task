/*
package com.aivaz.nurgaliev.itcompany.test;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "developer_team", schema = "public", catalog = "test_task_KPFU")
public class DeveloperTeamEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "team_id")
    private int teamId;
    @Basic
    @Column(name = "department_id")
    private Integer departmentId;
    @Basic
    @Column(name = "team_name")
    private String teamName;
    @Basic
    @Column(name = "team_foundation_date")
    private Date teamFoundationDate;
    @OneToMany(mappedBy = "developerTeamByTeamId")
    private Collection<ClientEntity> clientsByTeamId;
    @OneToMany(mappedBy = "developerTeamByTeamId")
    private Collection<DeveloperEntity> developersByTeamId;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private ItCompanyDepartmentEntity itCompanyDepartmentByDepartmentId;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getTeamFoundationDate() {
        return teamFoundationDate;
    }

    public void setTeamFoundationDate(Date teamFoundationDate) {
        this.teamFoundationDate = teamFoundationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeveloperTeamEntity that = (DeveloperTeamEntity) o;

        if (teamId != that.teamId) return false;
        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (teamName != null ? !teamName.equals(that.teamName) : that.teamName != null) return false;
        if (teamFoundationDate != null ? !teamFoundationDate.equals(that.teamFoundationDate) : that.teamFoundationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teamId;
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (teamFoundationDate != null ? teamFoundationDate.hashCode() : 0);
        return result;
    }

    public Collection<ClientEntity> getClientsByTeamId() {
        return clientsByTeamId;
    }

    public void setClientsByTeamId(Collection<ClientEntity> clientsByTeamId) {
        this.clientsByTeamId = clientsByTeamId;
    }

    public Collection<DeveloperEntity> getDevelopersByTeamId() {
        return developersByTeamId;
    }

    public void setDevelopersByTeamId(Collection<DeveloperEntity> developersByTeamId) {
        this.developersByTeamId = developersByTeamId;
    }

    public ItCompanyDepartmentEntity getItCompanyDepartmentByDepartmentId() {
        return itCompanyDepartmentByDepartmentId;
    }

    public void setItCompanyDepartmentByDepartmentId(ItCompanyDepartmentEntity itCompanyDepartmentByDepartmentId) {
        this.itCompanyDepartmentByDepartmentId = itCompanyDepartmentByDepartmentId;
    }
}
*/

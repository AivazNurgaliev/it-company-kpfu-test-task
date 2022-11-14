/*
package com.aivaz.nurgaliev.itcompany.test;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "developer", schema = "public", catalog = "test_task_KPFU")
public class DeveloperEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "developer_id")
    private int developerId;
    @Basic
    @Column(name = "team_id")
    private Integer teamId;
    @Basic
    @Column(name = "developer_employment_date")
    private Date developerEmploymentDate;
    @Basic
    @Column(name = "developer_occupation")
    private String developerOccupation;
    @Basic
    @Column(name = "developer_role")
    private String developerRole;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private DeveloperTeamEntity developerTeamByTeamId;
    @OneToOne(mappedBy = "developerByDeveloperId")
    private DeveloperDetailsEntity developerDetailsByDeveloperId;
    @OneToOne(mappedBy = "developerByDeveloperId")
    private DeveloperPerfomanceReviewEntity developerPerfomanceReviewByDeveloperId;

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Date getDeveloperEmploymentDate() {
        return developerEmploymentDate;
    }

    public void setDeveloperEmploymentDate(Date developerEmploymentDate) {
        this.developerEmploymentDate = developerEmploymentDate;
    }

    public String getDeveloperOccupation() {
        return developerOccupation;
    }

    public void setDeveloperOccupation(String developerOccupation) {
        this.developerOccupation = developerOccupation;
    }

    public String getDeveloperRole() {
        return developerRole;
    }

    public void setDeveloperRole(String developerRole) {
        this.developerRole = developerRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeveloperEntity that = (DeveloperEntity) o;

        if (developerId != that.developerId) return false;
        if (teamId != null ? !teamId.equals(that.teamId) : that.teamId != null) return false;
        if (developerEmploymentDate != null ? !developerEmploymentDate.equals(that.developerEmploymentDate) : that.developerEmploymentDate != null)
            return false;
        if (developerOccupation != null ? !developerOccupation.equals(that.developerOccupation) : that.developerOccupation != null)
            return false;
        if (developerRole != null ? !developerRole.equals(that.developerRole) : that.developerRole != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = developerId;
        result = 31 * result + (teamId != null ? teamId.hashCode() : 0);
        result = 31 * result + (developerEmploymentDate != null ? developerEmploymentDate.hashCode() : 0);
        result = 31 * result + (developerOccupation != null ? developerOccupation.hashCode() : 0);
        result = 31 * result + (developerRole != null ? developerRole.hashCode() : 0);
        return result;
    }

    public DeveloperTeamEntity getDeveloperTeamByTeamId() {
        return developerTeamByTeamId;
    }

    public void setDeveloperTeamByTeamId(DeveloperTeamEntity developerTeamByTeamId) {
        this.developerTeamByTeamId = developerTeamByTeamId;
    }

    public DeveloperDetailsEntity getDeveloperDetailsByDeveloperId() {
        return developerDetailsByDeveloperId;
    }

    public void setDeveloperDetailsByDeveloperId(DeveloperDetailsEntity developerDetailsByDeveloperId) {
        this.developerDetailsByDeveloperId = developerDetailsByDeveloperId;
    }

    public DeveloperPerfomanceReviewEntity getDeveloperPerfomanceReviewByDeveloperId() {
        return developerPerfomanceReviewByDeveloperId;
    }

    public void setDeveloperPerfomanceReviewByDeveloperId(DeveloperPerfomanceReviewEntity developerPerfomanceReviewByDeveloperId) {
        this.developerPerfomanceReviewByDeveloperId = developerPerfomanceReviewByDeveloperId;
    }
}
*/

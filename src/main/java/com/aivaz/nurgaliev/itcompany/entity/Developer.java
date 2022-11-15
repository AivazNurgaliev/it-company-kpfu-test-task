package com.aivaz.nurgaliev.itcompany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_id")
    private Integer developerId;

    @Column(name = "developer_employment_date")
    @NotNull
    private Date developerEmploymentDate;

    @Column(name = "developer_occupation")
    @NotNull
    private String developerOccupation;

    @Column(name = "developer_role")
    @NotNull
    private String developerRole;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    @JsonIgnore
    private DeveloperTeam developerTeam;

    @OneToOne(mappedBy = "developer")
    private DeveloperDetails developerDetails;

    @OneToOne(mappedBy = "developer")
    private DeveloperPerformanceReview developerPerformanceReview;

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
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

    public DeveloperTeam getDeveloperTeam() {
        return developerTeam;
    }

    public void setDeveloperTeam(DeveloperTeam developerTeam) {
        this.developerTeam = developerTeam;
    }

    public DeveloperDetails getDeveloperDetails() {
        return developerDetails;
    }

    public void setDeveloperDetails(DeveloperDetails developerDetails) {
        this.developerDetails = developerDetails;
    }

    public DeveloperPerformanceReview getDeveloperPerformanceReview() {
        return developerPerformanceReview;
    }

    public void setDeveloperPerformanceReview(DeveloperPerformanceReview developerPerformanceReview) {
        this.developerPerformanceReview = developerPerformanceReview;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return Objects.equals(developerId, developer.developerId) && developerEmploymentDate.equals(developer.developerEmploymentDate) && developerOccupation.equals(developer.developerOccupation) && developerRole.equals(developer.developerRole) && Objects.equals(developerTeam, developer.developerTeam) && Objects.equals(developerDetails, developer.developerDetails) && Objects.equals(developerPerformanceReview, developer.developerPerformanceReview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(developerId, developerEmploymentDate, developerOccupation, developerRole, developerTeam, developerDetails, developerPerformanceReview);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "developerId=" + developerId +
                ", developerEmploymentDate=" + developerEmploymentDate +
                ", developerOccupation='" + developerOccupation + '\'' +
                ", developerRole='" + developerRole + '\'' +
                ", developerTeam=" + developerTeam +
                ", developerDetails=" + developerDetails +
                ", developerPerformanceReview=" + developerPerformanceReview +
                '}';
    }
}

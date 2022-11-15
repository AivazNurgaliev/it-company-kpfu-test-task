package com.aivaz.nurgaliev.itcompany.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "developer_team")
public class DeveloperTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "team_name", unique = true)
    @NotNull
    private String teamName;

    @Column(name = "team_foundation_date")
    @NotNull
    private Date teamFoundationDate;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @JsonIgnore
    private ItCompanyDepartment itCompanyDepartment;

    @OneToMany(mappedBy = "developerTeam")
    private List<Developer> developers;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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

    public ItCompanyDepartment getItCompanyDepartment() {
        return itCompanyDepartment;
    }

    public void setItCompanyDepartment(ItCompanyDepartment itCompanyDepartment) {
        this.itCompanyDepartment = itCompanyDepartment;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeveloperTeam that = (DeveloperTeam) o;
        return Objects.equals(teamId, that.teamId) && teamName.equals(that.teamName) && teamFoundationDate.equals(that.teamFoundationDate) && Objects.equals(itCompanyDepartment, that.itCompanyDepartment) && Objects.equals(developers, that.developers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, teamName, teamFoundationDate, itCompanyDepartment, developers);
    }

    @Override
    public String toString() {
        return "DeveloperTeam{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamFoundationDate=" + teamFoundationDate +
                ", itCompanyDepartment=" + itCompanyDepartment +
                ", developers=" + developers +
                '}';
    }
}

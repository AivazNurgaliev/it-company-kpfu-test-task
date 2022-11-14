/*
package com.aivaz.nurgaliev.itcompany.test;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "client", schema = "public", catalog = "test_task_KPFU")
public class ClientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "client_id")
    private int clientId;
    @Basic
    @Column(name = "team_id")
    private Integer teamId;
    @Basic
    @Column(name = "client_name")
    private String clientName;
    @Basic
    @Column(name = "client_start_cooperation_date")
    private Date clientStartCooperationDate;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private DeveloperTeamEntity developerTeamByTeamId;
    @OneToOne(mappedBy = "clientByClientId")
    private ClientDetailsEntity clientDetailsByClientId;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (clientId != that.clientId) return false;
        if (teamId != null ? !teamId.equals(that.teamId) : that.teamId != null) return false;
        if (clientName != null ? !clientName.equals(that.clientName) : that.clientName != null) return false;
        if (clientStartCooperationDate != null ? !clientStartCooperationDate.equals(that.clientStartCooperationDate) : that.clientStartCooperationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (teamId != null ? teamId.hashCode() : 0);
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientStartCooperationDate != null ? clientStartCooperationDate.hashCode() : 0);
        return result;
    }

    public DeveloperTeamEntity getDeveloperTeamByTeamId() {
        return developerTeamByTeamId;
    }

    public void setDeveloperTeamByTeamId(DeveloperTeamEntity developerTeamByTeamId) {
        this.developerTeamByTeamId = developerTeamByTeamId;
    }

    public ClientDetailsEntity getClientDetailsByClientId() {
        return clientDetailsByClientId;
    }

    public void setClientDetailsByClientId(ClientDetailsEntity clientDetailsByClientId) {
        this.clientDetailsByClientId = clientDetailsByClientId;
    }
}
*/

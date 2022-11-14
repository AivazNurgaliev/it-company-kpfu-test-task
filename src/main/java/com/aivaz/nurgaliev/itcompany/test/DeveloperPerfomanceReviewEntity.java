/*
package com.aivaz.nurgaliev.itcompany.test;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "developer_perfomance_review", schema = "public", catalog = "test_task_KPFU")
public class DeveloperPerfomanceReviewEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "developer_id")
    private int developerId;
    @Basic
    @Column(name = "dpr_rating")
    private BigInteger dprRating;
    @Basic
    @Column(name = "dpr_description")
    private String dprDescription;
    @OneToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "developer_id", nullable = false)
    private DeveloperEntity developerByDeveloperId;

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public BigInteger getDprRating() {
        return dprRating;
    }

    public void setDprRating(BigInteger dprRating) {
        this.dprRating = dprRating;
    }

    public String getDprDescription() {
        return dprDescription;
    }

    public void setDprDescription(String dprDescription) {
        this.dprDescription = dprDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeveloperPerfomanceReviewEntity that = (DeveloperPerfomanceReviewEntity) o;

        if (developerId != that.developerId) return false;
        if (dprRating != null ? !dprRating.equals(that.dprRating) : that.dprRating != null) return false;
        if (dprDescription != null ? !dprDescription.equals(that.dprDescription) : that.dprDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = developerId;
        result = 31 * result + (dprRating != null ? dprRating.hashCode() : 0);
        result = 31 * result + (dprDescription != null ? dprDescription.hashCode() : 0);
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

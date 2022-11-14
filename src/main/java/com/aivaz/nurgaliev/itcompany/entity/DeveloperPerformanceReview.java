package com.aivaz.nurgaliev.itcompany.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "developer_performance_review")
public class DeveloperPerformanceReview {

    @Id
    @Column(name = "developer_id")
    private Integer developerId;

    @Column(name = "dpr_rating")
    @NotNull
    private BigDecimal dbrRating;

    @Column(name = "dpr_description")
    private String dprDescription;

    @OneToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "developer_id", nullable = false)
    private Developer developer;

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public BigDecimal getDbrRating() {
        return dbrRating;
    }

    public void setDbrRating(BigDecimal dbrRating) {
        this.dbrRating = dbrRating;
    }

    public String getDprDescription() {
        return dprDescription;
    }

    public void setDprDescription(String dprDescription) {
        this.dprDescription = dprDescription;
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
        DeveloperPerformanceReview that = (DeveloperPerformanceReview) o;
        return Objects.equals(developerId, that.developerId) && dbrRating.equals(that.dbrRating) && Objects.equals(dprDescription, that.dprDescription) && Objects.equals(developer, that.developer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(developerId, dbrRating, dprDescription, developer);
    }

    @Override
    public String toString() {
        return "DeveloperPerformanceReview{" +
                "developerId=" + developerId +
                ", dbrRating=" + dbrRating +
                ", dprDescription='" + dprDescription + '\'' +
                ", developer=" + developer +
                '}';
    }
}

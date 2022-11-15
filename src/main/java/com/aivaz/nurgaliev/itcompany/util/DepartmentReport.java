package com.aivaz.nurgaliev.itcompany.util;

import java.math.BigDecimal;

public class DepartmentReport {

    private Integer departmentId;
    private Integer monthlySalaryExpenses;
    private BigDecimal profitFromClients;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getMonthlySalaryExpenses() {
        return monthlySalaryExpenses;
    }

    public void setMonthlySalaryExpenses(Integer monthlySalaryExpenses) {
        this.monthlySalaryExpenses = monthlySalaryExpenses;
    }

    public BigDecimal getProfitFromClients() {
        return profitFromClients;
    }

    public void setProfitFromClients(BigDecimal profitFromClients) {
        this.profitFromClients = profitFromClients;
    }

    @Override
    public String toString() {
        return "DepartmentReport{" +
                "departmentId=" + departmentId +
                ", monthlyExpenses=" + monthlySalaryExpenses +
                ", profitFromClients=" + profitFromClients +
                '}';
    }
}

package com.aivaz.nurgaliev.itcompany.repository;

import com.aivaz.nurgaliev.itcompany.entity.ItCompanyDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItCompanyDepartmentRepository extends JpaRepository<ItCompanyDepartment, Integer> {

    ItCompanyDepartment findByDepartmentId(Integer departmentId);
    //List<ItCompanyDepartment> findAll(Integer departmentId);
}

package com.aivaz.nurgaliev.itcompany.repository;

import com.aivaz.nurgaliev.itcompany.entity.ItCompanyDepartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItCompanyDepartmentRepository extends JpaRepository<ItCompanyDepartment, Integer> {

    ItCompanyDepartment findByDepartmentId(Integer departmentId);
    Page<ItCompanyDepartment> findAll(Pageable pageable);
}

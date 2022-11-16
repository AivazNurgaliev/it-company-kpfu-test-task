package com.aivaz.nurgaliev.itcompany.repository;

import com.aivaz.nurgaliev.itcompany.entity.DeveloperTeam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperTeamRepository extends JpaRepository<DeveloperTeam, Integer> {
    DeveloperTeam findByTeamId(Integer teamId);
    Page<DeveloperTeam> findAllByItCompanyDepartment_DepartmentId(Integer departmentId, Pageable pageable);
}

package com.aivaz.nurgaliev.itcompany.repository;

import com.aivaz.nurgaliev.itcompany.entity.DeveloperTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperTeamRepository extends JpaRepository<DeveloperTeam, Integer> {

    DeveloperTeam findByTeamId(Integer teamId);
    //DeveloperTeam findByTeamIdIsNotContainingAndDevelopersAndClients(Integer teamId);
    List<DeveloperTeam> findByItCompanyDepartment_DepartmentId(Integer departmentId);
    //List<DeveloperTeam> findByI
}

package com.aivaz.nurgaliev.itcompany.repository;

import com.aivaz.nurgaliev.itcompany.entity.DeveloperTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperTeamRepository extends JpaRepository<DeveloperTeam, Integer> {
    DeveloperTeam findByTeamId(Integer teamId);
}

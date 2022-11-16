package com.aivaz.nurgaliev.itcompany.repository;

import com.aivaz.nurgaliev.itcompany.entity.Developer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

    Developer findByDeveloperId(Integer developerId);
    List<Developer> findByDeveloperTeam_TeamId(Integer teamId);
    Page<Developer> findByDeveloperTeam_TeamId(Integer teamId, Pageable pageable);
}

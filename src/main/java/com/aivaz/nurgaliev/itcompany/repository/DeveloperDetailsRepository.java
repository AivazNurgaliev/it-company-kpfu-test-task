package com.aivaz.nurgaliev.itcompany.repository;

import com.aivaz.nurgaliev.itcompany.entity.DeveloperDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperDetailsRepository extends JpaRepository<DeveloperDetails, Integer> {

    DeveloperDetails findByDeveloper_DeveloperId(Integer developerId);
}

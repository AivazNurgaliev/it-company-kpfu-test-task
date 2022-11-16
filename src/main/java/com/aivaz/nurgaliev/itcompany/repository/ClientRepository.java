package com.aivaz.nurgaliev.itcompany.repository;

import com.aivaz.nurgaliev.itcompany.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByClientId(Integer clientId);
    List<Client> findClientsByItCompanyDepartment_DepartmentId(Integer departmentId);
    Page<Client> findClientsByItCompanyDepartment_DepartmentId(Integer departmentId, Pageable pageable);
    Page<Client> findAll(Pageable pageable);
}

package com.aivaz.nurgaliev.itcompany.repository;

import com.aivaz.nurgaliev.itcompany.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByClientId(Integer clientId);
    //List<Client> findAll();
}

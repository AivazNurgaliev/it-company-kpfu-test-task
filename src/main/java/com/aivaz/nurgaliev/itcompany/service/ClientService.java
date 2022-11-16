package com.aivaz.nurgaliev.itcompany.service;

import com.aivaz.nurgaliev.itcompany.entity.Client;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.repository.ClientRepository;
import com.aivaz.nurgaliev.itcompany.util.PageAndEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientById(Integer clientId) throws DataNotFoundException {
        Client client = clientRepository.findByClientId(clientId);

        if (client == null) {
            throw new DataNotFoundException("Client does not exist or invalid clientId");
        }

        return client;
    }

    public PageAndEntityResponse<Client> getAllClients(Integer pageNo,
                                                       Integer pageSize,
                                                       String sortBy) throws DataNotFoundException {

        Pageable paging;
        if (sortBy.startsWith("-")) {
            StringBuilder sb = new StringBuilder(sortBy);
            sortBy = sb.deleteCharAt(0).toString();
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        } else {
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        }

        Page<Client> pagedResult = clientRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            PageAndEntityResponse<Client> clientPage = new PageAndEntityResponse<>();
            clientPage.setTotalPages(pagedResult.getTotalPages());
            clientPage.setTotalElements(pagedResult.getTotalElements());
            clientPage.setEntity(pagedResult.getContent());

            return clientPage;
        } else {
            throw new DataNotFoundException("There's no clients in database or " +
                    "Invalid paging or sorting params or content does not exist");
        }
    }

    public PageAndEntityResponse<Client> getAllClientsByDepartmentId(Integer departmentId, Integer pageNo,
                                                    Integer pageSize,
                                                    String sortBy) throws DataNotFoundException {

        Pageable paging;
        if (sortBy.startsWith("-")) {
            StringBuilder sb = new StringBuilder(sortBy);
            sortBy = sb.deleteCharAt(0).toString();
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        } else {
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        }

        Page<Client> pagedResult = clientRepository.findClientsByItCompanyDepartment_DepartmentId(departmentId, paging);
        if (pagedResult.hasContent()) {
            PageAndEntityResponse<Client> clientPage = new PageAndEntityResponse<>();
            clientPage.setTotalPages(pagedResult.getTotalPages());
            clientPage.setTotalElements(pagedResult.getTotalElements());
            clientPage.setEntity(pagedResult.getContent());

            return clientPage;
        } else {
            throw new DataNotFoundException("There's no clients in database or " +
                    "Invalid paging or sorting params or content does not exist");
        }
    }
}

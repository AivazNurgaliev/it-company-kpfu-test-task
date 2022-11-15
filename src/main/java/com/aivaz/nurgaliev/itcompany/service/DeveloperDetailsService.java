package com.aivaz.nurgaliev.itcompany.service;

import com.aivaz.nurgaliev.itcompany.entity.DeveloperDetails;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.repository.DeveloperDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperDetailsService {

    private final DeveloperDetailsRepository developerDetailsRepository;

    @Autowired
    public DeveloperDetailsService(DeveloperDetailsRepository developerDetailsRepository) {
        this.developerDetailsRepository = developerDetailsRepository;
    }

    public DeveloperDetails getDeveloperDetailsById(Integer developerId) throws DataNotFoundException {
        DeveloperDetails developerDetails = developerDetailsRepository.findByDeveloper_DeveloperId(developerId);

        if (developerDetails == null) {
            throw new DataNotFoundException("Developer Details does not exist, probably invalid developerId");
        }

        return developerDetails;
    }
}

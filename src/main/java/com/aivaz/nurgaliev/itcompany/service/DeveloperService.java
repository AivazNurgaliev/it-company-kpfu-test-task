package com.aivaz.nurgaliev.itcompany.service;

import com.aivaz.nurgaliev.itcompany.entity.Developer;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer getDeveloperById(Integer developerId) throws DataNotFoundException {
        Developer developer = developerRepository.findByDeveloperId(developerId);

        if (developer == null) {
            throw new DataNotFoundException("Developer does not exist or invalid developerId");
        }

        return developer;
    }

    public List<Developer> getAllDevelopersByTeamId(Integer teamId) throws DataNotFoundException {
        List<Developer> developers = developerRepository.findByDeveloperTeam_TeamId(teamId);

        if (developers == null || developers.size() == 0) {
            //System.out.println("Developer In this team does not exist, wrong teamId");
            throw new DataNotFoundException("Developer In this team does not exist or invalid teamId");
        }

        return developers;
    }
}

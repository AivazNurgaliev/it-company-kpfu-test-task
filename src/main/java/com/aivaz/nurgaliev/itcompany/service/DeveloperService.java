package com.aivaz.nurgaliev.itcompany.service;

import com.aivaz.nurgaliev.itcompany.entity.Developer;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.repository.DeveloperRepository;
import com.aivaz.nurgaliev.itcompany.util.PageAndEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public PageAndEntityResponse<Developer> getAllDevelopersByTeamIdPage(Integer teamId,
                                                                         Integer pageNo,
                                                                         Integer pageSize,
                                                                         String sortBy)
            throws DataNotFoundException {

        Pageable paging;
        if (sortBy.startsWith("-")) {
            StringBuilder sb = new StringBuilder(sortBy);
            sortBy = sb.deleteCharAt(0).toString();
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        } else {
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        }

        Page<Developer> pagedResult = developerRepository.findByDeveloperTeam_TeamId(teamId, paging);
        if (pagedResult.hasContent()) {
            PageAndEntityResponse<Developer> developerPage = new PageAndEntityResponse<>();
            developerPage.setTotalPages(pagedResult.getTotalPages());
            developerPage.setTotalElements(pagedResult.getTotalElements());
            developerPage.setEntity(pagedResult.getContent());

            return developerPage;
        } else {
            throw new DataNotFoundException("Invalid paging or sorting params or content does not exist");
        }
    }
}


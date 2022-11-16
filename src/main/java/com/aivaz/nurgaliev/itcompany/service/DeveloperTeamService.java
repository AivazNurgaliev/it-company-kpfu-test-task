package com.aivaz.nurgaliev.itcompany.service;

import com.aivaz.nurgaliev.itcompany.entity.DeveloperTeam;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.repository.DeveloperTeamRepository;
import com.aivaz.nurgaliev.itcompany.util.PageAndEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DeveloperTeamService {

    private final DeveloperTeamRepository teamRepository;

    @Autowired
    public DeveloperTeamService(DeveloperTeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public DeveloperTeam getTeamById(Integer teamId) throws DataNotFoundException {
        DeveloperTeam developerTeam = teamRepository.findByTeamId(teamId);

        if (developerTeam == null) {
            throw new DataNotFoundException("Developer Team does not exist or invalid teamId");
        }

        return developerTeam;
    }

    public PageAndEntityResponse<DeveloperTeam> getAllTeams(Integer pageNo,
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

        Page<DeveloperTeam> pagedResult = teamRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            PageAndEntityResponse<DeveloperTeam> developerTeamsPage = new PageAndEntityResponse<>();
            developerTeamsPage.setTotalPages(pagedResult.getTotalPages());
            developerTeamsPage.setTotalElements(pagedResult.getTotalElements());
            developerTeamsPage.setEntity(pagedResult.getContent());

            return developerTeamsPage;
        } else {
            throw new DataNotFoundException("There's no developer teams in database or " +
                    "Invalid paging or sorting params or content does not exist");
        }
    }

    public PageAndEntityResponse<DeveloperTeam> getAllTeamsByDepartmentId(Integer departmentId,
                                                                          Integer pageNo,
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

        Page<DeveloperTeam> pagedResult = teamRepository.findAllByItCompanyDepartment_DepartmentId(departmentId, paging);
        if (pagedResult.hasContent()) {
            PageAndEntityResponse<DeveloperTeam> developerTeamsByDepartmentIdPage = new PageAndEntityResponse<>();
            developerTeamsByDepartmentIdPage.setTotalPages(pagedResult.getTotalPages());
            developerTeamsByDepartmentIdPage.setTotalElements(pagedResult.getTotalElements());
            developerTeamsByDepartmentIdPage.setEntity(pagedResult.getContent());

            return developerTeamsByDepartmentIdPage;
        } else {
            throw new DataNotFoundException("There's no developer teams in database or " +
                    "Invalid paging or sorting params or content does not exist");
        }
    }
}

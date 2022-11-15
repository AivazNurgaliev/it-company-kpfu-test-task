package com.aivaz.nurgaliev.itcompany.service;

import com.aivaz.nurgaliev.itcompany.entity.DeveloperTeam;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.repository.DeveloperTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<DeveloperTeam> getAllTeams() throws DataNotFoundException {
        List<DeveloperTeam> developerTeams = teamRepository.findAll();

        if (developerTeams == null || developerTeams.size() == 0) {
            throw new DataNotFoundException("There's no developer teams in database");
        }

        return developerTeams;
    }
}

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
            throw new DataNotFoundException("Developer Team does not exist probably wrong teamId");
        }

        return developerTeam;
    }

/*    public DeveloperTeam getTeamByIdExclude(Integer teamId) throws DataNotFoundException {
        DeveloperTeam developerTeam = teamRepository.findByTeamIdIsNotContainingAndDevelopersAndClients(teamId);

        if (developerTeam == null) {
            throw new DataNotFoundException("Developer Team does not exist probably wrong teamId");
        }

        return developerTeam;
    }*/

    public List<DeveloperTeam> getAllTeams() throws DataNotFoundException {
        List<DeveloperTeam> developerTeams = teamRepository.findAll();

        if (developerTeams == null) {
            throw new DataNotFoundException("There's no developer teams in database");
        }

        return developerTeams;
    }

    public List<DeveloperTeam> getAllTeamsByDepartmentId(Integer departmentId) throws DataNotFoundException {
        List<DeveloperTeam> developerTeams = teamRepository.findByItCompanyDepartment_DepartmentId(departmentId);
        if (developerTeams == null || developerTeams.size() == 0) {
            throw new DataNotFoundException("Wrong id, or there's no teams in this department");
        }

        return developerTeams;
    }

    //
/*    public List<DeveloperTeam> getDevAndDetails(Integer developerId) throws DataNotFoundException {

        if (developerTeam == null) {
            throw new DataNotFoundException("Developer Team does not exist probably wrong teamId");
        }

        return developerTeams;
    }*/
}

package com.aivaz.nurgaliev.itcompany.controller;

import com.aivaz.nurgaliev.itcompany.entity.DeveloperDetails;
import com.aivaz.nurgaliev.itcompany.entity.DeveloperTeam;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.service.DeveloperDetailsService;
import com.aivaz.nurgaliev.itcompany.service.DeveloperTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DeveloperTeamController {

    private final DeveloperTeamService teamService;
    private final DeveloperDetailsService developerDetailsService;

    @Autowired
    public DeveloperTeamController(DeveloperTeamService teamService, DeveloperDetailsService developerDetailsService) {
        this.teamService = teamService;
        this.developerDetailsService = developerDetailsService;
    }


    @GetMapping("/team/{teamId}")
    public DeveloperTeam getTeamById(@PathVariable(name = "teamId") Integer teamId) {
        try {
            return teamService.getTeamById(teamId);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

/*
    @GetMapping("/team/{teamId}/exclude")
    public DeveloperTeam getTeamByIdExclude(@PathVariable(name = "teamId") Integer teamId) {
        try {
            return teamService.getTeamByIdExclude(teamId);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
*/

    @GetMapping("/teams")
    public List<DeveloperTeam> getAllTeams() {
        try {
            return teamService.getAllTeams();
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

/*    @GetMapping("/test/{departmentId}")
    public List<DeveloperTeam> getAllTeamsByDepartmentId(@PathVariable(name = "departmentId") Integer departmentId) {
        try {
            return teamService.getAllTeamsByDepartmentId(departmentId);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/det/{developerId}")
    public DeveloperDetails getDevDet(@PathVariable(name = "developerId") Integer developerId) {
        try {
            return developerDetailsService.getDeveloperDetailsById(developerId);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }*/
}

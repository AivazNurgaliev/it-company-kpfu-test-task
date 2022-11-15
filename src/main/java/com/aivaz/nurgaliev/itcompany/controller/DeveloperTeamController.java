package com.aivaz.nurgaliev.itcompany.controller;

import com.aivaz.nurgaliev.itcompany.entity.Developer;
import com.aivaz.nurgaliev.itcompany.entity.DeveloperTeam;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.service.DeveloperDetailsService;
import com.aivaz.nurgaliev.itcompany.service.DeveloperService;
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
    private final DeveloperService developerService;

    @Autowired
    public DeveloperTeamController(DeveloperTeamService teamService, DeveloperDetailsService developerDetailsService, DeveloperService developerService) {
        this.teamService = teamService;
        this.developerDetailsService = developerDetailsService;
        this.developerService = developerService;
    }

    /**
     * Получение Команды разработчиков по id команды
     * @param teamId - id команды(Integer)
     * @return
     * 200-Если запрос прошел успешно.
     * 404-Если был предоставлен неверный id команды (не существует команда).
     * 500-Ошибка вызванная сервером.
     */
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

    /**
     * Получение списка разработчиков определённой команды(id команды)
     * @param teamId - id команды(Integer)
     * @return
     * 200-Если запрос прошел успешно.
     * 404-Если был предоставлен неверный id команды (не существует команда или разработчики в ней).
     * 500-Ошибка вызванная сервером.
     */
    @GetMapping("/team/{teamId}/developers")
    public List<Developer> getAllDevelopersByTeamId(@PathVariable(name = "teamId") Integer teamId) {
        try {
            return developerService.getAllDevelopersByTeamId(teamId);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
     * Получение списка всех команд
     * @return
     * 200-Если запрос прошел успешно.
     * 404-Если был предоставлен неверный id команды (не существует команда или разработчики в ней).
     * 500-Ошибка вызванная сервером.
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
}

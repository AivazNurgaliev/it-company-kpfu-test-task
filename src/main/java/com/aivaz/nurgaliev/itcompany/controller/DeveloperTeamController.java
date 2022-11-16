package com.aivaz.nurgaliev.itcompany.controller;

import com.aivaz.nurgaliev.itcompany.entity.Developer;
import com.aivaz.nurgaliev.itcompany.entity.DeveloperTeam;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.service.DeveloperDetailsService;
import com.aivaz.nurgaliev.itcompany.service.DeveloperService;
import com.aivaz.nurgaliev.itcompany.service.DeveloperTeamService;
import com.aivaz.nurgaliev.itcompany.util.PageAndEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class DeveloperTeamController {

    private final DeveloperTeamService teamService;
    private final DeveloperDetailsService developerDetailsService;
    private final DeveloperService developerService;

    @Autowired
    public DeveloperTeamController(DeveloperTeamService teamService,
                                   DeveloperDetailsService developerDetailsService,
                                   DeveloperService developerService) {
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
     * Получение списка разработчиков определённой команды с возможностью пагинации и сортировки
     * @param teamId - id нужной команды
     * @param pageNo - номер страницы - по умолчанию 1
     * @param pageSize - размер страницы - по умолчанию 50
     * @param sortBy - сортировка по developerId или developerEmploymentDate в возрастающем порядке,
     *               в убывающем будет -developerId или -developerEmploymentDate
     *
     * Пример запроса:
     *  http://localhost:8080/team/4/developers?pageNo=1&pageSize=3&sortBy=developerId
     *  http://localhost:8080/team/4/developers?pageNo=1&pageSize=5&sortBy=-developerId
     *  http://localhost:8080/team/4/developers?pageNo=1&pageSize=1&sortBy=developerEmploymentDate
     *  http://localhost:8080/team/4/developers?pageNo=1&pageSize=3&sortBy=-developerEmploymentDate
     *
     * @return
     *      200-Если запрос прошел успешно.
     *      404-Если не существуют команды или разработчиков в ней.
     *      500-Ошибка вызванная сервером.
     */
    @GetMapping("/team/{teamId}/developers")
    public PageAndEntityResponse<Developer> getAllDevelopersByTeamId(@PathVariable(name = "teamId") Integer teamId,
                                                                     @RequestParam(defaultValue = "1") Integer pageNo,
                                                                     @RequestParam(defaultValue = "50") Integer pageSize,
                                                                     @RequestParam(defaultValue = "developerId") String sortBy) {
        try {
            return developerService.getAllDevelopersByTeamIdPage(teamId, pageNo - 1, pageSize, sortBy);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


    /**
     * Получение всех команд с возможностью пагинации и сортировки
     * @param pageNo - номер страницы - по умолчанию 1
     * @param pageSize - размер страницы - по умолчанию 50
     * @param sortBy - сортировка по teamId или teamFoundationDate в возрастающем порядке,
     *               в убывающем будет -teamId или -teamFoundationDate
     * Пример запроса:
     *  http://localhost:8080/teams?pageNo=3&pageSize=2&sortBy=teamId (сортировка по id возр.)
     *  http://localhost:8080/teams?pageNo=1&pageSize=1&sortBy=-teamId (сортировка по id убыв.)
     *  http://localhost:8080/teams?pageNo=4&pageSize=10&sortBy=teamFoundationDate (сортировка по teamFoundationDate возр.)
     *  http://localhost:8080/teams?pageNo=2&pageSize=50&sortBy=-teamFoundationDate (сортировка по teamFoundationDate убыв.)
     * @return
     *      200-Если запрос прошел успешно.
     *      404-Если не существуют команд.
     *      500-Ошибка вызванная сервером.
     */
    @GetMapping("/teams")
    public PageAndEntityResponse<DeveloperTeam> getAllTeams(@RequestParam(defaultValue = "1") Integer pageNo,
                                           @RequestParam(defaultValue = "50") Integer pageSize,
                                           @RequestParam(defaultValue = "teamId") String sortBy) {
        try {
            return teamService.getAllTeams(pageNo - 1, pageSize, sortBy);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}

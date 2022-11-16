package com.aivaz.nurgaliev.itcompany.controller;

import com.aivaz.nurgaliev.itcompany.entity.Client;
import com.aivaz.nurgaliev.itcompany.entity.DeveloperTeam;
import com.aivaz.nurgaliev.itcompany.entity.ItCompanyDepartment;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.service.ClientService;
import com.aivaz.nurgaliev.itcompany.service.DeveloperTeamService;
import com.aivaz.nurgaliev.itcompany.service.ItCompanyDepartmentService;
import com.aivaz.nurgaliev.itcompany.util.DepartmentReport;
import com.aivaz.nurgaliev.itcompany.util.PageAndEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ItCompanyDepartmentController {

    private final ItCompanyDepartmentService departmentService;
    private final ClientService clientService;
    private final DeveloperTeamService teamService;
    @Autowired
    public ItCompanyDepartmentController(ItCompanyDepartmentService departmentService,
                                         ClientService clientService,
                                         DeveloperTeamService teamService) {
        this.departmentService = departmentService;
        this.clientService = clientService;
        this.teamService = teamService;
    }

    /**
     * Получение отделения IT компании по id отделения
     * @param departmentId - id отдела(Integer)
     * @return
     * 200-Если запрос прошел успешно.
     * 404-Если был предоставлен неверный id отделения (не существует отделение).
     * 500-Ошибка вызванная сервером.
     */
    @GetMapping("/department/{departmentId}")
    public ItCompanyDepartment getDepartmentById(@PathVariable(name = "departmentId") Integer departmentId) {
        try {
            return departmentService.getDepartment(departmentId);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
     * Получение списка отделений нашей IT компании с возможностью пагинации и сортировки
     * @param pageNo - номер страницы - по умолчанию 1
     * @param pageSize - размер страницы - по умолчанию 50
     * @param sortBy - сортировка по departmentId
     *               в убывающем будет -departmentId
     *               остальные поля доступные сортировки: departmentLocationCity, departmentAddress,
     *               departmentPhoneNumber, departmentEmail
     *
     * Пример запроса:
     *  http://localhost:8080/departments?pageNo=1&pageSize=3&sortBy=departmentEmail
     *  http://localhost:8080/departments?pageNo=1&pageSize=3&sortBy=-departmentEmail
     *  http://localhost:8080/departments?pageNo=1&pageSize=3&sortBy=-departmentId
     *  http://localhost:8080/departments?pageNo=1&pageSize=3&sortBy=departmentId
     *
     * @return
     *      200-Если запрос прошел успешно.
     *      404-Если не существуют отделения.
     *      500-Ошибка вызванная сервером.
     */
    @GetMapping("/departments")
    public PageAndEntityResponse<ItCompanyDepartment> getAllDepartments(@RequestParam(defaultValue = "1") Integer pageNo,
                                                                        @RequestParam(defaultValue = "50") Integer pageSize,
                                                                        @RequestParam(defaultValue = "departmentId") String sortBy) {
        try {
            return departmentService.getAllDepartments(pageNo - 1, pageSize, sortBy);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


    /**
     * Получение списка клиентов у определённого отделения
     * @param departmentId - id отделения(Integer)
     * @param pageNo - номер страницы - по умолчанию 1
     * @param pageSize - размер страницы - по умолчанию 50
     * @param sortBy - сортировка по clientId или clientStartCooperationDate в возрастающем порядке,
     *               в убывающем будет -clientId или -clientStartCooperationDate
     *               остальные поля доступные сортировки: clientName
     *
     *Пример запроса:
     *  http://localhost:8080/department/2/clients?pageNo=1&pageSize=3&sortBy=clientStartCooperationDate
     *  http://localhost:8080/department/2/clients?pageNo=1&pageSize=3&sortBy=-clientStartCooperationDate
     *  http://localhost:8080/department/2/clients?pageNo=1&pageSize=3&sortBy=clientName
     *  http://localhost:8080/department/2/clients?pageNo=1&pageSize=3&sortBy=-clientId
     * @return
     * 200-Если запрос прошел успешно.
     * 404-Если был предоставлен неверный id отделения (не существует отделение или нет клиентов).
     * 500-Ошибка вызванная сервером.
     */
    @GetMapping("/department/{departmentId}/clients")
    public PageAndEntityResponse<Client> getAllClientsByDepartmentId(@PathVariable(name = "departmentId") Integer departmentId,
                                                                     @RequestParam(defaultValue = "1") Integer pageNo,
                                                                     @RequestParam(defaultValue = "50") Integer pageSize,
                                                                     @RequestParam(defaultValue = "clientId") String sortBy) {
        try {
            return clientService.getAllClientsByDepartmentId(departmentId, pageNo - 1, pageSize, sortBy);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
     * Получение команд у определённого офиса с возможностью пагинации и сортировки
     * @param departmentId - id нужного офиса/отделения
     * @param pageNo - номер страницы - по умолчанию 1
     * @param pageSize - размер страницы - по умолчанию 50
     * @param sortBy - сортировка по teamId или teamFoundationDate в возрастающем порядке,
     *               в убывающем будет -teamId или -teamFoundationDate
     *               остальные поля доступные сортировки: teamName
     * Пример запроса:
     *  http://localhost:8080/department/2/teams?pageNo=1&pageSize=3&sortBy=teamId
     *  http://localhost:8080/department/2/teams?pageNo=1&pageSize=3&sortBy=-teamId
     *  http://localhost:8080/department/2/teams?pageNo=1&pageSize=3&sortBy=-teamName
     *  http://localhost:8080/department/2/teams?pageNo=1&pageSize=3&sortBy=teamFoundationDate
     * @return
     * 200-Если запрос прошел успешно.
     * 404-Если был предоставлен неверный id отделения (не существует отделение или нет команд).
     * 500-Ошибка вызванная сервером.
     */
    @GetMapping("/department/{departmentId}/teams")
    public PageAndEntityResponse<DeveloperTeam> getAllTeamsByDepartmentId(@PathVariable(name = "departmentId") Integer departmentId,
                                                                          @RequestParam(defaultValue = "1") Integer pageNo,
                                                                          @RequestParam(defaultValue = "50") Integer pageSize,
                                                                          @RequestParam(defaultValue = "teamId") String sortBy) {
        try {
            return teamService.getAllTeamsByDepartmentId(departmentId, pageNo - 1, pageSize, sortBy);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
     * Финансовый отчёт для отделения
     * Получение отчёта для определённого отделения по расходам зарплат и доходам от заказчиков
     * @param departmentId
     * @return
     * 200-Если запрос прошел успешно.
     * 404-Если был предоставлен неверный id отделения (не существует отделение или нет клиентов).
     * 500-Ошибка вызванная сервером.
     */
    @GetMapping("/department/{departmentId}/report")
    public DepartmentReport getDepartmentReport(@PathVariable(name = "departmentId") Integer departmentId) {
        try {
            return departmentService.getDepartmentReport(departmentId);
        }  catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}

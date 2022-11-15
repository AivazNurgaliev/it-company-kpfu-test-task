package com.aivaz.nurgaliev.itcompany.controller;

import com.aivaz.nurgaliev.itcompany.entity.Client;
import com.aivaz.nurgaliev.itcompany.entity.ItCompanyDepartment;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.service.ClientService;
import com.aivaz.nurgaliev.itcompany.service.ItCompanyDepartmentService;
import com.aivaz.nurgaliev.itcompany.util.DepartmentReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ItCompanyDepartmentController {
    private final ItCompanyDepartmentService departmentService;
    private final ClientService clientService;
    @Autowired
    public ItCompanyDepartmentController(ItCompanyDepartmentService departmentService, ClientService clientService) {
        this.departmentService = departmentService;
        this.clientService = clientService;
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
     * Получение списка всех отделений
     * @return
     * 200-Если запрос прошел успешно.
     * 404-Если был предоставлен неверный id отделения (не существует отделение).
     * 500-Ошибка вызванная сервером.
     */
    @GetMapping("/departments")
    public List<ItCompanyDepartment> getAllDepartmentById() {
        try {
            return departmentService.getAllDepartments();
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
     * Получение списка всех клиентов у определённого отделения
     * @param departmentId - id отделения(Integer)
     * @return
     * 200-Если запрос прошел успешно.
     * 404-Если был предоставлен неверный id отделения (не существует отделение или нет клиентов).
     * 500-Ошибка вызванная сервером.
     */
    @GetMapping("/department/{departmentId}/clients")
    public List<Client> getAllClientsByDepartmentId(@PathVariable(name = "departmentId") Integer departmentId) {
        try {
            return clientService.getAllClientsByDepartmentId(departmentId);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
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

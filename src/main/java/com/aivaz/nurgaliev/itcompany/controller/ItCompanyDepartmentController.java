package com.aivaz.nurgaliev.itcompany.controller;

import com.aivaz.nurgaliev.itcompany.entity.ItCompanyDepartment;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.service.ItCompanyDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ItCompanyDepartmentController {

    private final ItCompanyDepartmentService departmentService;

    @Autowired
    public ItCompanyDepartmentController(ItCompanyDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department/{departmentId}")
    public ItCompanyDepartment getDepartmentById(@PathVariable(name = "departmentId") Integer departmentId) {
        try {
            //ItCompanyDepartment itCompanyDepartment = departmentService.getDepartment(departmentId);
            //System.out.println(itCompanyDepartment.getDeveloperTeams());

            return departmentService.getDepartment(departmentId);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

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
}
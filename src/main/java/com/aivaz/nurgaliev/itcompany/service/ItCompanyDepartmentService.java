package com.aivaz.nurgaliev.itcompany.service;

import com.aivaz.nurgaliev.itcompany.entity.ItCompanyDepartment;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.repository.ItCompanyDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItCompanyDepartmentService {

    private final ItCompanyDepartmentRepository departmentRepository;

    @Autowired
    public ItCompanyDepartmentService(ItCompanyDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public ItCompanyDepartment getDepartment(Integer departmentId) throws DataNotFoundException {
        ItCompanyDepartment department = departmentRepository.findByDepartmentId(departmentId);

        if (department == null) {
            throw new DataNotFoundException("It company's department does not exist," +
                    "probably wrong department id");
        }

        return department;
    }

    public List<ItCompanyDepartment> getAllDepartments() throws DataNotFoundException {
        List<ItCompanyDepartment> departments = departmentRepository.findAll();

        if (departments == null) {
            throw new DataNotFoundException("There's no departments in database");
        }

        return departments;
    }
}
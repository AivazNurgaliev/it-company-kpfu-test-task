package com.aivaz.nurgaliev.itcompany.service;

import com.aivaz.nurgaliev.itcompany.entity.Client;
import com.aivaz.nurgaliev.itcompany.entity.Developer;
import com.aivaz.nurgaliev.itcompany.entity.DeveloperTeam;
import com.aivaz.nurgaliev.itcompany.entity.ItCompanyDepartment;
import com.aivaz.nurgaliev.itcompany.exception.DataNotFoundException;
import com.aivaz.nurgaliev.itcompany.repository.ClientRepository;
import com.aivaz.nurgaliev.itcompany.repository.DeveloperRepository;
import com.aivaz.nurgaliev.itcompany.repository.ItCompanyDepartmentRepository;
import com.aivaz.nurgaliev.itcompany.util.DepartmentReport;
import com.aivaz.nurgaliev.itcompany.util.PageAndEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItCompanyDepartmentService {

    private final ItCompanyDepartmentRepository departmentRepository;
    private final DeveloperRepository developerRepository;

    @Autowired
    public ItCompanyDepartmentService(ItCompanyDepartmentRepository departmentRepository,
                                      DeveloperRepository developerRepository) {
        this.departmentRepository = departmentRepository;
        this.developerRepository = developerRepository;
    }

    public ItCompanyDepartment getDepartment(Integer departmentId) throws DataNotFoundException {
        ItCompanyDepartment department = departmentRepository.findByDepartmentId(departmentId);

        if (department == null) {
            throw new DataNotFoundException("It company's department does not exist " +
                    "or invalid department id");
        }

        return department;
    }

    public PageAndEntityResponse<ItCompanyDepartment> getAllDepartments(Integer pageNo, Integer pageSize, String sortBy)
            throws DataNotFoundException {

        Pageable paging;
        if (sortBy.startsWith("-")) {
            StringBuilder sb = new StringBuilder(sortBy);
            sortBy = sb.deleteCharAt(0).toString();
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        } else {
            paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        }

        Page<ItCompanyDepartment> pagedResult = departmentRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            PageAndEntityResponse<ItCompanyDepartment> departmentPage = new PageAndEntityResponse<>();
            departmentPage.setTotalPages(pagedResult.getTotalPages());
            departmentPage.setTotalElements(pagedResult.getTotalElements());
            departmentPage.setEntity(pagedResult.getContent());

            return departmentPage;
        } else {
            throw new DataNotFoundException("There's no departments in database or " +
                    "Invalid paging or sorting params or content does not exist");
        }
    }

    public DepartmentReport getDepartmentReport(Integer departmentId) throws DataNotFoundException {
        DepartmentReport departmentReport = new DepartmentReport();
        ItCompanyDepartment department = departmentRepository.findByDepartmentId(departmentId);

        if (department == null) {
            throw new DataNotFoundException("It company's department does not exist " +
                    "or invalid department id");
        }

        List<Integer> teamIds = new ArrayList<>();
        for (DeveloperTeam developerTeam : department.getDeveloperTeams()) {
            teamIds.add(developerTeam.getTeamId());
        }

        List<List<Developer>> developers = new ArrayList<>();

        for (Integer teamId : teamIds) {
            developers.add(developerRepository.findByDeveloperTeam_TeamId(teamId));
        }

        Integer monthlySalaryExpenses = Integer.valueOf(0);
        BigDecimal profitFromClients = BigDecimal.valueOf(0);

        if (developers.size() != 0) {
            for (List<Developer> developerList : developers) {
                for (Developer developer : developerList) {
                    monthlySalaryExpenses += developer.getDeveloperDetails().getDeveloperSalary();
                }
            }
        }

        List<Client> clients = department.getClients();

        if (clients.size() != 0) {
            for (Client client : clients) {
                profitFromClients = profitFromClients.add(client.getClientDetails().getClient_budget());
            }
        }

        departmentReport.setDepartmentId(departmentId);
        departmentReport.setMonthlySalaryExpenses(monthlySalaryExpenses);
        departmentReport.setProfitFromClients(profitFromClients);

        return departmentReport;
    }
}

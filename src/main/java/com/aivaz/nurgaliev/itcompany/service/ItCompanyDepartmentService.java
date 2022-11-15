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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItCompanyDepartmentService {

    private final ItCompanyDepartmentRepository departmentRepository;
    private final DeveloperTeamService teamService;
    private final DeveloperRepository developerRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public ItCompanyDepartmentService(ItCompanyDepartmentRepository departmentRepository,
                                      DeveloperTeamService teamService,
                                      DeveloperRepository developerRepository, ClientRepository clientRepository) {
        this.departmentRepository = departmentRepository;
        this.teamService = teamService;
        this.developerRepository = developerRepository;
        this.clientRepository = clientRepository;
    }

    public ItCompanyDepartment getDepartment(Integer departmentId) throws DataNotFoundException {
        ItCompanyDepartment department = departmentRepository.findByDepartmentId(departmentId);

        if (department == null) {
            throw new DataNotFoundException("It company's department does not exist " +
                    "or invalid department id");
        }

        return department;
    }

    public List<ItCompanyDepartment> getAllDepartments() throws DataNotFoundException {
        List<ItCompanyDepartment> departments = departmentRepository.findAll();

        if (departments == null || departments.size() == 0) {
            throw new DataNotFoundException("There's no departments in database");
        }

        return departments;
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

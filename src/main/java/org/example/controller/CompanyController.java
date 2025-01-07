package org.example.controller;

import org.example.dto.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private List<Company> companyList;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyList;
    }

    @GetMapping("/{employeeId}")
    public String getCompanyName(@PathVariable Integer employeeId) {
        Optional<Company> optCompany = companyList.stream().filter(c -> c.getEmployeeIds().contains(employeeId)).findAny();
        if (optCompany.isPresent()) {
            return optCompany.get().getCompName();
        }
        return String.format("Employee with %d have not joined any company till now!", employeeId);
    }

}

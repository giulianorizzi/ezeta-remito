package com.ezeta.remito.rest.service;

import com.ezeta.remito.rest.enums.Discriminator;
import com.ezeta.remito.rest.exception.NotFoundException;
import com.ezeta.remito.rest.model.Employee;
import com.ezeta.remito.rest.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void create() {

    }

    @Transactional(readOnly = true)
    public Employee getByExternalId(String externalId) {
        return this.repository
                .findByExternalId(externalId)
                .orElseThrow(() -> new NotFoundException(Employee.class, Discriminator.EXTERNAL_ID, externalId));
    }

    // It returns a <ExternalId, Employee> Map
    @Transactional(readOnly = true)
    public Map<String, Employee> getEmployeeMap(List<String> externalIds) {
        Map<String, Employee> employeeMap = new HashMap<>();
        List<Employee> employees = this.repository.getByExternalIdIn(externalIds);

        employees.forEach(employee -> employeeMap.put(employee.getExternalId(), employee));

        return employeeMap;
    }
}

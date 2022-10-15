package com.ezeta.remito.rest.service;

import com.ezeta.remito.rest.dto.EmployeeDTO;
import com.ezeta.remito.rest.model.Employee;
import com.ezeta.remito.rest.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService extends BasicService<Employee, EmployeeDTO, EmployeeRepository> {
    public EmployeeService(EmployeeRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    @Override
    public Class<Employee> getModelClass() {
        return Employee.class;
    }

    @Override
    public Class<EmployeeDTO> getDTOClass() {
        return EmployeeDTO.class;
    }

    public void create() {

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

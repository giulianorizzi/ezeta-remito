package com.ezeta.remito.rest.service;

import com.ezeta.remito.rest.dto.creation.RemitoCreationDTO;
import com.ezeta.remito.rest.model.Employee;
import com.ezeta.remito.rest.model.Operation;
import com.ezeta.remito.rest.model.Remito;
import com.ezeta.remito.rest.model.RemitoDetail;
import com.ezeta.remito.rest.repository.RemitoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemitoService {
    private final RemitoRepository repository;
    private final EmployeeService employeeService;
    private final OperationService operationService;

    public RemitoService(RemitoRepository repository, EmployeeService employeeService, OperationService operationService) {
        this.repository = repository;
        this.employeeService = employeeService;
        this.operationService = operationService;
    }

    @Transactional
    public void create(RemitoCreationDTO dto) {
        Employee employee = this.employeeService.getByExternalId("1");
        Operation operation = this.operationService.getByExternalId("1");

        Remito remito = new Remito();

        dto.getDetails().forEach(detail -> {
            RemitoDetail remitoDetail = new RemitoDetail();

            remitoDetail.setEmployee(employee);
            remitoDetail.setOperation(operation);
            remitoDetail.setQuantity(detail.getQuantity());

            remito.addDetail(remitoDetail);
        });
    }
}

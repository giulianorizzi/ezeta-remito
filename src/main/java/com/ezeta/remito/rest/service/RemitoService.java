package com.ezeta.remito.rest.service;

import com.ezeta.remito.rest.dto.RemitoDTO;
import com.ezeta.remito.rest.dto.creation.RemitoCreationDTO;
import com.ezeta.remito.rest.enums.Discriminator;
import com.ezeta.remito.rest.exception.NotFoundException;
import com.ezeta.remito.rest.model.Employee;
import com.ezeta.remito.rest.model.Operation;
import com.ezeta.remito.rest.model.Remito;
import com.ezeta.remito.rest.model.RemitoDetail;
import com.ezeta.remito.rest.repository.RemitoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RemitoService {
    private final RemitoRepository repository;
    private final EmployeeService employeeService;
    private final OperationService operationService;
    private final ModelMapper modelMapper;

    public RemitoService(RemitoRepository repository, EmployeeService employeeService,
                         OperationService operationService, ModelMapper modelMapper) {
        this.repository = repository;
        this.employeeService = employeeService;
        this.operationService = operationService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void create(RemitoCreationDTO dto) {
        Employee employee = this.employeeService.getByExternalId("jNfeTTRTQihhuq2a15KHcH5lVuNbkbtE");
        Operation operation = this.operationService.getByExternalId("4aW45ptF1LDu4qJOE46aqZqgJX5YbTbr");

        Remito remito = new Remito();

        remito.setNumber("32452");

        dto.getDetails().forEach(detail -> {
            RemitoDetail remitoDetail = new RemitoDetail();

            remitoDetail.setEmployee(employee);
            remitoDetail.setOperation(operation);
            remitoDetail.setQuantity(detail.getQuantity());

            remito.addDetail(remitoDetail);
        });

        this.repository.save(remito);
    }

    @Transactional(readOnly = true)
    public Remito getByExternalId(String externalId) {
        return this.repository
                .findByExternalId(externalId)
                .orElseThrow(() -> new NotFoundException(Remito.class, Discriminator.EXTERNAL_ID, externalId));
    }

    @Transactional(readOnly = true)
    public RemitoDTO getDTOByExternalId(String externalId) {
        Remito remito = this.getByExternalId(externalId);
        return this.modelMapper.map(remito, RemitoDTO.class);
    }
}

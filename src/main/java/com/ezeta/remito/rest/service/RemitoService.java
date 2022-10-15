package com.ezeta.remito.rest.service;

import com.ezeta.remito.rest.dto.RemitoDTO;
import com.ezeta.remito.rest.dto.creation.RemitoCreationDTO;
import com.ezeta.remito.rest.dto.creation.RemitoDetailCreationDTO;
import com.ezeta.remito.rest.model.Employee;
import com.ezeta.remito.rest.model.Operation;
import com.ezeta.remito.rest.model.Remito;
import com.ezeta.remito.rest.model.RemitoDetail;
import com.ezeta.remito.rest.repository.RemitoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RemitoService extends BasicService<Remito, RemitoDTO, RemitoRepository> {
    private final EmployeeService employeeService;
    private final OperationService operationService;

    public RemitoService(RemitoRepository repository, EmployeeService employeeService,
                         OperationService operationService, ModelMapper modelMapper) {
        super(repository, modelMapper);
        this.employeeService = employeeService;
        this.operationService = operationService;
    }

    @Override
    public Class<Remito> getModelClass() {
        return Remito.class;
    }

    @Override
    public Class<RemitoDTO> getDTOClass() {
        return RemitoDTO.class;
    }

    @Transactional
    public RemitoDTO create(RemitoCreationDTO dto) {
        List<String> employeeExternalIds = dto.getDetails().stream().map(RemitoDetailCreationDTO::getEmployeeExternalId).collect(Collectors.toList());
        List<String> operationsExternalIds = dto.getDetails().stream().map(RemitoDetailCreationDTO::getOperationExternalId).collect(Collectors.toList());
        Map<String, Employee> employeeMap = this.employeeService.getEmployeeMap(employeeExternalIds);
        Map<String, Operation> operationMap = this.operationService.getOperationMap(operationsExternalIds);

        Remito remito = new Remito();

        remito.setNumber(dto.getNumber());

        dto.getDetails().forEach(detail -> {
            RemitoDetail remitoDetail = RemitoDetail
                    .builder()
                    .remito(remito)
                    .operation(operationMap.get(detail.getOperationExternalId()))
                    .employee(employeeMap.get(detail.getEmployeeExternalId()))
                    .quantity(detail.getQuantity())
                    .build();

            remito.addDetail(remitoDetail);
        });

        return this.mapToDTO(this.save(remito));
    }
}

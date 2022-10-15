package com.ezeta.remito.rest.service;

import com.ezeta.remito.rest.dto.OperationDTO;
import com.ezeta.remito.rest.model.Operation;
import com.ezeta.remito.rest.repository.OperationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OperationService extends BasicService<Operation, OperationDTO, OperationRepository> {
    public OperationService(OperationRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper);
    }

    @Override
    public Class<Operation> getModelClass() {
        return Operation.class;
    }

    @Override
    public Class<OperationDTO> getDTOClass() {
        return OperationDTO.class;
    }

    // It returns a <ExternalId, Operation> Map
    @Transactional(readOnly = true)
    public Map<String, Operation> getOperationMap(List<String> externalIds) {
        Map<String, Operation> operationMap = new HashMap<>();
        List<Operation> operations = this.getByExternalIdIn(externalIds);

        operations.forEach(operation -> operationMap.put(operation.getExternalId(), operation));

        return operationMap;
    }
}

package com.ezeta.remito.rest.service;

import com.ezeta.remito.rest.enums.Discriminator;
import com.ezeta.remito.rest.exception.NotFoundException;
import com.ezeta.remito.rest.model.Operation;
import com.ezeta.remito.rest.repository.OperationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationService {
    private final OperationRepository repository;

    public OperationService(OperationRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Operation getByExternalId(String externalId) {
        return this.repository
                .findByExternalId(externalId)
                .orElseThrow(() -> new NotFoundException(Operation.class, Discriminator.EXTERNAL_ID, externalId));
    }
}

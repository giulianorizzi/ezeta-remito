package com.ezeta.remito.rest.service;

import com.ezeta.remito.rest.enums.Discriminator;
import com.ezeta.remito.rest.exception.NotFoundException;
import com.ezeta.remito.rest.repository.BasicRepository;
import com.ezeta.remito.rest.model.BasicEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class BasicService<M extends BasicEntity, D, R extends BasicRepository<M>> {
    protected final R repository;
    protected final ModelMapper modelMapper;

    public BasicService(R repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public abstract Class<M> getModelClass();

    public abstract Class<D> getDTOClass();

    @Transactional(readOnly = true)
    public M getByExternalId(String externalId) {
        return this
                .repository.findByExternalId(externalId)
                .orElseThrow(() -> new NotFoundException(getModelClass(), Discriminator.EXTERNAL_ID, externalId));
    };

    @Transactional(readOnly = true)
    public D getDTOByExternalId(String externalId) {
        M result = this.getByExternalId(externalId);
        return this.modelMapper.map(result, getDTOClass());
    }

    @Transactional(readOnly = true)
    public List<M> getAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<D> getAllDTO() {
        return this.mapToDTOList(this.repository.findAll());
    }

    // Map utils
    public D mapToDTO(M model) {
        return this.modelMapper.map(model, getDTOClass());
    }

    public List<D> mapToDTOList(List<M> modelList) {
        return modelList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}
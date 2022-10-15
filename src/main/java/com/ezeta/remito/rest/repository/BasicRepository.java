package com.ezeta.remito.rest.repository;

import com.ezeta.remito.rest.model.BasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BasicRepository<M extends BasicEntity> extends JpaRepository<M, Long> {
    Optional<M> findByExternalId(String externalId);

    List<M> getByExternalIdIn(List<String> externalIds);
}

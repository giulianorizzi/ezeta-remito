package com.ezeta.remito.rest.repository;

import com.ezeta.remito.rest.model.Remito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RemitoRepository extends JpaRepository<Remito, Long> {
    Optional<Remito> findByExternalId(String externalId);
}

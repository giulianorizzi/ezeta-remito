package com.ezeta.remito.rest.repository;

import com.ezeta.remito.rest.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Optional<Operation> findByExternalId(String externalId);

    List<Operation> getByExternalIdIn(List<String> externalIds);
}

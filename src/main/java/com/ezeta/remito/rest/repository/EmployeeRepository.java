package com.ezeta.remito.rest.repository;

import com.ezeta.remito.rest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByExternalId(String externalId);

    List<Employee> getByExternalIdIn(List<String> externalIds);
}

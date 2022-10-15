package com.ezeta.remito.rest.controller;

import com.ezeta.remito.rest.dto.EmployeeDTO;
import com.ezeta.remito.rest.dto.creation.EmployeeCreationDTO;
import com.ezeta.remito.rest.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeCreationDTO dto) {
        EmployeeDTO result = this.employeeService.create(dto);
        return ResponseEntity.ok(result);
    }
}
package com.ezeta.remito.rest.controller;

import com.ezeta.remito.rest.dto.OperationDTO;
import com.ezeta.remito.rest.service.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/operation")
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public ResponseEntity<List<OperationDTO>> getAll() {
        List<OperationDTO> result = this.operationService.getAllDTO();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/external-id/{externalId}")
    public ResponseEntity<OperationDTO> getByExternalId(@PathVariable(name = "externalId") String externalId) {
        OperationDTO result = this.operationService.getDTOByExternalId(externalId);
        return ResponseEntity.ok(result);
    }
}
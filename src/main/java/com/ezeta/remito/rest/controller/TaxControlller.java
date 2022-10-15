package com.ezeta.remito.rest.controller;

import com.ezeta.remito.rest.dto.TaxDTO;
import com.ezeta.remito.rest.dto.creation.TaxCreationDTO;
import com.ezeta.remito.rest.service.TaxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/tax")
public class TaxControlller {
    private final TaxService taxService;

    public TaxControlller(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping
    public ResponseEntity<TaxDTO> generateTax(@Valid @RequestBody TaxCreationDTO dto) {
        TaxDTO result = this.taxService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/external-id/{externalId}")
    public ResponseEntity<TaxDTO> getByExternalId(@PathVariable(name = "externalId") String externalId) {
        TaxDTO result = this.taxService.getDTOByExternalId(externalId);
        return ResponseEntity.ok(result);
    }

    // TODO: add endpoint to get by parameters: start date, end date, min remito number, max remito number, etc
}

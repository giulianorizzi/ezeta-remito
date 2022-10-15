package com.ezeta.remito.rest.controller;

import com.ezeta.remito.rest.dto.InvoiceDTO;
import com.ezeta.remito.rest.dto.creation.InvoiceCreationDTO;
import com.ezeta.remito.rest.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceControlller {
    private final InvoiceService invoiceService;

    public InvoiceControlller(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity<InvoiceDTO> generateInvoice(@Valid @RequestBody InvoiceCreationDTO dto) {
        InvoiceDTO result = this.invoiceService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/external-id/{externalId}")
    public ResponseEntity<InvoiceDTO> getByExternalId(@PathVariable(name = "externalId") String externalId) {
        InvoiceDTO result = this.invoiceService.getDTOByExternalId(externalId);
        return ResponseEntity.ok(result);
    }

    // TODO: add endpoint to get by parameters: start date, end date, min remito number, max remito number, etc
}

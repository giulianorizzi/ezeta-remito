package com.ezeta.remito.rest.controller;

import com.ezeta.remito.rest.dto.RemitoDTO;
import com.ezeta.remito.rest.dto.creation.RemitoCreationDTO;
import com.ezeta.remito.rest.service.RemitoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/remito")
public class RemitoController {
    private final RemitoService remitoService;

    public RemitoController(RemitoService remitoService) {
        this.remitoService = remitoService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody RemitoCreationDTO dto) {
        this.remitoService.create(dto);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/external-id/{externalId}")
    public ResponseEntity<RemitoDTO> getByExternalId(@PathVariable(name = "externalId") String externalId){
        RemitoDTO response = this.remitoService.getDTOByExternalId(externalId);
        return ResponseEntity.ok(response);
    }
}

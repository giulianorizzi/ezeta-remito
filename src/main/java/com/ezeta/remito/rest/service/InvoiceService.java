package com.ezeta.remito.rest.service;

import com.ezeta.remito.rest.dto.InvoiceDTO;
import com.ezeta.remito.rest.dto.creation.InvoiceCreationDTO;
import com.ezeta.remito.rest.model.Remito;
import com.ezeta.remito.rest.model.Invoice;
import com.ezeta.remito.rest.repository.InvoiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService extends BasicService<Invoice, InvoiceDTO, InvoiceRepository> {
    private final RemitoService remitoService;

    public InvoiceService(InvoiceRepository repository, ModelMapper modelMapper, RemitoService remitoService) {
        super(repository, modelMapper);
        this.remitoService = remitoService;
    }

    @Override
    public Class<Invoice> getModelClass() {
        return Invoice.class;
    }

    @Override
    public Class<InvoiceDTO> getDTOClass() {
        return InvoiceDTO.class;
    }

    public InvoiceDTO create(InvoiceCreationDTO dto) {
        Invoice invoice = new Invoice();
        List<Remito> remitos = this.remitoService.getByExternalIdIn(dto.getRemitosExternalIds());

        invoice.setRemitos(remitos);

        return this.mapToDTO(this.save(invoice));
    }
}

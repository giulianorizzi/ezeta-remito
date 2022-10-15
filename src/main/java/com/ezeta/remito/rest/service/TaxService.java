package com.ezeta.remito.rest.service;

import com.ezeta.remito.rest.dto.TaxDTO;
import com.ezeta.remito.rest.dto.creation.TaxCreationDTO;
import com.ezeta.remito.rest.model.Remito;
import com.ezeta.remito.rest.model.Tax;
import com.ezeta.remito.rest.repository.TaxRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxService extends BasicService<Tax, TaxDTO, TaxRepository> {
    private final RemitoService remitoService;

    public TaxService(TaxRepository repository, ModelMapper modelMapper, RemitoService remitoService) {
        super(repository, modelMapper);
        this.remitoService = remitoService;
    }

    @Override
    public Class<Tax> getModelClass() {
        return Tax.class;
    }

    @Override
    public Class<TaxDTO> getDTOClass() {
        return TaxDTO.class;
    }

    public TaxDTO create(TaxCreationDTO dto) {
        Tax tax = new Tax();
        List<Remito> remitos = this.remitoService.getByExternalIdIn(dto.getRemitosExternalIds());

        tax.setRemitos(remitos);

        return this.mapToDTO(this.save(tax));
    }
}

package com.ezeta.remito.rest.dto;

import com.ezeta.remito.rest.dto.creation.RemitoDetailCreationDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RemitoDTO {
    private String number;
    private List<RemitoDetailCreationDTO> details;
}

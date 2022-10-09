package com.ezeta.remito.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RemitoDTO {
    private String externalId;
    private String number;
    private List<RemitoDetailDTO> details;
}

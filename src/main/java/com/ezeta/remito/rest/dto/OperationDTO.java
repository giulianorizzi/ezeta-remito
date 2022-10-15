package com.ezeta.remito.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperationDTO extends BasicDTO {
    private String externalId;
    private String name;
    private List<OperationPriceDTO> prices = new ArrayList<>();
}

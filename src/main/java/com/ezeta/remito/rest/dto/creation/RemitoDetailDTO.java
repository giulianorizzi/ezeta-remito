package com.ezeta.remito.rest.dto.creation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RemitoDetailDTO {
    private String operationExternalId;
    private String employeeExternalId;
    private int quantity;
}

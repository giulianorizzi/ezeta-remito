package com.ezeta.remito.rest.dto.creation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RemitoDetailCreationDTO {
    @NotEmpty(message = "Operation external id should not be empty")
    private String operationExternalId;

    @NotEmpty(message = "Employee external id should not be empty")
    private String employeeExternalId;

    @Min(value = 1, message = "Quantity should be greater than 0")
    private int quantity;

    private double diameter;
}

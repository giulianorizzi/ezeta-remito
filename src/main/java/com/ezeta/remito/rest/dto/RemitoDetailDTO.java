package com.ezeta.remito.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemitoDetailDTO {
    private String externalId;
    private EmployeeDTO employee;
    private OperationDTO operation;
    private int quantity;
}

package com.ezeta.remito.rest.dto;

import com.ezeta.remito.rest.dto.creation.OperationDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemitoDetailDTO {
    private EmployeeDTO employee;
    private OperationDTO operation;
    private int quantity;
}

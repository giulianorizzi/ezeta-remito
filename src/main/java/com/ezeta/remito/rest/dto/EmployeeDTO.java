package com.ezeta.remito.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO extends BasicDTO {
    private String externalId;
    private PersonDTO person;
}

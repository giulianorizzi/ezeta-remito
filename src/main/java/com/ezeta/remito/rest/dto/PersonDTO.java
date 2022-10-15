package com.ezeta.remito.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonDTO extends BasicDTO {
    private String externalId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String identificationNumber;
    private String cuit;
}

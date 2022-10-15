package com.ezeta.remito.rest.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
public class Person extends BasicEntity {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String identificationNumber;
    private String cuit;

    public Person(String firstName, String lastName, Date birthDate, String identificationNumber, String cuit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.identificationNumber = identificationNumber;
        this.cuit = cuit;
    }
}

package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Person extends BasicEntity {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String identificationNumber;
    private String cuit;
}

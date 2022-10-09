package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee extends BasicEntity {
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}

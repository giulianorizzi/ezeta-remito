package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee extends BasicEntity {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;
}

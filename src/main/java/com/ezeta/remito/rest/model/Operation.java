package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private double price;
}

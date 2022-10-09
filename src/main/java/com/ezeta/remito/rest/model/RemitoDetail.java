package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RemitoDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "remito_id")
    private Remito remito;

    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private int quantity;
}

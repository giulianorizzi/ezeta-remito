package com.ezeta.remito.rest.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
public class RemitoDetail extends BasicEntity {
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

    private double diameter;

    public RemitoDetail(Remito remito, Operation operation, Employee employee, int quantity, double diameter) {
        this.remito = remito;
        this.operation = operation;
        this.employee = employee;
        this.quantity = quantity;
        this.diameter = diameter;
    }
}

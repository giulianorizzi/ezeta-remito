package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class OperationPrice extends BasicEntity {
    @ManyToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

    private double price;

    private double untilDiameter;
}

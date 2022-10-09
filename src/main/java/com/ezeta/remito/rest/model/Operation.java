package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Operation extends BasicEntity {
    private String name;
    private double price;
}

package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private double total;
}

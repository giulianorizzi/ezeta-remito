package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Remito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String number;

    @OneToMany(mappedBy = "remito")
    private List<RemitoDetail> details;
}

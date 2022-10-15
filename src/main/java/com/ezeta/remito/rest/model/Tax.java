package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Tax extends BasicEntity {
    @OneToMany(mappedBy = "tax", cascade = CascadeType.ALL)
    private List<Remito> remitos = new ArrayList<>();

    private double total;
}
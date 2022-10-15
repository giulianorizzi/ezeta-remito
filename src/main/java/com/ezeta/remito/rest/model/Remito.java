package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Remito extends BasicEntity {
    private String number;

    @OneToMany(mappedBy = "remito", cascade = CascadeType.ALL)
    private List<RemitoDetail> details = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    public void addDetail(RemitoDetail detail) {
        this.details.add(detail);
    }
}

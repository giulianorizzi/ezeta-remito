package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Operation extends BasicEntity {
    private String name;

    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL)
    private List<OperationPrice> prices = new ArrayList<>();
}
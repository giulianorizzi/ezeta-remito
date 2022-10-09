package com.ezeta.remito.rest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Invoice extends BasicEntity {
    private double total;
}

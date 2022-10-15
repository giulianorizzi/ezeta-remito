package com.ezeta.remito.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperationPriceDTO extends BasicDTO {
    private double price;
    private double untilDiameter;
}

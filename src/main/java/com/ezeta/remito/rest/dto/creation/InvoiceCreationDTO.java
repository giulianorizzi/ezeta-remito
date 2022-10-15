package com.ezeta.remito.rest.dto.creation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceCreationDTO {
    @Size(min = 1, message = "Min number of remitos to create an invoice is 1")
    private List<String> remitosExternalIds = new ArrayList<>();
}

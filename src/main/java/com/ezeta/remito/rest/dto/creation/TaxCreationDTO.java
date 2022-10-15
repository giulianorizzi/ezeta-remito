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
public class TaxCreationDTO {
    @Size(min = 1, message = "Min number of remitos to create a tax is 1")
    private List<String> remitosExternalIds = new ArrayList<>();
}

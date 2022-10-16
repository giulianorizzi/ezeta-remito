package com.ezeta.remito.rest.dto.creation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RemitoCreationDTO {
    @NotEmpty(message = "Remito number should not be empty")
    private String number;

    private List<RemitoDetailCreationDTO> details;
}

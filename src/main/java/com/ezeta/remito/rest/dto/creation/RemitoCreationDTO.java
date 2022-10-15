package com.ezeta.remito.rest.dto.creation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RemitoCreationDTO {
    @Size(min = 2, message = "Min value for number is 1 character")
    private String number;

    private List<RemitoDetailCreationDTO> details;
}

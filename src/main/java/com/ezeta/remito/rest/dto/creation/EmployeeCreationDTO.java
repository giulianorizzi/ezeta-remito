package com.ezeta.remito.rest.dto.creation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreationDTO {
    @NotEmpty(message = "First name should not be empty")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty")
    private String lastName;

    @Past(message = "Birth date should be in the past")
    private Date birthDate;

    @Size(min = 7, message = "Min value for identification number is 7 characters")
    private String identificationNumber;

    @Size(min = 9, message = "Min value for cuit is 9 characters")
    private String cuit;
}

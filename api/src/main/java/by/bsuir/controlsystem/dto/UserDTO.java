package by.bsuir.controlsystem.dto;

import by.bsuir.controlsystem.validation.FieldsValueMatch;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@FieldsValueMatch(field = "password", fieldMatch = "matchingPassword", message = "Password mismatch")
public class UserDTO {
    private int id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String matchingPassword;

    @NotBlank
    private String firstName;

    private boolean isActive;

    @NotBlank
    private String lastName;
}

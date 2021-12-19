package by.bsuir.controlsystem.dto.exception;

import lombok.Data;

@Data
public class ExceptionResponseDTO {
    private String exception;
    private String message;
    private String code;
}

package by.bsuir.controlsystem.exception;

import by.bsuir.controlsystem.dto.exception.ErrorCodeDTO;
import by.bsuir.controlsystem.dto.exception.ExceptionResponseDTO;
import by.bsuir.controlsystem.dto.exception.ValidationResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        HashMap<String, List<String>> errors = new HashMap<>();
        for (ObjectError error : ex.getAllErrors()) {
            String errorLocation;
            if (error instanceof FieldError) {
                errorLocation = ((FieldError) error).getField();
            } else {
                errorLocation = error.getObjectName();
            }

            String errorMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            if (!errors.containsKey(errorLocation)) {
                errors.put(errorLocation, new ArrayList<>(List.of(errorMessage)));
            } else {
                errors.get(errorLocation).add(errorMessage);
            }
        }

        ValidationResponseDTO validationResponseDTO = new ValidationResponseDTO();
        validationResponseDTO.setException("Validation failed. " + ex.getErrorCount() + " error(s)");
        validationResponseDTO.setMessage(errors);
        validationResponseDTO.setCode(ErrorCodeDTO.VALIDATION_ERROR.getCode());

        return new ResponseEntity<>(validationResponseDTO, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleUserNotFoundException(EntityNotFoundException e) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();
        exceptionResponseDTO.setException(e.getClass().getName());
        exceptionResponseDTO.setMessage(e.getMessage());
        exceptionResponseDTO.setCode(ErrorCodeDTO.ENTITY_NOT_FOUND.getCode());

        return new ResponseEntity<>(exceptionResponseDTO, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDTO> handleBadRequestExceptions(RuntimeException e) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();
        exceptionResponseDTO.setException(e.getClass().getName());
        exceptionResponseDTO.setMessage(e.getMessage());

        return new ResponseEntity<>(exceptionResponseDTO, null, HttpStatus.BAD_REQUEST);
    }
}

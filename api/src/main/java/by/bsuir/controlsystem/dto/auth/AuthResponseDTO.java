package by.bsuir.controlsystem.dto.auth;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthResponseDTO {
    private final String token;
}

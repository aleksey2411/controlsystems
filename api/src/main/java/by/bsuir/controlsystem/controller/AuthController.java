package by.bsuir.controlsystem.controller;

import by.bsuir.controlsystem.dto.UserDTO;
import by.bsuir.controlsystem.dto.auth.AuthRequestDTO;
import by.bsuir.controlsystem.dto.auth.AuthResponseDTO;
import by.bsuir.controlsystem.service.AuthService;
import by.bsuir.controlsystem.service.UserService;
import by.bsuir.controlsystem.validation.user.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final AuthService authService;
    private final UserValidator userValidator;

    @InitBinder("userDTO")
    protected void userValidator(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @PostMapping("/registration")
    public UserDTO registration(@RequestBody @Valid UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @PostMapping("/login")
    public AuthResponseDTO loginForUser(@RequestBody AuthRequestDTO authRequestDTO) {
        String token = authService.login(authRequestDTO.getUsername(), authRequestDTO.getPassword());

        return new AuthResponseDTO(token);
    }
}

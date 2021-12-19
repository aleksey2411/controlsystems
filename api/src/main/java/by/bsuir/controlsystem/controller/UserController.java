package by.bsuir.controlsystem.controller;

import by.bsuir.controlsystem.dto.UserDTO;
import by.bsuir.controlsystem.service.UserService;
import by.bsuir.controlsystem.validation.user.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    @InitBinder("userDto")
    protected void userValidator(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @GetMapping("/")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PutMapping("/")
    public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}

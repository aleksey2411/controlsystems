package by.bsuir.controlsystem.validation.user;

import by.bsuir.controlsystem.dto.UserDTO;
import by.bsuir.controlsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@RequiredArgsConstructor
@Component
public class UserValidator implements Validator {
    private final UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO userDTO = (UserDTO) o;

        UserDTO userByUserName = userService.findByUsername(userDTO.getUsername());
        if (userByUserName != null && userDTO.getId() != userByUserName.getId()) {
            errors.rejectValue("username", "error.userDTO.userExists.username");
        }
    }
}

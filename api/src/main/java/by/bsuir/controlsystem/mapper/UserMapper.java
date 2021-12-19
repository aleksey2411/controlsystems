package by.bsuir.controlsystem.mapper;

import by.bsuir.controlsystem.dto.UserDTO;
import by.bsuir.controlsystem.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public abstract class UserMapper {
     public abstract UserDTO userToUserDTO(User user);

     public abstract User userDTOtoUser(UserDTO userDTO);

     public abstract List<UserDTO> userToUserDTO(List<User> users);
}

package by.bsuir.controlsystem.service;

import by.bsuir.controlsystem.dto.UserDTO;
import by.bsuir.controlsystem.entity.RoleName;

import java.util.List;

public interface UserService {
    UserDTO getUser(int id);
    UserDTO updateUser(UserDTO userDto);
    void deleteUser(int id);
    List<UserDTO> getUsers();
    UserDTO addUser(UserDTO userDto);
    UserDTO findByUsername(String username);
}

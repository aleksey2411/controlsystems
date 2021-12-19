package by.bsuir.controlsystem.service.impl;

import by.bsuir.controlsystem.dto.UserDTO;
import by.bsuir.controlsystem.entity.Role;
import by.bsuir.controlsystem.entity.RoleName;
import by.bsuir.controlsystem.entity.User;
import by.bsuir.controlsystem.mapper.UserMapper;
import by.bsuir.controlsystem.repository.RoleRepository;
import by.bsuir.controlsystem.repository.UserRepository;
import by.bsuir.controlsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO getUser(int id) {
        User user = userRepository.getById(id);
        return userMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        userRepository.getById(userDTO.getId());
        User updatedUser = userMapper.userDTOtoUser(userDTO);
        userRepository.save(updatedUser);
        return userMapper.userToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.userToUserDTO(users);
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.userDTOtoUser(userDTO);

        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setActive(true);
        Role role = roleRepository.findByRole(RoleName.ROLE_USER.name());
        user.setRoles(new HashSet<>(List.of(role)));

        User savedUser = userRepository.save(user);
        return userMapper.userToUserDTO(savedUser);
    }

    @Override
    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return userMapper.userToUserDTO(user);
    }
}

package by.bsuir.controlsystem.service.impl;

import by.bsuir.controlsystem.service.AuthService;
import by.bsuir.controlsystem.repository.UserRepository;
import by.bsuir.controlsystem.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    @Override
    public String login(String username, String password) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtUtil.createToken(username, userRepository.findByUsername(username).getRoles());
    }
}

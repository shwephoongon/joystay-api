package com.shwephoo.joystay_api.service;

import com.shwephoo.joystay_api.dto.auth.LoginResponseDto;
import com.shwephoo.joystay_api.entity.LoginRequest;
import com.shwephoo.joystay_api.entity.User;
import com.shwephoo.joystay_api.repository.UserRepository;
import com.shwephoo.joystay_api.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthService(AuthenticationManager authenticationManager,
                       UserRepository userRepository,
                       JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponseDto login(LoginRequest loginRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword()
                )
        );

        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtUtil.generateToken(user.getUsername());

        return new LoginResponseDto(
                "success",
                "Login successful",
                new LoginResponseDto.DataPayload(
                        token,
                        new LoginResponseDto.UserDto(
                                user.getId(),
                                user.getUsername(),
                                user.getRole()
                        )
                )
        );
    }
}

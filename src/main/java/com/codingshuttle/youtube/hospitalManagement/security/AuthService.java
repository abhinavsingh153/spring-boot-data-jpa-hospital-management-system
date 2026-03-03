package com.codingshuttle.youtube.hospitalManagement.security;

import com.codingshuttle.youtube.hospitalManagement.dto.LoginRequestDto;
import com.codingshuttle.youtube.hospitalManagement.dto.SignupResponseDto;
import com.codingshuttle.youtube.hospitalManagement.entity.User;
import com.codingshuttle.youtube.hospitalManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.ResourceAccessException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthUtil authUtil;
    private final PasswordEncoder passwordEncoder;

    public LoginRequestDto login(LoginRequestDto requestDto) {

        User user = userRepository.findByUsername(requestDto.getUsername()).orElseThrow();

        //generate token and return in response
//        authUtil


        return new LoginRequestDto();
    }

    public SignupResponseDto signup(LoginRequestDto requestDto) {

        User user = userRepository.findByUsername(requestDto.getUsername()).orElse(null);

        if (user!=null) throw new ResourceAccessException("User already exists");

        user = userRepository.save(User.builder()
                .username(requestDto.getUsername())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .build()
        );

        return new SignupResponseDto(user.getUsername(), user.getId());
    }
}

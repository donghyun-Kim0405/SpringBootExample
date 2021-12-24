package com.example.SpringSecurityExample.service;


import com.example.SpringSecurityExample.domain.dto.JoinDto;
import com.example.SpringSecurityExample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public String signup(JoinDto joinDto) {
        if (userRepository.findUserByEmail(joinDto.getEmail()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        joinDto.setPassword(encoder.encode(joinDto.getPassword()));

        return userRepository.save(joinDto.toUserEntity()).getUserId().toString();
    }

}

package com.example.cheongchun28.domain.admin.service;

import com.example.cheongchun28.domain.admin.dto.AdminDto;
import com.example.cheongchun28.domain.user.entity.User;
import com.example.cheongchun28.domain.user.repository.UserRepository;
import com.example.cheongchun28.global.common.dto.CustomResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomResponseDto setPermission(AdminDto.setPermissionRequestDto requestDto) throws SQLException {
        User user = userRepository.findByUserEmail(requestDto.getEmail()).orElseThrow(
                () -> new SQLException("찾으시는 값이 없습니다.")
        );

        user.setRole(requestDto.getRole());
        return new CustomResponseDto(200);
    }

    public CustomResponseDto deleteUser(AdminDto.deleteUserRequestDto requestDto) throws SQLException {
        User user = userRepository.findByUserEmail(requestDto.getEmail()).orElseThrow(
                () -> new SQLException("찾으시는 값이 없습니다.")
        );
        user.setDeleted(true);
        userRepository.save(user);
        return new CustomResponseDto(200);
    }

    public CustomResponseDto setUser(AdminDto.setUserRequestDto requestDto) throws SQLException {
        User user = userRepository.findByUserEmail(requestDto.getEmail()).orElseThrow(
                () -> new SQLException("찾으시는 값이 없습니다.")
        );

        user.setNickName(requestDto.getNickName());
        user.setEncodedPassword(bCryptPasswordEncoder.encode(requestDto.getPassword()));
        user.setEmpNumber(requestDto.getEmpNumber());

        userRepository.save(user);
        return new CustomResponseDto(200);
    }
}

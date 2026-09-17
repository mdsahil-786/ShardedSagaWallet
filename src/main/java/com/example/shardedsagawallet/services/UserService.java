 package com.example.shardedsagawallet.services;

import java.util.List;

import com.example.shardedsagawallet.entities.User;
import org.springframework.stereotype.Service;

import com.example.shardedsagawallet.dtos.UserRequestDTO;
import com.example.shardedsagawallet.dtos.UserResponseDTO;

import com.example.shardedsagawallet.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO createUser(UserRequestDTO request) {

        log.info("Creating user: {}", request.getEmail());

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();

        User newUser = userRepository.save(user);

        log.info(
                "User created with id {} in database shardwallet{}",
                newUser.getId(),
                (newUser.getId() % 2 + 1)
        );

        return UserResponseDTO.builder()
                .id(newUser.getId())
                .name(newUser.getName())
                .email(newUser.getEmail())
                .build();
    }

    public UserResponseDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public List<UserResponseDTO> getUsersByName(String name) {

        List<User> users = userRepository.findByNameContainingIgnoreCase(name);

        return users.stream()
                .map(user -> UserResponseDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .toList();
    }
}


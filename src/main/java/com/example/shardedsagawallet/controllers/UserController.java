package com.example.shardedsagawallet.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shardedsagawallet.dtos.UserRequestDTO;
import com.example.shardedsagawallet.dtos.UserResponseDTO;
import com.example.shardedsagawallet.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(
            @Valid @RequestBody UserRequestDTO request
    ) {

        UserResponseDTO response = userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {

        UserResponseDTO response = userService.getUserById(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/name")
    public ResponseEntity<List<UserResponseDTO>> getUsersByName(
            @RequestParam String name
    ) {

        List<UserResponseDTO> response = userService.getUsersByName(name);

        return ResponseEntity.ok(response);
    }
}


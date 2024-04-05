package com.example.GestionLabo.controllers;

import com.example.GestionLabo.requestDto.LoginRequestDto;
import com.example.GestionLabo.requestDto.RegisterUserRequestDto;
import com.example.GestionLabo.requestDto.UserRequestDto;
import com.example.GestionLabo.responseDto.RegisrterUserResponseDto;
import com.example.GestionLabo.responseDto.UserResponseDto;
import com.example.GestionLabo.serviceImplementaion.AuthServiceImp;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@ControllerAdvice()
public class AuthController {
    private final AuthServiceImp authService;
    private final Logger log = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/registerAdmin")
    public ResponseEntity<UserResponseDto> registerAdmin(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto myuser = authService.registerAdmin(userRequestDto);
        return ResponseEntity.ok(myuser);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserResponseDto> getUserWithId(@PathVariable String id) {
        UserResponseDto user = authService.getUserWithId(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> allusers = authService.getAllUsers();
        return ResponseEntity.ok(allusers);
    }

    @PostMapping("/RegisterSimpleUser")
    public ResponseEntity<RegisrterUserResponseDto> registerSimpleUser(
            @RequestBody() RegisterUserRequestDto userRequestDto) {
        RegisrterUserResponseDto user = authService.registerSimpleUser(userRequestDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<UserResponseDto> loginAdmin(@RequestBody LoginRequestDto loginRequestDto) {
        UserResponseDto user = authService.login(loginRequestDto);
        return ResponseEntity.ok(user);
    }

}

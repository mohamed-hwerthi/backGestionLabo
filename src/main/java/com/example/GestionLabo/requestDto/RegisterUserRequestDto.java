package com.example.GestionLabo.requestDto;

import lombok.Data;

@Data
public class RegisterUserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private com.example.GestionLabo.models.enums.Role role;

}

package com.example.GestionLabo.responseDto;

import lombok.Data;
import com.example.GestionLabo.models.enums.Role;

@Data
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private Role role;

}
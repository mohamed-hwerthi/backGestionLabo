package com.example.GestionLabo.requestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserRequestDto{
    String firstName ;
    String lastName ;
    String email ;
    String password;

}


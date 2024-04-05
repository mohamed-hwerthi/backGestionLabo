package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.requestDto.LoginRequestDto;
import com.example.GestionLabo.requestDto.RegisterUserRequestDto;
import com.example.GestionLabo.requestDto.UserRequestDto;
import com.example.GestionLabo.responseDto.RegisrterUserResponseDto;
import com.example.GestionLabo.responseDto.UserResponseDto;

import java.util.List;

public interface AuthServiceDec {
  UserResponseDto registerAdmin(UserRequestDto userRequestDto);

  UserResponseDto login(LoginRequestDto userRequestDto);

  // adminstrator register simple user :
  RegisrterUserResponseDto registerSimpleUser(RegisterUserRequestDto userRequestDto);

  List<UserResponseDto> getAllUsers();

  UserResponseDto getUserWithId(String id);

}

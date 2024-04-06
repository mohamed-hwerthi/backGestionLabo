package com.example.GestionLabo.serviceImplementaion;

import com.example.GestionLabo.exception.PasswordNotRelyException;
import com.example.GestionLabo.exception.CustomNotFoundException;
import com.example.GestionLabo.exception.UserWithEmailNotFoundException;
import com.example.GestionLabo.models.User;
    import com.example.GestionLabo.models.enums.Role;
import com.example.GestionLabo.repository.UserRepository;
import com.example.GestionLabo.requestDto.LoginRequestDto;
import com.example.GestionLabo.requestDto.RegisterUserRequestDto;
import com.example.GestionLabo.requestDto.UserRequestDto;
import com.example.GestionLabo.responseDto.RegisrterUserResponseDto;
import com.example.GestionLabo.responseDto.UserResponseDto;
import com.example.GestionLabo.serviceDeclaration.AuthServiceDec;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthServiceDec {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Logger log = LoggerFactory.getLogger(AuthServiceImp.class);

    @Override
    public UserResponseDto registerAdmin(UserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto, User.class);
        user.setRole(Role.ADMINISTRATEUR);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    @Override
    public UserResponseDto login(LoginRequestDto loginRequestDto) {
            String email = loginRequestDto.getEmail();
            String suggestedPassword = loginRequestDto.getPassword();
            Optional<User> userOptional = userRepository.findByEmail(email);
            if (userOptional.isEmpty()) {
                throw new UserWithEmailNotFoundException(email);
            } else {
                if (userOptional.get().getPassword().equals(suggestedPassword)) {
                    return modelMapper.map(userOptional, UserResponseDto.class);

                } else {
                    throw new PasswordNotRelyException(suggestedPassword);
                }
            }


    }

    @Override

    public List<UserResponseDto> getAllUsers() {
        List<User> allusers = this.userRepository.findAll();
        return allusers.stream().map(user -> modelMapper.map(user, UserResponseDto.class)).toList();
    }

    @Override
    public UserResponseDto getUserWithId(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new CustomNotFoundException("user", id);
        }
        return modelMapper.map(user, UserResponseDto.class);
    }

    @Override
    public RegisrterUserResponseDto registerSimpleUser(RegisterUserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto, User.class);
        // generate passwod to the user : a faire apres :
        String password = generateRandomPassword(8);
        user.setPassword(password);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, RegisrterUserResponseDto.class);

    }

    private String generateRandomPassword(int length) {
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+";

        String allChars = upperChars + lowerChars + numbers + specialChars;

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = new Random().nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }

}

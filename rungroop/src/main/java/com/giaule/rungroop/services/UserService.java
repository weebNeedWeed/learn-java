package com.giaule.rungroop.services;

import com.giaule.rungroop.dtos.RegistrationDto;
import com.giaule.rungroop.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUserName(String username);
}

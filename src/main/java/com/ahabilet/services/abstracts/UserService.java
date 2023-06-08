package com.ahabilet.services.abstracts;


import com.ahabilet.models.User;
import com.ahabilet.dto.PasswordUpdateRequest;

public interface UserService {

    void updateOneUser(Long userId, User newUser);

    void deleteOneUser(Long userId);

    User getOneUser(Long userId);
}

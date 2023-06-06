package com.ahabilet.services.abstracts;


import com.ahabilet.models.User;
import com.ahabilet.requests.PasswordUpdateRequest;

public interface UserService {

    void updateOneUser(Long userId, User newUser);

    boolean updatePassword(PasswordUpdateRequest request);

    void deleteOneUser(Long userId);
}

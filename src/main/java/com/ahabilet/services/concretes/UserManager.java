package com.ahabilet.services.concretes;

import com.ahabilet.models.User;
import com.ahabilet.repositories.UserRepository;
import com.ahabilet.requests.PasswordUpdateRequest;
import com.ahabilet.services.abstracts.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setFullName(newUser.getFullName());
            foundUser.setBirthDate(newUser.getBirthDate());
            foundUser.setGender(newUser.getGender());
            foundUser.setPhoneNumber(newUser.getPhoneNumber());
            foundUser.setEmail(newUser.getEmail());
            userRepository.save(foundUser);
        }
    }

    @Override
    public boolean updatePassword(PasswordUpdateRequest request) {
        String oldPassword = request.getOldPassword();
        String newPassword = request.getNewPassword();
        String confirmPassword = request.getConfirmPassword();

        if(!verifyOldPassword(oldPassword)){
            //
            return  false;
        }else if(!newPassword.equals((confirmPassword))){
            return false;
        }else{
            // userRepository.save(newPassword);
            return true;
        }
    }

    private boolean verifyOldPassword(String oldPassword) {

        //  db den eski şifre alınacak
        //  kontrol edilecek yanlış ise false dönecek
        return true;
    }

    @Override
    public void deleteOneUser(Long userId) {
        /* Optional<User> user = userRepository.findById(userId);
        user.get().setActive(false);
        userRepository.save(user.get());*/

        User user = userRepository.findById(userId).orElse(null);
        user.setActive(false);
        userRepository.save(user);
    }
}

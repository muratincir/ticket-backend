package com.ahabilet.services.concretes;

import com.ahabilet.models.User;
import com.ahabilet.repositories.UserRepository;
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
    public void deleteOneUser(Long userId) {
        /* Optional<User> user = userRepository.findById(userId);
        user.get().setActive(false);
        userRepository.save(user.get());*/

        User user = userRepository.findById(userId).orElse(null);
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}

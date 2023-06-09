package com.ahabilet.services.concretes;

import com.ahabilet.dto.RegisteredPassengerRequest;
import com.ahabilet.dto.RegisteredPassengerUpdateRequest;
import com.ahabilet.models.RegisteredPassenger;
import com.ahabilet.models.User;
import com.ahabilet.repositories.RegisteredPassengerRepository;
import com.ahabilet.services.abstracts.GenderService;
import com.ahabilet.services.abstracts.RegisteredPassengerService;
import com.ahabilet.services.abstracts.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisteredPassengerManager implements RegisteredPassengerService {

    private RegisteredPassengerRepository registeredPassengerRepository;
    private UserService userService;

    private GenderService genderService;

    public RegisteredPassengerManager(RegisteredPassengerRepository registeredPassengerRepository, UserService userService, GenderService genderService) {
        this.registeredPassengerRepository = registeredPassengerRepository;
        this.userService = userService;
        this.genderService = genderService;
    }

    @Override
    public List<RegisteredPassenger> getAllRegisteredPassenger(Long userId) {
        return registeredPassengerRepository.findAllByUserId(userId);
    }

    @Override
    public void createOneRegisteredPassenger(RegisteredPassengerRequest newPassenger) {
        RegisteredPassenger registeredPassenger = new RegisteredPassenger();
        registeredPassenger.setFullName(newPassenger.getFullName());
        registeredPassenger.setBirthDate(newPassenger.getBirthDate());
        registeredPassenger.setUser(userService.getOneUser(newPassenger.getUserId()));
        registeredPassenger.setGender(genderService.getOneGender(newPassenger.getGenderId()));
        registeredPassengerRepository.save(registeredPassenger);
    }

    @Override
    public void deleteOneRegisteredPassenger(Long registeredPassengerId) {
        registeredPassengerRepository.deleteById(registeredPassengerId);
    }

    @Override
    public void updateOneRegisteredPassenger(Long registeredPassengerId, RegisteredPassengerUpdateRequest newRegisteredPassenger) {
        Optional<RegisteredPassenger> registeredPassenger = registeredPassengerRepository.findById(registeredPassengerId);
        if(registeredPassenger.isPresent()){
            RegisteredPassenger foundRegisteredPassenger = registeredPassenger.get();
            foundRegisteredPassenger.setFullName(newRegisteredPassenger.getFullName());
            foundRegisteredPassenger.setBirthDate(newRegisteredPassenger.getBirthDate());
            foundRegisteredPassenger.setGender(genderService.getOneGender(newRegisteredPassenger.getGenderId()));
            registeredPassengerRepository.save(foundRegisteredPassenger);
        }
    }
}

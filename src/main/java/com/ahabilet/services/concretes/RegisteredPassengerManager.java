package com.ahabilet.services.concretes;

import com.ahabilet.models.RegisteredPassenger;
import com.ahabilet.models.User;
import com.ahabilet.repositories.RegisteredPassengerRepository;
import com.ahabilet.services.abstracts.RegisteredPassengerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisteredPassengerManager implements RegisteredPassengerService {

    private RegisteredPassengerRepository registeredPassengerRepository;

    public RegisteredPassengerManager(RegisteredPassengerRepository registeredPassengerRepository) {
        this.registeredPassengerRepository = registeredPassengerRepository;
    }


    @Override
    public List<RegisteredPassenger> getAllUsers(Long registeredPassengerId) {
        return registeredPassengerRepository.findAllById(registeredPassengerId);
    }

    @Override
    public void createOneUser(RegisteredPassenger newPassenger) {
        registeredPassengerRepository.save(newPassenger);
    }

    @Override
    public void deleteOneUser(Long registeredPassengerId) {
        registeredPassengerRepository.deleteById(registeredPassengerId);
    }


}

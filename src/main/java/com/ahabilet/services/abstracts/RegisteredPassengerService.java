package com.ahabilet.services.abstracts;


import com.ahabilet.models.RegisteredPassenger;
import com.ahabilet.models.User;

import java.util.List;

public interface RegisteredPassengerService {


    List<RegisteredPassenger> getAllUsers(Long registeredPassengerId);

    void createOneUser(RegisteredPassenger newPassenger);


    void deleteOneUser(Long registeredPassengerId);
}

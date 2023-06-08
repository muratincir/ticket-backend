package com.ahabilet.services.abstracts;


import com.ahabilet.dto.RegisteredPassengerRequest;
import com.ahabilet.models.RegisteredPassenger;
import com.ahabilet.models.User;

import java.util.List;

public interface RegisteredPassengerService {


    List<RegisteredPassenger> getAllRegisteredPassenger(Long userId);

    void createOneRegisteredPassenger(RegisteredPassengerRequest newPassenger);


    void deleteOneRegisteredPassenger(Long registeredPassengerId);
}

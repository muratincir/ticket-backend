package com.ahabilet.services.abstracts;


import com.ahabilet.dto.RegisteredPassengerRequest;
import com.ahabilet.dto.RegisteredPassengerUpdateRequest;
import com.ahabilet.models.RegisteredPassenger;

import java.util.List;

public interface RegisteredPassengerService {


    List<RegisteredPassenger> getAllRegisteredPassenger(Long userId);

    void createOneRegisteredPassenger(RegisteredPassengerRequest newPassenger);


    void deleteOneRegisteredPassenger(Long registeredPassengerId);

    void updateOneRegisteredPassenger(Long registeredPassengerId, RegisteredPassengerUpdateRequest newRegisteredPassenger);
}

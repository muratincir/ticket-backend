package com.ahabilet.controllers;

import com.ahabilet.dto.RegisteredPassengerRequest;
import com.ahabilet.models.RegisteredPassenger;
import com.ahabilet.models.User;
import com.ahabilet.services.abstracts.RegisteredPassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class RegisteredPassengersController {

    private RegisteredPassengerService registeredPassengerService;

    public RegisteredPassengersController(RegisteredPassengerService registeredPassengerService) {
        this.registeredPassengerService = registeredPassengerService;
    }

    @GetMapping("/registered-passenger/{userId}")
    public List<RegisteredPassenger> getAllRegisteredPassenger(@PathVariable Long userId){
        return registeredPassengerService.getAllRegisteredPassenger(userId);
    }

    @PostMapping("/registered-passenger/add")
    public ResponseEntity<?> createOneRegisteredPassenger(@RequestBody RegisteredPassengerRequest newPassenger){
        registeredPassengerService.createOneRegisteredPassenger(newPassenger);
        return ResponseEntity.ok("Başarıyla eklenmiştir");
    }

    @DeleteMapping("/registered-passenger/delete/{registeredPassengerId}")
    public ResponseEntity<?> deleteOneRegisteredPassenger(@PathVariable Long registeredPassengerId){
        registeredPassengerService.deleteOneRegisteredPassenger(registeredPassengerId);
        return ResponseEntity.ok("Başarıyla silinmiştir");
    }
}

package com.ahabilet.controllers;

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

    @GetMapping("/registered-passenger")
    public List<RegisteredPassenger> getAllUsers(@PathVariable Long registeredPassengerId){
        return registeredPassengerService.getAllUsers(registeredPassengerId);
    }

    @PostMapping("/resigtered-passenger/add")
    public ResponseEntity<?> createOneUser(@RequestBody RegisteredPassenger newPassenger){
        registeredPassengerService.createOneUser(newPassenger);
        return ResponseEntity.ok("Başarıyla eklenmiştir");
    }

    @DeleteMapping("/resigtered-passenger/delete")
    public ResponseEntity<?> deleteOneUser(@PathVariable Long registeredPassengerId){
        registeredPassengerService.deleteOneUser(registeredPassengerId);
        return ResponseEntity.ok("Başarıyla silinmiştir");
    }
}

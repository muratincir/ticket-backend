package com.ahabilet.controllers;

import com.ahabilet.models.User;
import com.ahabilet.dto.PasswordUpdateRequest;
import com.ahabilet.services.abstracts.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
public class UsersController {
    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/users/update/{userId}")
    public ResponseEntity<?> updateOneUser(@PathVariable Long userId, @RequestBody User newUser){
        userService.updateOneUser(userId,newUser);
        return ResponseEntity.ok("Başarıyla güncellenmiştir");
    }


    @DeleteMapping("/users/delete/{userId}")
    public ResponseEntity<?> deleteOneUser(@PathVariable Long userId){
        userService.deleteOneUser(userId);
        return ResponseEntity.ok("Başarıyla silinmiştir");
    }

}
package com.ahabilet.controllers;

import com.ahabilet.models.User;
import com.ahabilet.requests.PasswordUpdateRequest;
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

    @PutMapping("/users/update")
    public ResponseEntity<?> updateOneUser(@PathVariable Long userId, @RequestBody User newUser){
        userService.updateOneUser(userId,newUser);
        return ResponseEntity.ok("Başarıyla güncellenmiştir");
    }

    @PostMapping("/users/pasword-update")
    public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateRequest request){
        boolean passwordUpdated = userService.updatePassword(request);
        if(passwordUpdated){
            return ResponseEntity.ok("Şifreniz başarıyla güncellendi ");
        }else{
            return ResponseEntity.badRequest().body("Geçersiz eski şifre veya yeni şifreler uyuşmuyor");
        }
    }

    @DeleteMapping("/users/delete")
    public ResponseEntity<?> deleteOneUser(@PathVariable Long userId){
        userService.deleteOneUser(userId);
        return ResponseEntity.ok("Başarıyla silinmiştir");
    }

}
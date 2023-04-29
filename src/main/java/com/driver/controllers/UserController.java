package com.driver.controllers;
import com.driver.DTO.responseDto.UpdateUserPasswordResponseDto;
import com.driver.model.User;
import com.driver.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestParam String name, @RequestParam String phoneNumber, @RequestParam String password){
        userService.register(name,phoneNumber,password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateUserPasswordResponseDto> updatePassword(@RequestParam Integer userId, @RequestParam String password){
        UpdateUserPasswordResponseDto updatedUser = userService.updatePassword(userId,password);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam Integer userId){
        userService.deleteUser(userId);
    }
}

package com.quandev.identityservice.controller;

import com.quandev.identityservice.dto.request.ApiResponse;
import com.quandev.identityservice.dto.request.UserCreationRequest;
import com.quandev.identityservice.dto.request.UserUpdateRequest;
import com.quandev.identityservice.entity.IUser;
import com.quandev.identityservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<IUser> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<IUser> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @GetMapping
    List<IUser> getUser() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    IUser getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    IUser updateUser(@RequestBody UserUpdateRequest request, @PathVariable("userId") String userId) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }

}

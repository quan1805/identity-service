package com.quandev.identityservice.service;

import com.quandev.identityservice.dto.request.UserCreationRequest;
import com.quandev.identityservice.dto.request.UserUpdateRequest;
import com.quandev.identityservice.entity.IUser;
import com.quandev.identityservice.exception.AppException;
import com.quandev.identityservice.exception.ErrorCode;
import com.quandev.identityservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public IUser createUser(UserCreationRequest request) {
        IUser user = new IUser();

        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public IUser updateUser(String userId, UserUpdateRequest request) {
        IUser user = getUser(userId);

        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<IUser> getUsers() {
        return userRepository.findAll();
    }

    public IUser getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}

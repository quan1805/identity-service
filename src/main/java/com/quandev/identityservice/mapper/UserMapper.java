package com.quandev.identityservice.mapper;

import com.quandev.identityservice.dto.request.UserCreationRequest;
import com.quandev.identityservice.dto.request.UserUpdateRequest;
import com.quandev.identityservice.dto.response.UserResponse;
import com.quandev.identityservice.entity.IUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    IUser toUser(UserCreationRequest request);

//    @Mapping(source = "firstName", target = "lastName") //mapping firstName -> lastName
//    @Mapping(target = "lastName", ignore = true) //don't mapping lastName
    UserResponse toUserResponse(IUser user);
    List<UserResponse> toListUserResponse(List<IUser> users);
    void updateUser(@MappingTarget IUser user, UserUpdateRequest request);
}

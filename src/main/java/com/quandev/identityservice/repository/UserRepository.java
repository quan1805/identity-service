package com.quandev.identityservice.repository;

import com.quandev.identityservice.entity.IUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<IUser, String> {
    boolean existsByUsername(String username);
}

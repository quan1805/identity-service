package com.quandev.identityservice.repository;

import com.quandev.identityservice.entity.IUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<IUser, String> {
    boolean existsByUsername(String username);
    Optional<IUser> findByUsername(String username);
}

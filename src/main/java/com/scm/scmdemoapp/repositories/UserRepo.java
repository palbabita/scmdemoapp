package com.scm.scmdemoapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.scmdemoapp.entities.User;

public interface UserRepo extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);
}

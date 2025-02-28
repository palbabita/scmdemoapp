package com.scm.scmdemoapp.services;

import java.util.List;
import java.util.Optional;

import com.scm.scmdemoapp.entities.User;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(String id);
    Optional<User> updatUser(User user);
    void deleteUser(String id);
    boolean isUserExist(String userId);
    boolean isEmailExist(String emailId);
    List<User> getAllUser();


}

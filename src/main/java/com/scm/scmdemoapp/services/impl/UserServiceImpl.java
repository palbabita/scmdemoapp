package com.scm.scmdemoapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.scmdemoapp.entities.User;
import com.scm.scmdemoapp.helpers.ResourceNotFoundException;
import com.scm.scmdemoapp.repositories.UserRepo;
import com.scm.scmdemoapp.services.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {

        // generating randon userId
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        // // encoding password
        // user.setPassword(userId);
        // user.setProfile("userId");

        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updatUser(User user) {
       User user2= userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfile(user.getProfile());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());


        // save the updated user in db
        User save=userRepo.save(user2);

        return Optional.ofNullable(save);

    }

    @Override
    public void deleteUser(String id) {
        User user2 = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
         userRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user2= userRepo.findById(userId).orElse(null);
        return user2!=null ? true:false;
    }

    @Override
    public boolean isEmailExist(String emailId) {
        User user2=userRepo.findByEmail(emailId).orElse(null);
        return user2!=null ? true:false; 
    }

    @Override
    public List<User> getAllUser() {
       return userRepo.findAll();
    }

}

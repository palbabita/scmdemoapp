package com.scm.scmdemoapp.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class User {
    @Id
private String userId;
@Column(name = "userName", nullable = false)
private String name;
@Column(unique = true, nullable = false)
private String email;
private String phoneNumber;
private String password;
@Column(length = 500)
private String about;
@Column(length = 1000)
private String profile;
private boolean enabled=false;
private boolean emailVerified=false;
private boolean phoneVerified=false;

// How the user signedUp
@Enumerated(value = EnumType.STRING)
private Providers provider= Providers.SELF;
private String providerUserId;

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
private List<Contact> contacts = new ArrayList<>();


}

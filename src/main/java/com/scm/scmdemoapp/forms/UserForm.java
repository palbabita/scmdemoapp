package com.scm.scmdemoapp.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    @NotBlank(message = "Usename is required")
    @Size(min = 3, max = 20, message = "length should be 3-20 char")
private String name;
@Email(message = "Enter Valid Email Expression")
@NotBlank(message = "Enter VAlid Email")
private String email;
@NotBlank(message = "Password is required")
@Size(min = 8, max = 20)
private String password;
@NotBlank(message = "About is required")
private String about;
@Size(min = 10, max = 10, message = "Enter valid Contact Number")
private String phoneNumber;
}

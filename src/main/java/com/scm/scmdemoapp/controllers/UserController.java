package com.scm.scmdemoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

// user dashboard page
@RequestMapping(value = "/dashboard",method=RequestMethod.GET)
public String userDashboard(){
    return "user/dashboard";
}
@RequestMapping(value = "/profile", method = RequestMethod.GET)
public String userProfile(){
    return "user/profile";
}
// user add contact page

// user view contact page.... and bla bla.....
}

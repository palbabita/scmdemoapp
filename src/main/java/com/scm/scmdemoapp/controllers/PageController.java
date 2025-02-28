package com.scm.scmdemoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scmdemoapp.entities.User;
import com.scm.scmdemoapp.forms.UserForm;
import com.scm.scmdemoapp.helpers.Message;
import com.scm.scmdemoapp.helpers.MessageType;
import com.scm.scmdemoapp.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {
@Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model){
            System.out.println("Home page controller");
            model.addAttribute("name", "Babita pal");
            model.addAttribute("gmail", "gmail@gmail.com");
            model.addAttribute("git", "hithub.com");
        return "home";
    }

    @RequestMapping("/about")
    public String about(){
        System.out.println("About Page");
        return "about";
    }

    @RequestMapping("/services")
    public String services(){
        System.out.println("Sevice page");
        return "service";
    }
    @RequestMapping("/register")
    public String register(Model model){
        System.out.println("Register page");
        UserForm userForm= new UserForm();
        userForm.setName("Babita");
        model.addAttribute("userForm",userForm);
        return "register";
    }
    @RequestMapping(value = "/do-register", method= RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session){
        System.out.println("Register");
        // fetch form data
        // User form
        System.out.println(userForm);
        // validate form data
        // save to database

        // converted userForm data to user. data fetched from userForm and filled in user property


        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .phoneNumber(userForm.getPhoneNumber())
        // .about(userForm.getAbout())
        // .profile("https://media.istockphoto.com/id/619400810/photo/mr-who.jpg?s=2048x2048&w=is&k=20&c=ajUh75eNfNRDL0M0pcCOfq82dlak8mKavlAKgNbMgl4=")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setAbout(userForm.getAbout());
        user.setProfile("https://media.istockphoto.com/id/619400810/photo/mr-who.jpg?s=2048x2048&w=ik=20c=ajUh75eNfNRDL0M0pcCOfq82dlak8mKavlAKgNbMgl4=");
        User savedUser = userService.saveUser(user);
        System.out.println(savedUser);
        // message="Registration Successfull"
       Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", message);
        // redirected to login page
        return "redirect:/register";
    }
}

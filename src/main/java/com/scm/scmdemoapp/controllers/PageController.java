package com.scm.scmdemoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scmdemoapp.forms.UserForm;

@Controller
public class PageController {
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
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("Register");
        // fetch form data
        // User form
        System.out.println(userForm);
        // validate form data
        // save to database
        // message="Registration Successfull"
        // redirected to login page
        return "redirect:/register";
    }
}

package hu.schonherz.basicbloggerwebapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by bmbal on 2016. 07. 28..
 */
public class LoginController{

@RequestMapping("/login")
    public ModelAndView login(){
        String message = "Welcome! Login to continue";
    return new ModelAndView("login.jsp");
}
}

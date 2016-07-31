package hu.schonherz.basicblogger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bmbal on 2016. 07. 30..
 */
@Controller
public class LoginController {
    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String getLoginScreen(ModelMap model) {
        return "login";
    }

    @RequestMapping(name = "/login", method = RequestMethod.POST)
    public String redirectToIndexPage(ModelMap model, HttpServletRequest req) {
        return "redirect:index";
    }
}

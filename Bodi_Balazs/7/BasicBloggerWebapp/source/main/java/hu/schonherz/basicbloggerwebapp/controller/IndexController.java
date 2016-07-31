package hu.schonherz.basicbloggerwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bmbal on 2016. 07. 28..
 */

@Controller
@RequestMapping("/login")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("welcome", "Hello there");
        return "index";
    }
}

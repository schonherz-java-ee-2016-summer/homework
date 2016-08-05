package hu.schonherz.basicblogger.controllers;

import hu.schonherz.basicblogger.user.User;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by bmbal on 2016. 07. 30..
 */
@Controller
@RequestMapping("/*")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private User user;

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginScreen(ModelMap model) {
        return "login";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String redirectToIndexPage(@RequestParam(name = "author" , required = true) String author, ModelMap model) {
        try {
            author = StringEscapeUtils.escapeHtml4(author);
            author = URLDecoder.decode(author, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setName(author);
        LOG.info(user.getName() + " was logged in. Redirecting to index page.");
        return "redirect:index";
    }
}

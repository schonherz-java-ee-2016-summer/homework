package hu.schonherz.training.controller;

import hu.schonherz.training.dao.BlogDao;
import hu.schonherz.training.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Roli on 2016. 07. 30..
 */
@Controller
@RequestMapping(path = "/index")
public class IndexController {

    @Autowired
    private BlogDao blogDao;

    @RequestMapping(method = RequestMethod.GET)
    public String loadIndex(ModelMap modelMap) {
        List<Blog> blogs = blogDao.findAll();
        modelMap.addAttribute("posts", blogs);
        return "index";
    }
}

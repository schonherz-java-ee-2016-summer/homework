package hu.schonherz.training.controller;

import hu.schonherz.training.service.BlogService;
import hu.schonherz.training.vo.BlogVo;
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
    private BlogService blogService;

    @RequestMapping(method = RequestMethod.GET)
    public String loadIndex(ModelMap modelMap) {
        List<BlogVo> blogs = blogService.getAllBlog();
        modelMap.addAttribute("posts", blogs);
        return "index";
    }
}

package hu.nutty.kepzes.blogapp.services.implementations;

import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.dto.BloggerDTO;
import hu.nutty.kepzes.blogapp.services.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nutty on 2016.08.07..
 */
public class BloggerServiceImpl implements BloggerService {
    @Autowired
    private BloggerDAO bloggerDAO;

    @Override
    public BloggerDTO findBloggerByNickName(String nickName) {
        return null;
    }

    @Override
    public void createBlogger(BloggerDTO bloggerDTO) {

    }
}

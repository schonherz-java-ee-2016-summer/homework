package hu.nutty.kepzes.blogapp.services.implementations;

import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.dto.BloggerDTO;
import hu.nutty.kepzes.blogapp.services.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nutty on 2016.08.07..
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BloggerServiceImpl implements BloggerService {
    @Autowired
    private BloggerDAO bloggerDAO;

    @Override
    public BloggerDTO getBloggerById(Long id) {
        BloggerDTO bloggerDTO = null;
        try {
            bloggerDAO.find(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bloggerDTO;
    }

    @Override
    public Long createBlogger(BloggerDTO bloggerDTO) {
        Long id = null;
        try {
            id = bloggerDAO.save(bloggerDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}

package hu.nutty.kepzes.blogapp.services.implementations;

import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dto.BlogPostDTO;
import hu.nutty.kepzes.blogapp.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nutty on 2016.08.07..
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BlogPostServiceImpl implements BlogPostService {
    @Autowired
    private BlogPostDAO blogPostDAO;

    @Override
    public List<BlogPostDTO> getAllBlogPosts() {
        List<BlogPostDTO> posts = null;
        try {
            posts = blogPostDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public BlogPostDTO getBlogPostById(Long id) {
        BlogPostDTO blogPostDTO = null;
        try {
            blogPostDTO = blogPostDAO.find(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blogPostDTO;
    }

    @Override
    public Long createBlogPost(BlogPostDTO blogPostDTO) {
        Long id = null;
        try {
            id = blogPostDAO.save(blogPostDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    @Override
    public void updateBlogPost(BlogPostDTO blogPostDTO) {
        try {
            blogPostDAO.update(blogPostDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

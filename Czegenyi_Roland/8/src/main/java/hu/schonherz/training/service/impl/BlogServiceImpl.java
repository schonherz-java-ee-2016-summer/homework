package hu.schonherz.training.service.impl;

import hu.schonherz.training.dao.BlogDao;
import hu.schonherz.training.service.mapper.BlogMapper;
import hu.schonherz.training.vo.BlogVo;
import hu.schonherz.training.pojo.Blog;
import hu.schonherz.training.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roli on 2016. 08. 07..
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public List<BlogVo> getAllBlog() {
        List<Blog> blogs = null;

        blogs = blogDao.findAll();

        return BlogMapper.toVo(blogs);
    }

    @Override
    public BlogVo getBlogById(Long id) {
        Blog blog = null;
        blog = blogDao.findById(id);

        return BlogMapper.toVo(blog);
    }

    @Override
    public void createBlog(BlogVo blogVo) {
        blogDao.save(BlogMapper.toDto(blogVo));
    }
}

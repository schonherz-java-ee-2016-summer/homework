package hu.schonherz.training.service;

import hu.schonherz.training.vo.BlogVo;

import java.util.List;

/**
 * Created by Roli on 2016. 08. 07..
 */
public interface BlogService {

    List<BlogVo> getAllBlog();

    BlogVo getBlogById(Long id);

    void createBlog(BlogVo blogVo);
}

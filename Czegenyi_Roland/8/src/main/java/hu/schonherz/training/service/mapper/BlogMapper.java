package hu.schonherz.training.service.mapper;


import hu.schonherz.training.vo.BlogVo;
import hu.schonherz.training.pojo.Blog;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roli on 2016. 08. 07..
 */
public class BlogMapper {

    private static Mapper mapper = new DozerBeanMapper();

    public static BlogVo toVo(Blog blogDto) {
        if (blogDto == null) {
            return null;
        }
        return mapper.map(blogDto, BlogVo.class);
    }

    public static Blog toDto(BlogVo blogVo) {
        if (blogVo == null) {
            return null;
        }
        return mapper.map(blogVo, Blog.class);
    }

    public static List<BlogVo> toVo(List<Blog> blogDtos) {
        List<BlogVo> blogVos = new ArrayList<>();
        for (Blog blogDto : blogDtos) {
            blogVos.add(toVo(blogDto));
        }
        return blogVos;
    }

    public static List<Blog> toDto(List<BlogVo> blogVos) {
        List<Blog> blogDtos = new ArrayList<>();
        for (BlogVo blogVo : blogVos) {
            blogDtos.add(toDto(blogVo));
        }
        return blogDtos;
    }
}

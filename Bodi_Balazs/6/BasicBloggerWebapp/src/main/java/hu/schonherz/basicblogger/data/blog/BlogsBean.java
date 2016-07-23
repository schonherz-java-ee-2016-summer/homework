package hu.schonherz.basicblogger.data.blog;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 19..
 * This Bean encapsulating a number of comments
 */
public class BlogsBean implements Serializable{
    private List<Blog> blogList = new LinkedList<>();

    public List<Blog> getBlog() {
        return blogList;
    }

    public void setBlog(List<Blog> blogList) {
        this.blogList = blogList;
    }
}

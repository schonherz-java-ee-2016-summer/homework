package hu.schonerz.training.beans;

import hu.schonerz.training.pojo.Blog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlogBean implements Serializable {

    private static final long serialVersionUID = 23417865912376L;

    private List<Blog> blogs;

    public BlogBean() {
        this.blogs = new ArrayList<>();
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(final List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Blog findBlog(final int id) {
        return blogs.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();
    }

    public void addBlog(Blog b) {
        blogs.add(b);
    }

}

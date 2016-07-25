package hu.schonerz.training.beans;

import hu.schonerz.training.pojo.Blog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A class for storing data about blogs.
 */

public class BlogBean implements Serializable {

    private static final long serialVersionUID = 23417865912376L;


    private List<Blog> blogs;

    public BlogBean() {
        this.blogs = new ArrayList<>();
    }

    /**
     * Get all {@link hu.schonerz.training.pojo.Blog}.
     *
     * @return blogs list of the blogs
     */
    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(final List<Blog> blogs) {
        this.blogs = blogs;
    }

    /**
     * Find a blog by id.
     *
     * @param id id of the blog
     * @return a blog object with the <code>id</code> in the parameter
     */
    public Blog findBlog(final int id) {
        return blogs.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .get();
    }

    /**
     * Add a new blog to list.
     *
     * @param b the new blog object
     */
    public void addBlog(Blog b) {
        blogs.add(b);
    }

}

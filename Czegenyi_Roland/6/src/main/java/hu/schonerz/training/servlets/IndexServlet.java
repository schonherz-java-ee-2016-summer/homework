package hu.schonerz.training.servlets;

import hu.schonerz.training.pojo.Blog;
import hu.schonerz.training.beans.BlogBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class IndexServlet extends HttpServlet {

    BlogBean blogBean = new BlogBean();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Blog blog = new Blog(req.getParameter("AUTHOR_NAME"),
                req.getParameter("TITLE"),
                req.getParameter("CONTENT"));

        blogBean.addBlog(blog);

        req.getServletContext().setAttribute("blogb", blogBean);

        req.getServletContext().setAttribute("posts", blogBean.getBlogs());

        req.getServletContext().setAttribute("blog", blog);

        resp.sendRedirect("/post?id=" + blog.getId());


    }
}

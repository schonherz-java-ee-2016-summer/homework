package hu.schonerz.training.servlets;

import hu.schonerz.training.pojo.Blog;
import hu.schonerz.training.beans.BlogBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
//lht h nem kell
        List<Blog> posts = (ArrayList) req.getServletContext().getAttribute("posts");

        BlogBean c = (BlogBean) (req.getServletContext().getAttribute("blogb"));

        c.getBlogs().addAll(posts);

        Blog blog = c.findBlog(Integer.parseInt(id));

        /*System.out.print("alma" + blog.getAuthor());
        System.out.print(id);*/


        req.getServletContext().setAttribute("blog", blog);

        resp.sendRedirect("/post?id=" + id);
    }
}

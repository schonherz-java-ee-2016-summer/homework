package hu.schonherz.java.training.blog12.web.servlets;

import hu.schonherz.java.training.blog12.data.post.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Home on 2016. 07. 20..
 */

@WebServlet(name = "new" ,urlPatterns = "/new")
public class NewPost extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Post newPost = (Post) getServletContext().getAttribute("newpost");
        int id = newPost.getId();
        String author = newPost.getAuthor();
        String title = newPost.getTitle();
        String content = newPost.getContent();

        req.setAttribute("id",id);
        req.setAttribute("author",author);
        req.setAttribute("title",title);
        req.setAttribute("content",content);

        req.getRequestDispatcher("/newpost").forward(req,resp);


    }
}

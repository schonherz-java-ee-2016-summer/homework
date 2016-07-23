package hu.schonherz.java.training.blog12.web.servlets;

import hu.schonherz.java.training.blog12.data.post.Post;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Home on 2016. 07. 19..
 */

//@WebServlet(name = "index" , urlPatterns = "/index")
public class Index extends HttpServlet {


    private static final String KEY_AUTHOR = "author";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map < String, String > formData = ( Map < String , String> )req.getAttribute("formData");

        int id = 1;
        String author = formData.get(KEY_AUTHOR);
        String title = formData.get(KEY_TITLE);
        String content = formData.get(KEY_CONTENT);


        Post newPost = new Post.PostBuilder(author,title).content(content).build();


        req.setAttribute("newpost",newPost);
        getServletContext().setAttribute("newpost",newPost);
        resp.sendRedirect(req.getContextPath() + "/newpost");


    }
}

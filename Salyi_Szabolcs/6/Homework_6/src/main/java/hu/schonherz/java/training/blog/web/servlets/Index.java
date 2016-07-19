package hu.schonherz.java.training.blog.web.servlets;

import hu.schonherz.java.training.blog.data.post.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Home on 2016. 07. 19..
 */

@WebServlet(name = "index" , urlPatterns = "/index")
public class Index extends HttpServlet{


    private static final String KEY_AUTHOR = "author";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map < String, String > formData = ( Map < String , String> )req.getAttribute("formData");

        int id = 1;
        String author = formData.get(KEY_AUTHOR);
        String title = formData.get(KEY_TITLE);
        String content = formData.get(KEY_CONTENT);


        Post newPost = new Post.PostBuilder(id,author,title).content(content).bulid();
        HttpSession session = req.getSession(Boolean.TRUE);
        session.setAttribute("post", newPost);

        resp.sendRedirect(req.getContextPath() + "/post/new");


    }
}

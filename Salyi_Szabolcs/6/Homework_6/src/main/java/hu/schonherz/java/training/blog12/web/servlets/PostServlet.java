package hu.schonherz.java.training.blog12.web.servlets;

import hu.schonherz.java.training.blog12.data.post.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static hu.schonherz.java.training.blog12.data.post.PostBean.getPosts;

/**
 * Created by Home on 2016. 07. 27..
 */

@WebServlet(name = "PostServlet" , urlPatterns = "/post/*")
public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Post post = getPosts().get(Integer.parseInt(req.getParameter("id"))-1);
        req.getServletContext().setAttribute("post",post);
        req.getRequestDispatcher("/postview").forward(req,resp);
    }
}

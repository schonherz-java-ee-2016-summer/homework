package hu.training.homework.simpleblog.servlet;

import hu.training.homework.simpleblog.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "index-servlet", urlPatterns = "/index-servlet")
public class IndexServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexServlet.class);

    private static final String COMMENTER_INPUT_NAME = "author";
    private static final String POST_CONTENT_NAME = "content";
    private static final String POSTS_ATTRIBUTE_NAME = "posts";

    private List<Post> posts = new ArrayList<Post>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("posts", posts);

        //Post newPost = parseBodyAsPost(req);
        Post newPost = new Post(req.getParameter(COMMENTER_INPUT_NAME), "Title of post", req.getParameter(POST_CONTENT_NAME));
        posts.add(newPost);

        req.getSession().setAttribute(POSTS_ATTRIBUTE_NAME, posts);

        resp.sendRedirect("/index");
    }
}
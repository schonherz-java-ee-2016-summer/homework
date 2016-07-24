package hu.training.homework.simpleblog.servlet;

import hu.training.homework.simpleblog.model.Post;
import hu.training.homework.simpleblog.util.Parameters;
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

/**
 * This servlet creates and stores new {@link Post} objects of the added new blogposts.
 * The list of posts is accessible in a session-scope attribute.
 */
@WebServlet(name = "index-servlet", urlPatterns = "/index-servlet")
public class IndexServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexServlet.class);

    private List<Post> posts = new ArrayList<Post>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Post newPost = new Post(req.getParameter(Parameters.COMMENTER_INPUT_NAME), req.getParameter(Parameters.POST_CONTENT_NAME));
        posts.add(newPost);

        LOGGER.debug("Added new post: {}.", newPost);

        req.getSession().setAttribute(Parameters.POSTS_ATTRIBUTE_NAME, posts);

        resp.sendRedirect(Parameters.INDEX_PAGE);

        LOGGER.debug("Redirecting to " + Parameters.INDEX_PAGE);
    }
}

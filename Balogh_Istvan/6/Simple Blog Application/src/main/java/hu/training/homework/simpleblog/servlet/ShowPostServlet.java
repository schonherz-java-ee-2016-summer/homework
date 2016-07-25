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
 * This servlet handles the requests of selecting a post to view on the index page.
 */
@WebServlet(name = "ShowPostServlet", urlPatterns = "/showPost")
public class ShowPostServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShowPostServlet.class);

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding(Parameters.ENCODING);

        String selectedPostID = req.getParameter("id");

        List<Post> posts = (ArrayList) req.getServletContext().getAttribute(Parameters.POSTS_ATTRIBUTE_NAME);

        Post selectedPost = posts.stream()
                                    .filter(p -> p.getId().equals(selectedPostID))
                                    .findFirst()
                                    .get();

        LOGGER.debug("A post is selected: {}.", selectedPost);

        req.getServletContext().setAttribute(Parameters.SELECTED_POST_ATTRIBUTE_NAME, selectedPost);
        LOGGER.debug("Added new context attribute: {}.", Parameters.SELECTED_POST_ATTRIBUTE_NAME);

        resp.sendRedirect("/post?id=" + selectedPostID);
        LOGGER.debug("Redirecting to /post?id={}", selectedPostID);
    }
}

package hu.training.homework.simpleblog.servlet;

import hu.training.homework.simpleblog.model.Comment;
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
import java.net.URLDecoder;

/**
 * This servlet handles the requests of adding comments on a blogpost.
 * After creating a {@link Comment} object this comment is added to the comment list of the {@link Post}.
 */
@WebServlet(name = "CommentServlet", urlPatterns = "/comment-servlet")
public class CommentServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding(Parameters.ENCODING);
        resp.setCharacterEncoding(Parameters.ENCODING);

        String commenter = URLDecoder.decode(req.getParameter(Parameters.COMMENTER_INPUT_NAME), Parameters.ENCODING);
        String comment = URLDecoder.decode(req.getParameter(Parameters.COMMENT_INPUT_NAME), Parameters.ENCODING);

        Comment newComment = new Comment(commenter, comment);
        LOGGER.debug("Added new comment: {}.", newComment);

        Post selectedPost = (Post) req.getServletContext().getAttribute("selectedPost");

        selectedPost.getComments().add(newComment);

        resp.sendRedirect("/post?id=" + selectedPost.getId());
        LOGGER.debug("Redirecting to /post?id={}", selectedPost.getId());

    }
}

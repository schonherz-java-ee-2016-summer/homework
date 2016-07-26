package hu.nutty.kepzes.blogapp.servlet;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.Comment;
import hu.nutty.kepzes.blogapp.beans.CommentsBean;
import hu.nutty.kepzes.blogapp.utils.ParserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static hu.nutty.kepzes.blogapp.utils.Constants.*;


/**
 * Custom extension of {@code HttpServlet}.
 * <p>
 * This servlet implements a little commenting functionality, nothing serious.
 * Using POST, the user can submit a new comment.
 */
public class CommentsServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CommentsServlet.class);

    /**
     * Handles POST requests coming to /comments.
     * We expect the request to have a request body of plain text data (a new comment).
     * <p>
     * After storing the incoming data on ServletContext scope, we redirect the client.
     *
     * @param req the incoming HTTP request
     * @param res the outgoing HTTP response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        LOG.debug("Handling POST request to /comments...");

        req.setCharacterEncoding(ENCODING);
        res.setCharacterEncoding(ENCODING);

        Comment newComment = ParserUtils.parseBodyAsComment(req);
        ServletContext context = req.getServletContext();
        BlogPost post = (BlogPost) context.getAttribute(SELECTED_POST);
        if (post != null) {
            newComment.setBlogPostID(post.getPostID());
            post.getComments().getComments().add(newComment);
            res.sendRedirect(req.getContextPath() + "/post/" + post.getPostID());
        } else {
            res.sendRedirect(req.getContextPath() + "/index");
        }
    }

}

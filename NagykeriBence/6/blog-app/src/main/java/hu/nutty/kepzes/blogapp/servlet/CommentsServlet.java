package hu.nutty.kepzes.blogapp.servlet;

import hu.nutty.kepzes.blogapp.beans.CommentsBean;
import hu.nutty.kepzes.blogapp.utils.ParserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * A user gets a list of comments (strings) if he sends a GET request while
 * using POST, he can submit a new comment.
 */
public class CommentsServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CommentsServlet.class);

    private CommentsBean comments;
    private String[] contributors = {"Robert Discoteque", "John Cena"};

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("Handling GET request to /comments...");

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setCharacterEncoding(ENCODING);

        String name = (req.getParameter(COMMENTER_INPUT_NAME) != null ? req.getParameter(COMMENTER_INPUT_NAME) : "Anonymous");
        HttpSession session = req.getSession();
        session.setAttribute(COMMENTER_INPUT_NAME, name);
        comments = (CommentsBean) ParserUtils.getListFromSessionByKey(req, COMMENTS_SESSION_KEY);
        if (comments.getComments().isEmpty()) {
            session.setAttribute(COMMENTLIST, null);
        } else {
            session.setAttribute(COMMENTLIST, comments.getComments());
        }

        resp.sendRedirect(req.getContextPath() + "/comments.jsp");
    }

    /**
     * Handles POST requests coming to /comments.
     * We expect the request to have a request body of plain text data (a new comment).
     * <p>
     * After storing the incoming data on Session scope, we redirect the client.
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

        comments = (CommentsBean) ParserUtils.getListFromSessionByKey(req, COMMENTS_SESSION_KEY);
        comments.getComments().add(ParserUtils.parseBodyAsComment(req));

        req.getSession().setAttribute(COMMENTS_SESSION_KEY, this.comments);
        res.sendRedirect(req.getContextPath() + "/comments");

    }

    /**
     * Returns with an instance of {@code CommentsBean}, stored in the Session.
     *
     * @param req the request which is part of the Session.
     * @return an instance of {@code CommentsBean}.
     */
    /*
    private CommentsBean getCommentsFromSession(final HttpServletRequest req) {
        HttpSession session = req.getSession(true);

        if (session.getAttribute(COMMENTS_SESSION_KEY) == null) {
            session.setAttribute(COMMENTS_SESSION_KEY, new CommentsBean());
        }

        return (CommentsBean) session.getAttribute(COMMENTS_SESSION_KEY);
    }

    private Comment parseBodyAsComment(final HttpServletRequest req) {
        Properties formProperties = RequestUtils.parseFormBody(req);
        Comment commentFromBody = new Comment();

        commentFromBody.setCommenter(formProperties.getProperty(COMMENTER_INPUT_NAME, "Anonymous"));
        commentFromBody.setContent(formProperties.getProperty(NEW_COMMENT_INPUT_NAME, ""));

        LOG.debug("Got new comment: {}.", commentFromBody);

        return commentFromBody;
    }
*/
}

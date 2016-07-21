package hu.nutty.kepzes.blogapp.servlet;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.BlogPostsBean;

import hu.nutty.kepzes.blogapp.utils.ParserUtils;
import hu.nutty.kepzes.blogapp.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.Properties;

import static hu.nutty.kepzes.blogapp.utils.Constants.*;

/**
 * Custom extension of {@code HttpServlet}.
 * <p>
 * This servlet implements a little blog posting functionality, nothing serious.
 * A user gets a list of posts if he sends a GET request while
 * using POST, he can submit a new blog post.
 */
public class BlogPostServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(BlogPostServlet.class);

    private BlogPostsBean posts;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("Handling GET request to /posts...");

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setCharacterEncoding(ENCODING);

        // String name = (req.getParameter(POST_INPUT_NAME) != null ? req.getParameter(POST_INPUT_NAME) : "Anonymous");

        //comments = getCommentsFromSession(req);

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
        LOG.debug("Handling POST request to /posts...");

        req.setCharacterEncoding(ENCODING);
        res.setCharacterEncoding(ENCODING);

        posts = (BlogPostsBean) ParserUtils.getListFromContextByKey(req, POST_SESSION_KEY);
        posts.getPosts().add(ParserUtils.parseBodyAsPost(req));

        req.getSession().setAttribute(POST_SESSION_KEY, this.posts);
        res.sendRedirect(req.getContextPath() + "/posts");
    }

}

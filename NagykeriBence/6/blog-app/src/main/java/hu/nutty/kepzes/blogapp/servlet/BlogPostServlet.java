package hu.nutty.kepzes.blogapp.servlet;

import hu.nutty.kepzes.blogapp.beans.BlogPostsBean;
import hu.nutty.kepzes.blogapp.utils.ParserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        ServletContext context = req.getServletContext();
        String[] qs = req.getQueryString().split("=");
        int id = 0;
        if ("p".equals(qs[0])) {
            id = Integer.parseInt(qs[1]);
        }
        posts = (BlogPostsBean) ParserUtils.getListFromContextByKey(req, INDEX_SESSION_KEY);
        context.setAttribute(SELECTED_POST, posts.getPosts().get(id - 1));
        resp.sendRedirect(req.getContextPath() + "/post/" + id);

    }

}

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
 * This servlet implements a blog displaying functionality with more details, nothing serious.
 * A user gets a post if he sends a GET request
 */
public class BlogPostServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(BlogPostServlet.class);

    private BlogPostsBean posts;

    /**
     * Handles GET requests coming to /posts.
     * We push the selected post to the ServletContext, after we redirect to the proper .jsp, and display it.
     *
     * @param req  the incoming HTTP request
     * @param resp the outgoing HTTP response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("Handling GET request to /posts...");

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setCharacterEncoding(ENCODING);
        ServletContext context = req.getServletContext();
        int id = Integer.parseInt(req.getParameter("p"));
        if (context.getAttribute(INDEX_KEY) == null) {
            context.setAttribute(INDEX_KEY, new BlogPostsBean());
        }
        posts = (BlogPostsBean) context.getAttribute(INDEX_KEY);
        context.setAttribute(SELECTED_POST, posts.getPosts().get(id - 1));
        resp.sendRedirect(req.getContextPath() + "/post/" + id);
    }
}

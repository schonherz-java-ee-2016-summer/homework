package hu.schonerz.training.servlets;

import hu.schonerz.training.pojo.Blog;
import hu.schonerz.training.beans.BlogBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServlet implementation, for creating new blogposts..
 */
public class IndexServlet extends HttpServlet {

    public static final Logger LOG = LoggerFactory.getLogger(IndexServlet.class);

    public final BlogBean blogBean = new BlogBean();

    /**
     * Posting a new blogpost, and add that to bloglist.
     * If the user posted a new, or selected an existed post,
     * he will be forwarded, to posts page {@link hu.schonerz.training.servlets.PostServlet}.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException EervletException
     * @throws IOException      IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Blog blog = new Blog(req.getParameter("AUTHOR_NAME"),
                req.getParameter("TITLE"),
                req.getParameter("CONTENT"));

        LOG.info("New blog created from parameters.");

        blogBean.addBlog(blog);
        LOG.info("Added new blog:" + blog);

        req.getServletContext().setAttribute("blogb", blogBean);
        req.getServletContext().setAttribute("posts", blogBean.getBlogs());
        req.getServletContext().setAttribute("blog", blog);

        resp.sendRedirect("/post?id=" + blog.getId());
        LOG.info("Redirected to: /post?id=" + blog.getId());
    }
}

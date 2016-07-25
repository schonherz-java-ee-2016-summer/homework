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
 * HttpServlet implementation for viewing detailed blogpost page.
 */
public class PostServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(PostServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        LOG.info("Get post id from servletRequest", id);

        BlogBean c = (BlogBean) (req.getServletContext().getAttribute("blogb"));
        LOG.info("Get data from servletContext");

        Blog blog = c.findBlog(Integer.parseInt(id));

        req.getServletContext().setAttribute("blog", blog);

        resp.sendRedirect("/post?id=" + id);
        LOG.info("Redirected to: /post?id=", id);
    }
}

package hu.schonerz.training.servlets;

import hu.schonerz.training.pojo.Blog;
import hu.schonerz.training.beans.BlogBean;
import hu.schonerz.training.pojo.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServlet implementation for creating a new comment for a blogpost.
 */
public class CommentServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(CommentServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BlogBean c = (BlogBean) (req.getServletContext().getAttribute("blogb"));
        LOG.info("Get data from servletContext");

        String postID = req.getParameter("id");
        LOG.info("Get " + postID + " post id from servletRequest.");

        Comment comment = new Comment(req.getParameter("CONTENT"));
        LOG.info("New comment added.");

        Blog commentedBlog = c.findBlog(Integer.parseInt(postID));
        LOG.info("Find blog with id " + postID);

        commentedBlog
                .getComments()
                .add(comment);

        req.getServletContext().setAttribute("comment", commentedBlog.getComments());

        resp.sendRedirect("/post?id=" + commentedBlog.getId());
        LOG.info("Redirected to: /post?id=" + +commentedBlog.getId());
    }
}

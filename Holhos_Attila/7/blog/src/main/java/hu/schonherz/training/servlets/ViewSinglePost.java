package hu.schonherz.training.servlets;

import hu.schonherz.training.jdbcTemplates.PostDaoImpl;
import hu.schonherz.training.models.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Attila on 2016.07.19..
 */
public class ViewSinglePost extends HttpServlet{

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewSinglePost.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer postID = Integer.parseInt(req.getParameter("ID"));
        Post post = (new PostDaoImpl().getPostByID(postID));
        getServletContext().setAttribute("post", post);
        LOGGER.info("Somebody view post " + (postID) + "!");
        req.getRequestDispatcher("/viewPost").forward(req, resp);
    }
}

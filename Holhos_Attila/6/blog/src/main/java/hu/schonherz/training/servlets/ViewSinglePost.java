package hu.schonherz.training.servlets;

import hu.schonherz.training.models.Comment;
import hu.schonherz.training.models.Post;
import hu.schonherz.training.models.PostsList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Attila on 2016.07.19..
 */
public class ViewSinglePost extends HttpServlet{

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewSinglePost.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostsList posts = new PostsList();
        posts.setPostsList((ArrayList) getServletContext().getAttribute("postsList"));
        Integer postID = Integer.parseInt(req.getParameter("ID"));
        Post post = posts.getPost(postID);
        getServletContext().setAttribute("post", post);
        LOGGER.info("Somebody view post " + (postID) + "!");
        req.getRequestDispatcher("/viewPost").forward(req, resp);
    }
}

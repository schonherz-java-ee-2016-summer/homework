package hu.schonherz.training.servlets;

import hu.schonherz.training.models.Comment;
import hu.schonherz.training.models.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static hu.schonherz.training.models.PostsList.getPostsList;

/**
 * Created by Attila on 2016.07.19..
 */
public class APost extends HttpServlet{

    private static Logger LOGGER = LoggerFactory.getLogger(APost.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer postID = Integer.parseInt(req.getParameter("ID"));
        List<Post> posts = getPostsList();
        Post post = posts.get(postID);
        List<Comment> commentList = post.getComments();
        LOGGER.info("Somebody view post #" + (postID) + "!");
        ServletContext context = getServletContext();
        context.setAttribute("post", post);
        context.setAttribute("comments", commentList);
        context.setAttribute("postID", postID);
        resp.sendRedirect("/blog/viewPost");
    }

}

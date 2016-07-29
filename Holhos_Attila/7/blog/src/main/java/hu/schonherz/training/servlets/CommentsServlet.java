package hu.schonherz.training.servlets;

import hu.schonherz.training.jdbcTemplates.CommentDaoImpl;
import hu.schonherz.training.models.Comment;
import hu.schonherz.training.models.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Attila on 2016.07.21..
 */
public class CommentsServlet extends HttpServlet{

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentsServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Comment comment = createComment(req);
        Post post = (Post) req.getServletContext().getAttribute("post");
        post.getComments().add(comment);
        (new CommentDaoImpl()).createComment(post.getPostID(), comment);
        LOGGER.info("Add a new comment to post" + post.getPostID());
        resp.sendRedirect("/blog/post" + "?ID=" + post.getPostID());
    }

    public Comment createComment(final HttpServletRequest req){
        Comment comment = new Comment();
        comment.setCommentDate(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
        comment.setContent(req.getParameter("newcomment"));
        return comment;
    }
}

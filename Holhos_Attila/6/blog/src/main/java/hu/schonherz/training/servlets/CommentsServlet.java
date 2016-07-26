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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static hu.schonherz.training.utils.RequestUtils.readPostsListsFromContext;
import static hu.schonherz.training.utils.RequestUtils.readRequest;

/**
 * Created by Attila on 2016.07.21..
 */
public class CommentsServlet extends HttpServlet{

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentsServlet.class);
    private PostsList posts;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        posts = readPostsListsFromContext(req);
        Comment comment = createComment(req);
        Integer postID = Integer.parseInt(req.getParameter("ID"));
        for (Post post : posts.getPostsList()){
            if (post.getPostID() == postID){
                post.getComments().add(comment);
                context.setAttribute("commentsList", post.getComments());
            }
        }
        resp.sendRedirect("/blog/post/" + "?ID=" + postID);
    }

    public Comment createComment(final HttpServletRequest req){
        Properties properties = readRequest(req);
        Comment comment = new Comment();
        comment.setCommentID(posts.getPostsList().size());
        comment.setCommentDate(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
        System.out.print(properties.getProperty("newcomment", ""));
        comment.setContent(properties.getProperty("newcomment", ""));
        return comment;
    }
}

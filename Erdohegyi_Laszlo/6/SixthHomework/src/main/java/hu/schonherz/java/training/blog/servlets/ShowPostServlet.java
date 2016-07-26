package hu.schonherz.java.training.blog.servlets;

import hu.schonherz.java.training.blog.pojo.BlogComment;
import hu.schonherz.java.training.blog.pojo.BlogPost;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * An HttpServlet to manage requests/responces.
 */
public class ShowPostServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowPostServlet.class);

    private static final String POSTS = "posts";
    private static final String POST_ID = "postId";

    private static int postId;
    private static int commentId = 0;
    private static List<BlogPost> posts = new ArrayList<>();
    private static List<BlogComment> coms = new ArrayList<>();

    /**
     * An implementation of doGet which selects the actual post from posts.
     * @param req HTTP request
     * @param resp HTTP responce
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        posts = (List<BlogPost>) context.getAttribute(POSTS);
        postId = (int) context.getAttribute(POST_ID);

        BlogPost actPost = posts.get(postId - 1);

        context.setAttribute("actual_post", actPost);
        resp.sendRedirect(req.getContextPath() + "/showpost/" + postId);

        LOGGER.info("Redirecting to " + req.getContextPath() + "/showpost/" + postId);
    }

    /**
     * An implementation of doPost which reads the attributes of a comment for the actual post.
     * @param req HTTP request
     * @param resp HTTP responce
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        posts = (List<BlogPost>) context.getAttribute(POSTS);
        postId = (int) context.getAttribute(POST_ID);
        BlogPost actPost = posts.get(postId - 1);

        commentId++;

        String comContent = URLDecoder.decode(req.getParameter("comcontent"), "UTF-8");
        comContent = StringEscapeUtils.escapeHtml4(comContent);

        coms.add(new BlogComment(commentId, LocalDateTime.now(), comContent));
        LOGGER.info("New comment added!");

        actPost.setComments(coms);
        context.setAttribute(POSTS, posts);

        resp.sendRedirect(req.getContextPath() + "/showpost/" + postId);

        LOGGER.info("Redirecting to " + req.getContextPath() + "/showpost/" + postId);
    }
}

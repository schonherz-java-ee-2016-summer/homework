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
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Attila on 2016.07.18..
 */
public class BlogPostServlet extends HttpServlet{

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServlet.class);
    private List<Post> posts = (new PostDaoImpl()).getAllPosts();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.getServletContext().setAttribute("postsList", posts);
        LOGGER.info("Run!");
        resp.sendRedirect(req.getContextPath() + "/index");;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Post post = createPost(req);
        posts.add(post);
        (new PostDaoImpl()).createPost(post);
        req.getServletContext().setAttribute("postsList", posts);
        LOGGER.info("Add the new post!");
        resp.sendRedirect(req.getContextPath() + "/index");
    }

    public Post createPost(final HttpServletRequest req){
        Post post = new Post();
        try {
            post.setAuthor(URLDecoder.decode(req.getParameter("user"), "utf-8"));
            post.setTitle(URLDecoder.decode(req.getParameter("title"), "utf-8"));
            post.setContent(URLDecoder.decode(req.getParameter("content"), "utf-8"));
            post.setPostDate(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
            post.setPostID(posts.size());
        } catch (UnsupportedEncodingException e){
            LOGGER.error("UnsupportedEncodingException");
        }
        LOGGER.info("Create a new post with " + post.getPostID() + " ID!");
        return post;
    }
}

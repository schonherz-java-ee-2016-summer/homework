package hu.schonherz.training.servlets;

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
import java.util.Scanner;

import static hu.schonherz.training.utils.RequestUtils.readRequest;

/**
 * Created by Attila on 2016.07.18..
 */
public class BlogPostServlet extends HttpServlet{

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServlet.class);
    private PostsList posts;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        if (context.getAttribute("posts") == null) {
            context.setAttribute("posts", new PostsList());
        }
        posts = (PostsList) context.getAttribute("posts");
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        context.setAttribute("postsList", posts.getPostsList());
        resp.sendRedirect(req.getContextPath() + "/index");;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        if (context.getAttribute("posts") == null) {
            context.setAttribute("posts", new PostsList());
        }
        posts = (PostsList) context.getAttribute("posts");
        posts.getPostsList().add(createPost(req));
        context.setAttribute("postsList", posts.getPostsList());
        resp.sendRedirect(req.getContextPath() + "/index");
    }

    public Post createPost(final HttpServletRequest req){
        Properties properties = readRequest(req);
        Post post = new Post();
        post.setAuthor(properties.getProperty("user", ""));
        post.setTitle(properties.getProperty("title", ""));
        post.setContent(properties.getProperty("content", ""));
        post.setPostDate(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
        post.setPostID(posts.getPostsList().size());
        return post;
    }
}

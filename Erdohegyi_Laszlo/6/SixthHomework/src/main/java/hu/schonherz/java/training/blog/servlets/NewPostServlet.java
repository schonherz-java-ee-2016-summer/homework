package hu.schonherz.java.training.blog.servlets;

import hu.schonherz.java.training.blog.pojo.BlogPost;
import org.apache.commons.lang3.StringEscapeUtils;

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
 * Created by lac on 2016.07.20..
 */
public class NewPostServlet extends HttpServlet {
    private static final String POSTS = "posts";
    private static final String POST_ID = "postId";

    private static int postId;
    private static List<BlogPost> posts = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();

        postId = posts.size() + 1;

        String author = URLDecoder.decode(req.getParameter("author"), "UTF-8");
        String title = URLDecoder.decode(req.getParameter("title"), "UTF-8");
        String content = URLDecoder.decode(req.getParameter("content"), "UTF-8");

        author = StringEscapeUtils.escapeHtml4(author);
        title = StringEscapeUtils.escapeHtml4(title);
        content = StringEscapeUtils.escapeHtml4(content);

        posts.add(new BlogPost(postId, author, LocalDateTime.now(), title, content));

        context.setAttribute(POST_ID, postId);
        context.setAttribute(POSTS, posts);

        resp.sendRedirect(req.getContextPath() + "/showpost-servlet");
    }
}

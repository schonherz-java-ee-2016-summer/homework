package hu.schonherz.java.training.blog.servlets;

import hu.schonherz.java.training.blog.pojo.BlogComment;
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
 * Created by lac on 2016.07.24..
 */
public class ShowPostServlet extends HttpServlet{
    private static final String POSTS = "posts";
    private static final String POST_ID = "postId";

    private static int postId;
    private static int commentId = 0;
    private static List<BlogPost> posts = new ArrayList<>();
    private static List<BlogComment> coms = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        posts = (List<BlogPost>) context.getAttribute(POSTS);
        postId = (int) context.getAttribute(POST_ID);

        BlogPost actPost = posts.get(postId - 1);

        req.getServletContext().setAttribute("actual_post", actPost);
        resp.sendRedirect(req.getContextPath() + "/showpost/" + postId);
    }

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

        actPost.setComments(coms);

        context.setAttribute(POSTS, posts);

        resp.sendRedirect(req.getContextPath() + "/showpost/" + postId);
    }
}

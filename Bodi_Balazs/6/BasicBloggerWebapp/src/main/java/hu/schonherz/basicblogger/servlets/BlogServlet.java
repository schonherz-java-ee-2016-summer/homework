package hu.schonherz.basicblogger.servlets;

import hu.schonherz.basicblogger.pojo.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static hu.schonherz.basicblogger.properties.Constans.*;

/**
 * Created by bmbal on 2016. 07. 21..
 */
public class BlogServlet extends HttpServlet {


    private static final Logger LOG = LoggerFactory.getLogger(IndexServlet.class);

    private static List<Blog> blogList = new LinkedList<>();
    private static int blogId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/post/new.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession userSession = req.getSession();

        blogList = ((List<Blog>) context.getAttribute(BLOGLIST) != null
                ? (List<Blog>) context.getAttribute(BLOGLIST)
                : new ArrayList<>());

        String author = (String) userSession.getAttribute(NAME);
        String title = (req.getParameter(COMMENT_TITLE) != null ? (req.getParameter(COMMENT_TITLE)) : ("Untitled"));
        String content = (req.getParameter(COMMENT_CONTENT) != null ? (req.getParameter(COMMENT_CONTENT)) : ("Undefined"));

        blogId = blogList.size();
        blogList.add(new Blog(blogId, author, LocalDateTime.now(), title, content));

        userSession.setAttribute(BLOG_ID, blogId);

        context.setAttribute("blogList", blogList);
        resp.sendRedirect("/post/" + blogId);
    }
}

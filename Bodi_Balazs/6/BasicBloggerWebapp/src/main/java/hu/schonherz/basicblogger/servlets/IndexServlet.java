package hu.schonherz.basicblogger.servlets;


import hu.schonherz.basicblogger.data.blog.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 19..
 *
 */

public class IndexServlet extends HttpServlet{

    private static final Logger LOG = LoggerFactory.getLogger(IndexServlet.class);

    private static final String BLOGLIST_SESSION = "blogList";
    private static final String BLOG_ID_SESSION = "blogId";

    private static List<Blog> blogList = new LinkedList<>();

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/index.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        context.setAttribute(BLOGLIST_SESSION, blogList);
        context.setAttribute(BLOG_ID_SESSION, blogList.size()-1);
        resp.sendRedirect("/post/new");
    }
}

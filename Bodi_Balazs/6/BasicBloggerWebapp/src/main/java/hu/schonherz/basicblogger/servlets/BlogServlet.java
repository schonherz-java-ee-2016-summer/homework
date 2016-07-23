package hu.schonherz.basicblogger.servlets;

import hu.schonherz.basicblogger.data.blog.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 21..
 */
public class BlogServlet extends HttpServlet {


    private static final Logger LOG = LoggerFactory.getLogger(IndexServlet.class);

    private static final String COMMENTER_ID = "id";
    private static final String COMMENT_TITLE = "title";
    private static final String COMMENT_CONTENT = "content";

    private static List<Blog> blogList = new LinkedList<>();
    private static int blogId;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);



        session.setAttribute("blogList", blogList);

        resp.sendRedirect("/post/4");
    }
}

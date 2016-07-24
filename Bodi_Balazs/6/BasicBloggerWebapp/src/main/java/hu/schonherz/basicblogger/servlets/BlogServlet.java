package hu.schonherz.basicblogger.servlets;

import hu.schonherz.basicblogger.data.blog.Blog;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 21..
 */
public class BlogServlet extends HttpServlet {


    private static final Logger LOG = LoggerFactory.getLogger(IndexServlet.class);

    private static final String COMMENTER_INPUT_NAME = "userName";
    private static final String COMMENTER_ID = "id";
    private static final String COMMENT_TITLE = "title";
    private static final String COMMENT_CONTENT = "content";

    private static final String BLOGLIST_SESSION = "blogList";
    private static final String BLOG_ID_SESSION = "blogId";

    private static List<Blog> blogList = new LinkedList<>();
    private static int blogId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        blogList = (List<Blog>) session.getAttribute(BLOGLIST_SESSION);
        blogId = blogList.size();
        session.setAttribute(BLOG_ID_SESSION, blogId);
        resp.sendRedirect("/post/new.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        blogList = (List<Blog>) session.getAttribute(BLOGLIST_SESSION);

        String userName = (req.getParameter(COMMENTER_INPUT_NAME) != null ? req.getParameter(COMMENTER_INPUT_NAME) : "Anonymous");
        String title = (req.getParameter(COMMENT_TITLE) != null ? (req.getParameter(COMMENT_TITLE)) : ("Untitled"));
        String content = (req.getParameter(COMMENT_CONTENT) != null ? (req.getParameter(COMMENT_CONTENT)) : ("Undefined"));

        blogId = blogList.size() + 1;

        userName = URLDecoder.decode(userName,  "utf-8");
        userName = StringEscapeUtils.escapeHtml4(userName);
        title = URLDecoder.decode(title,  "utf-8");
        title = StringEscapeUtils.escapeHtml4(title);
        content = URLDecoder.decode(content,  "utf-8");
        content = StringEscapeUtils.escapeHtml4(content);

        blogList.add(new Blog(blogId, userName, new SimpleDateFormat(), title, content));

        session.setAttribute(BLOG_ID_SESSION, blogId);
        session.setAttribute("blogList", blogList);
        resp.sendRedirect("/post/" + blogId);
    }
}

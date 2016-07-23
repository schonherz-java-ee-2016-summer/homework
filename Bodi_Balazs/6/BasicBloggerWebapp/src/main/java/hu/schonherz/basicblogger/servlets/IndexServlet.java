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
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 19..
 *
 */

public class IndexServlet extends HttpServlet{

    private static final Logger LOG = LoggerFactory.getLogger(IndexServlet.class);

    private static final String COMMENTER_INPUT_NAME = "name";

    private static List<Blog> blogList = new LinkedList<>();
    private static int blogId;

    static {
        blogList.add(new Blog(1,"józsi",new SimpleDateFormat(),"title1","content1"));
        blogList.add(new Blog(2,"józsi",new SimpleDateFormat(),"title2","content2"));
        blogId=3;
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        PrintWriter out = resp.getWriter();
        session.setAttribute("blogList", blogList);

        blogList = (List<Blog>) session.getAttribute("blogList");
/*
        blogs = (BlogsBean) session.getAttribute("blogsList");
        if (!blogs.getBlog().isEmpty()) {
            for (Blog actual : blogs.getBlog()) {
                out.append("<div style='padding: 10px;margin-bottom: 20px;border: solid 1px;'>");
                out.append("<strong>").append(actual.getAuthor()).append("</strong>").append("<br>");
                out.append("<span>").append(actual.getContent()).append("</span>");
                out.append("</div>");
            }
        } else {
            out.append("<div>There is no comment yet</div>");
        }
*/
//        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        resp.sendRedirect("/index.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        PrintWriter out = resp.getWriter();
        String userName = (req.getParameter(COMMENTER_INPUT_NAME) != null ? req.getParameter(COMMENTER_INPUT_NAME) : "Anonymous");

        userName = URLDecoder.decode(userName,  "utf-8");
        userName = StringEscapeUtils.escapeHtml4(userName);
        session.setAttribute("userName", userName);

        resp.sendRedirect("/post/new");
    }
}

package hu.schonherz.basicblogger.servlets;

import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * Created by bmbal on 2016. 07. 23..
 */
public class LoginServlet extends HttpServlet {

    private static final String COMMENTER_INPUT_NAME = "userName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        PrintWriter out = resp.getWriter();
        String userName = (req.getParameter(COMMENTER_INPUT_NAME) != null ? req.getParameter(COMMENTER_INPUT_NAME) : "Anonymous");
        userName = URLDecoder.decode(userName,  "utf-8");
        userName = StringEscapeUtils.escapeHtml4(userName);
        session.setAttribute(COMMENTER_INPUT_NAME, userName);
        resp.sendRedirect("/index");
    }
}

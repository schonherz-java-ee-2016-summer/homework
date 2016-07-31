package hu.schonherz.basicblogger.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static hu.schonherz.basicblogger.properties.Constans.BLOG_ID;
import static hu.schonherz.basicblogger.properties.Constans.NAME;

/**
 * Created by bmbal on 2016. 07. 29..
 */
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession userSession = req.getSession();
        String userName = (String) userSession.getAttribute(NAME);
        userSession.setAttribute(BLOG_ID, 0);
        userSession.setAttribute(NAME, req.getParameter(NAME));
        resp.sendRedirect("/index");
    }
}

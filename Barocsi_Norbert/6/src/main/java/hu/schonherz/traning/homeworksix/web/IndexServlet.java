package hu.schonherz.traning.homeworksix.web;

import hu.schonherz.traning.homeworksix.pojo.BlogPost;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Mindfield on 2016. 07. 22..
 */
public class IndexServlet extends HttpServlet{
    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(Boolean.TRUE);
        session.setAttribute("postList", NewPost.postList);

        resp.sendRedirect(req.getContextPath() + "/index");
    }

}

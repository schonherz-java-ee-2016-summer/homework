package hu.schonherz.training.bloggyak.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import hu.schonherz.training.bloggyak.data.pojo.PostBean;
import hu.schonherz.training.bloggyak.utils.Parameters;

/**
 * Created by Lenovo on 2016.07.31..
 */

public class PostServlet extends HttpServlet {

    private PostBean posts;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setCharacterEncoding(Parameters.ENCODING);
        ServletContext context = req.getServletContext();
        int id = Integer.parseInt(req.getParameter("p"));
        if (context.getAttribute(Parameters.INDEX_KEY) == null) {
            context.setAttribute(Parameters.INDEX_KEY, new PostBean());
        }
        posts = (PostBean) context.getAttribute(Parameters.INDEX_KEY);
        context.setAttribute(Parameters.SELECTED_POST, posts.getPosts().get(id - 1));
        resp.sendRedirect(req.getContextPath() + "/post/" + id);
    }
}

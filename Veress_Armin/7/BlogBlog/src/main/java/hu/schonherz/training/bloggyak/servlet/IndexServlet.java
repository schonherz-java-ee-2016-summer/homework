package hu.schonherz.training.bloggyak.servlet;

import hu.schonherz.training.bloggyak.data.pojo.PostBean;
import hu.schonherz.training.bloggyak.data.pojo.Post;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import hu.schonherz.training.bloggyak.utils.Parameters;

/**
 * Created by Lenovo on 2016.07.31..
 */

public class IndexServlet extends HttpServlet {

    private PostBean posts;

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setCharacterEncoding(Parameters.ENCODING);

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding(Parameters.ENCODING);
        res.setCharacterEncoding(Parameters.ENCODING);
        ServletContext context = req.getServletContext();
        if (context.getAttribute(Parameters.INDEX_KEY) == null) {
            context.setAttribute(Parameters.INDEX_KEY, new PostBean());
        }
        posts = (PostBean) context.getAttribute(Parameters.INDEX_KEY);
        Post post = new Post();
        post.setAuthor(req.getParameter(Parameters.POST_AUTHOR));
        post.setTitle(req.getParameter(Parameters.POST_TITLE));
        post.setContent(req.getParameter(Parameters.POST_CONTENT));
        posts.addPost(post);

        context.setAttribute(Parameters.INDEX_KEY, this.posts);
        res.sendRedirect(req.getContextPath() + "/index");
    }
}

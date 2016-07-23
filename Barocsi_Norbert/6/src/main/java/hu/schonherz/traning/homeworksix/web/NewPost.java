package hu.schonherz.traning.homeworksix.web;

import hu.schonherz.traning.homeworksix.pojo.BlogPost;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mindfield on 2016. 07. 21..
 */
public class NewPost extends HttpServlet {

    protected static List<BlogPost> postList = new ArrayList<>();

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(Boolean.TRUE);
        BlogPost post = new BlogPost();
        LocalDateTime ldt = LocalDateTime.now();

        post.setIdentity(Integer.parseInt(req.getParameter("identity")));
        post.setAuthor(req.getParameter("author"));
        post.setDate(ldt);
        post.setTitle(req.getParameter("title"));
        post.setContent(req.getParameter("content"));

        postList.add(post);

        session.setAttribute("poster", post);

        resp.sendRedirect(req.getContextPath() + "/post/" + post.getIdentity());
    }
}

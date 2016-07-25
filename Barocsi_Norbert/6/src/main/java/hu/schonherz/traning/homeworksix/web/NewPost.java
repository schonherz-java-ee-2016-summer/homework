package hu.schonherz.traning.homeworksix.web;

import hu.schonherz.traning.homeworksix.pojo.BlogPost;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


import static hu.schonherz.traning.homeworksix.pojo.PostList.getPostsList;


/**
 * Created by Mindfield on 2016. 07. 21..
 */
public class NewPost extends HttpServlet {

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        BlogPost post = new BlogPost();

        post.setIdentity(getPostsList().size() + 1);
        post.setAuthor(req.getParameter("author"));
        post.setDate(LocalDateTime.now());
        post.setTitle(req.getParameter("title"));
        post.setContent(req.getParameter("content"));


        getPostsList().add(post);

        context.setAttribute("blogList", getPostsList());

        resp.sendRedirect(req.getContextPath() + "/post/" + post.getIdentity());
    }

}

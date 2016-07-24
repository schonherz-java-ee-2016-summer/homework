package hu.schonherz.traning.homeworksix.web;

import hu.schonherz.traning.homeworksix.pojo.BlogComment;
import hu.schonherz.traning.homeworksix.pojo.BlogPost;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


import static hu.schonherz.traning.homeworksix.pojo.PostList.getPostsList;

/**
 * Created by Mindfield on 2016. 07. 24..
 */
public class CommentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() +"/index");
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        BlogComment comment = new BlogComment();
        BlogPost currentPost = getPostsList().get(Integer.parseInt(req.getParameter("identity")) - 1);
        List<BlogComment> commentList = currentPost.getComments();

        comment.setIdentity(commentList.size() + 1);
        comment.setDate(LocalDateTime.now());
        comment.setContent(req.getParameter("comment"));

        currentPost.setComments(commentList);
        currentPost.getComments().add(comment);

        resp.sendRedirect(req.getContextPath() + "/post/" + currentPost.getIdentity());
    }
}

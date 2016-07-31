package hu.schonherz.training.bloggyak.servlet;

import hu.schonherz.training.bloggyak.data.dao.CommentDAO;
import hu.schonherz.training.bloggyak.data.pojo.Comment;
import hu.schonherz.training.bloggyak.data.pojo.Post;
import hu.schonherz.training.bloggyak.data.pojo.CommentBean;
import hu.schonherz.training.bloggyak.utils.Parameters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by Lenovo on 2016.07.31..
 */

@WebServlet(name = "CommentServlet", urlPatterns = "/comment-servlet")
public class CommentServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding(Parameters.ENCODING);
        resp.setCharacterEncoding(Parameters.ENCODING);

        String commenter = URLDecoder.decode(req.getParameter(Parameters.COMMENTER_NAME), Parameters.ENCODING);
        String comment = URLDecoder.decode(req.getParameter(Parameters.COMMENT_NAME), Parameters.ENCODING);

        Comment newComment = new Comment();
        newComment.setAuthor(commenter);
        newComment.setContent(comment);
        Post selectedPost = (Post) req.getServletContext().getAttribute(Parameters.SELECTED_POST);

        CommentBean comments = selectedPost.getComments();
        comments.addComment(newComment);

        resp.sendRedirect("/post?id=" + selectedPost.getId());

    }
}

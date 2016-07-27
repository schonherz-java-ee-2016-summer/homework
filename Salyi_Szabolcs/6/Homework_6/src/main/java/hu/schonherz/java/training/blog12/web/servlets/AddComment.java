package hu.schonherz.java.training.blog12.web.servlets;

import hu.schonherz.java.training.blog12.data.comment.Comment;
import hu.schonherz.java.training.blog12.data.post.Post;
import hu.schonherz.java.training.blog12.web.utils.RequestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import static hu.schonherz.java.training.blog12.data.post.PostBean.getPosts;

/**
 * Created by Home on 2016. 07. 25..
 */
@WebServlet(name = "addcomment", urlPatterns = "/addcomment")
public class AddComment extends HttpServlet {

    private Comment comment;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> formData = RequestUtils.parseFromBody(req);

        Post post = getPosts().get(Integer.parseInt(req.getParameter("id"))-1);
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        String content = formData.get("content");

        comment.setContent(content);
        comment.setDate(LocalDateTime.now());

        post.getComments().add(comment);

        resp.sendRedirect(req.getContextPath()+ "/post/" + post.getId());
    }
}

package hu.schonerz.training.servlets;

import hu.schonerz.training.pojo.Blog;
import hu.schonerz.training.beans.BlogBean;
import hu.schonerz.training.pojo.Comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BlogBean c = (BlogBean) (req.getServletContext().getAttribute("blogb"));
        String postID = req.getParameter("id");


        // System.out.println(commentedBlog.getAuthor());
        //  System.out.println(postID);
        Comment comment = new Comment(req.getParameter("CONTENT"));
        //  System.out.println(comment.getContent());
        // System.out.println(commentedBlog.getId()+commentedBlog.getAuthor());


        Blog commentedBlog = c.findBlog(Integer.parseInt(postID));

        commentedBlog
                .getComments()
                .add(comment); // nullpointer<<<<<????

        req.getServletContext().setAttribute("comment", commentedBlog.getComments());

        resp.sendRedirect("/post?id=" + commentedBlog.getId());
    }


}

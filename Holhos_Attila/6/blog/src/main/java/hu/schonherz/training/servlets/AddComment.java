package hu.schonherz.training.servlets;

import hu.schonherz.training.models.Comment;
import hu.schonherz.training.models.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static hu.schonherz.training.models.PostsList.getPostsList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Attila on 2016.07.21..
 */
public class AddComment extends HttpServlet{

    private static Logger LOGGER = LoggerFactory.getLogger(APost.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Integer postID = ((Integer) context.getAttribute("postID"));
        BufferedReader br = req.getReader();
        Comment comment = new Comment();
        Scanner sc = new Scanner(br);
        sc.useDelimiter("=|&");
        sc.next();
        comment.setContent(URLDecoder.decode(sc.next(), "utf-8"));
        comment.setCommentDate(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
        comment.setCommentID(postID);
        for (Post post : getPostsList()){
            if (post.getPostID() == postID){
                post.getComments().add(comment);
                context.setAttribute("commentsList", post.getComments());
            }
        }
        resp.sendRedirect("/blog/aPost/" + postID + "?ID=" + postID);
    }

}

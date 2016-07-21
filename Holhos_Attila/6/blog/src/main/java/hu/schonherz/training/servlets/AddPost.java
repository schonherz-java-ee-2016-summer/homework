package hu.schonherz.training.servlets;

import hu.schonherz.training.models.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static hu.schonherz.training.models.PostsList.getPostsList;

/**
 * Created by Attila on 2016.07.18..
 */
public class AddPost extends HttpServlet {

    private static Logger LOGGER = LoggerFactory.getLogger(AddPost.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        Scanner sc = new Scanner(br);
        getPostsList().add(readPost(sc));
        ServletContext context = getServletContext();
        context.setAttribute("postsList", getPostsList());
        resp.sendRedirect("/blog/Index");
    }

    public static Post readPost(Scanner sc){
        Post post = new Post();
        try {
            sc.useDelimiter("=|&");
            sc.next();
            post.setAuthor(URLDecoder.decode(sc.next(), "utf-8"));
            sc.next();
            post.setTitle(URLDecoder.decode(sc.next(), "utf-8"));
            sc.next();
            post.setContent(URLDecoder.decode(sc.next(), "utf-8"));
        } catch (UnsupportedEncodingException e){
            LOGGER.error("UnsupportedEncodingException!");
        }
        post.setPostDate(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
        post.setPostID(getPostsList().size());
        return post;
    }

}

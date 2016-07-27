package hu.schonherz.java.training.blog12.web.servlets;

import hu.schonherz.java.training.blog12.data.post.Post;
import hu.schonherz.java.training.blog12.web.utils.RequestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import static hu.schonherz.java.training.blog12.data.post.PostBean.getPosts;

/**
 * Created by Home on 2016. 07. 19..
 */

//@WebServlet(name = "index" , urlPatterns = "/index")
public class Index extends HttpServlet {


    private static final String KEY_AUTHOR = "author";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map < String, String > formData = RequestUtils.parseFromBody(req);

        String author = formData.get(KEY_AUTHOR);
        String title = formData.get(KEY_TITLE);
        String content = formData.get(KEY_CONTENT);


        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        //int id = getPosts().size()+1;
        Post newPost = new Post.PostBuilder(getPosts().size()+1, author,title).content(content).date(LocalDateTime.now()).build();

        getPosts().add(newPost);
        req.getServletContext().setAttribute("posts",getPosts());
        resp.sendRedirect(req.getContextPath() + "/post/" + newPost.getId());


    }
}

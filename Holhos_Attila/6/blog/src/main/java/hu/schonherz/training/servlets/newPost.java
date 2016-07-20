package hu.schonherz.training.servlets;

import hu.schonherz.training.models.Blogpost;

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

import static hu.schonherz.training.servlets.indexBlog.getPostsList;

/**
 * Created by Attila on 2016.07.18..
 */
public class newPost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user,pw;
        BufferedReader br = req.getReader();
        Blogpost blogpost = new Blogpost();
        try (Scanner sc = new Scanner(br)) {
            sc.useDelimiter("=|&");
            sc.next();
            blogpost.setAuthor(URLDecoder.decode(sc.next(),"utf-8"));
            sc.next();
            blogpost.setTitle(URLDecoder.decode(sc.next(),"utf-8"));
            sc.next();
            blogpost.setContent(URLDecoder.decode(sc.next(),"utf-8"));
            /*user = URLDecoder.decode(user,"utf-8");
            user= StringEscapeUtils.escapeHtml4(user);
            pw = URLDecoder.decode(pw,"utf-8");*/
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        blogpost.setPostDate(dateFormat.format(new Date()));
        blogpost.setID(getPostsList().size());
        getPostsList().add(blogpost);
    }

}

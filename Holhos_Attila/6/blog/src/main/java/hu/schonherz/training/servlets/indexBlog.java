package hu.schonherz.training.servlets;

import hu.schonherz.training.models.Blogpost;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Attila on 2016.07.18..
 */
public class indexBlog extends HttpServlet{

    private static List<Blogpost> postsList = new ArrayList<Blogpost>();
    private static SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

    static{
            postsList.add(new Blogpost(1, "Attila", "2016-05-20", "NFL", "What a match was it!"));
            postsList.add(new Blogpost(2, "Béla", "2016-05-12", "NFL", "What a match was it!"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("postsList",postsList);

        req.getRequestDispatcher("/index").forward(req,resp);
    }

    public static List<Blogpost> getPostsList() {
        return postsList;
    }
}

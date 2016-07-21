package hu.schonherz.training.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static hu.schonherz.training.models.PostsList.getPostsList;

/**
 * Created by Attila on 2016.07.18..
 */
public class Index extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        context.setAttribute("postsList", getPostsList());
        req.getRequestDispatcher("/indexBlog").forward(req, resp);
    }

}

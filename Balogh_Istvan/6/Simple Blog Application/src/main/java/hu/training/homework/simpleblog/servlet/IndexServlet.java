package hu.training.homework.simpleblog.servlet;

import hu.training.homework.simpleblog.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "index-servlet", urlPatterns = "/index-servlet")
public class IndexServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexServlet.class);

    private List<Post> posts = new ArrayList<Post>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("posts", posts);
        //resp.sendRedirect(req.getContextPath() + "/index");
    }
}

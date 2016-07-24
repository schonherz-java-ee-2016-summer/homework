package hu.training.homework.simpleblog.servlet;

import hu.training.homework.simpleblog.model.Post;
import hu.training.homework.simpleblog.util.Parameters;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowPostServlet", urlPatterns = "/showPost")
public class ShowPostServlet extends HttpServlet {

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selectedPostID = req.getParameter("id");

        List<Post> posts = (ArrayList)req.getServletContext().getAttribute(Parameters.POSTS_ATTRIBUTE_NAME);

        Post selectedPost = posts.stream()
                                    .filter(p -> p.getId().equals(selectedPostID))
                                    .findFirst()
                                    .get();

        req.getServletContext().setAttribute("selectedPost", selectedPost);

        resp.sendRedirect("/post?id=" + selectedPostID);
    }
}

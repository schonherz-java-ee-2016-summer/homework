package hu.schonherz.training.bloggyak.presentation;

import hu.schonherz.training.bloggyak.data.dao.PostDAO;
import hu.schonherz.training.bloggyak.data.entities.PostEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lenovo on 2016.08.05..
 */
@WebServlet(name = "newPostServlet", urlPatterns = "/post", loadOnStartup = 1)
public class NewPostServlet extends HttpServlet {

    private PostDAO postDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext applicationContext =
                (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");
        postDAO = (PostDAO) applicationContext.getBean("postDAOImpl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostEntity post = new PostEntity();
        post.setAuthor(req.getParameter("author"));
        post.setTitle(req.getParameter("title"));
        post.setContent(req.getParameter("content"));
        postDAO.save(post);
        resp.sendRedirect("/");
    }
}

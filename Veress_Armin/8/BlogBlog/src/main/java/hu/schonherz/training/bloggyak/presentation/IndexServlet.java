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
import java.util.List;

/**
 * Created by Lenovo on 2016.08.03..
 */
@WebServlet(name = "postsServlet", urlPatterns = "/", loadOnStartup = 1)
public class IndexServlet extends HttpServlet {

    private PostDAO postDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext applicationContext =
                (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");
        postDAO = (PostDAO) applicationContext.getBean("postDAOImpl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PostEntity> postList = postDAO.findAll();
        req.setAttribute("posts", postList);
        req.getRequestDispatcher("/index").forward(req, resp);
    }
}

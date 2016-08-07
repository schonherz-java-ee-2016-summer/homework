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
@WebServlet(name = "postServlet", urlPatterns = "/post/*")
public class PostServlet extends HttpServlet {

    PostDAO postDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext applicationContext =
                (ClassPathXmlApplicationContext) getServletContext().getAttribute("applicationContext");
        postDAO = (PostDAO) applicationContext.getBean("postDAOImpl");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer url = req.getRequestURL();
        String urlSub = url.substring(url.lastIndexOf("/")+1);
        PostEntity post = postDAO.findById(Integer.parseInt(urlSub));
        req.setAttribute("post", post);
        req.getRequestDispatcher("/post/show").forward(req, resp);
    }
}

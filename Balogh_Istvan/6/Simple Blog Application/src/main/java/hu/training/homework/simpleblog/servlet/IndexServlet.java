package hu.training.homework.simpleblog.servlet;

import hu.training.homework.simpleblog.dao.PostDAO;
import hu.training.homework.simpleblog.model.Post;
import hu.training.homework.simpleblog.util.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * This servlet creates and stores new {@link Post} objects of the added new blogposts.
 * The list of posts is accessible in a session-scope attribute.
 */
@WebServlet(name = "index-servlet", urlPatterns = "/index-servlet")
public class IndexServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexServlet.class);

    private List<Post> posts = new ArrayList<Post>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding(Parameters.ENCODING);
        resp.setCharacterEncoding(Parameters.ENCODING);

        String author = URLDecoder.decode(req.getParameter(Parameters.AUTHOR_INPUT_NAME), Parameters.ENCODING);
        String title = URLDecoder.decode(req.getParameter(Parameters.POST_TITLE_NAME), Parameters.ENCODING);
        String content = URLDecoder.decode(req.getParameter(Parameters.POST_CONTENT_NAME), Parameters.ENCODING);

        Post newPost = new Post(author, content);
        newPost.setTitle(title);
        posts.add(newPost);
        LOGGER.debug("Added new post: {}.", newPost);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        PostDAO dao = applicationContext.getBean("JDBCTemplatePostDAOImpl", PostDAO.class);
        dao.addPost(newPost);

        req.getServletContext().setAttribute(Parameters.POSTS_ATTRIBUTE_NAME, posts);
        LOGGER.debug("Added new context attribute: {}.", Parameters.POSTS_ATTRIBUTE_NAME);
        req.getServletContext().setAttribute(Parameters.SELECTED_POST_ATTRIBUTE_NAME, newPost);
        LOGGER.debug("Added new context attribute: {}.", Parameters.SELECTED_POST_ATTRIBUTE_NAME);

        resp.sendRedirect("/post?id=" + newPost.getId());
        LOGGER.debug("Redirecting to /post?id={}", newPost.getId());
    }
}

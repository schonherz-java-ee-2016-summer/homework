package hu.schonherz.basicblogger.servlets;

import hu.schonherz.basicblogger.pojo.Blog;
import hu.schonherz.basicblogger.pojo.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static hu.schonherz.basicblogger.properties.Constans.*;

/**
 * Created by bmbal on 2016. 07. 23..
 */
    public class CommentServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(IndexServlet.class);

    private static List<Blog> blogList = new ArrayList<>();
    private static List<Comment> commentList = new ArrayList<>();
    private static int blogId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession userSession = req.getSession();
        blogId = (int) (req.getAttribute(BLOG_ID) != null ? req.getAttribute(BLOG_ID) : userSession.getAttribute(BLOG_ID));

        blogList = (List<Blog>) context.getAttribute(BLOGLIST);
        commentList = (List<Comment>)context.getAttribute(COMMENTLIST);

        Blog requiredBlog = blogList.get(blogId);
        List<Comment> requiredComments = new ArrayList<>();
        if(commentList!=null){
            for (Comment actualComment:commentList
                 ) {
                if(actualComment.getId() == blogId){
                    requiredComments.add(actualComment);
                }
            }
        }
        context.setAttribute("requiredComments", requiredComments);
        context.setAttribute("requiredBlog", requiredBlog);
        resp.sendRedirect("/post.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession userSession = req.getSession();
        String author = (String) userSession.getAttribute(NAME);

        blogList = (List<Blog>) context.getAttribute(BLOGLIST);
        commentList = (List<Comment>) context.getAttribute(COMMENTLIST);
        blogId = (int) (userSession.getAttribute(BLOG_ID) != null
                ? userSession.getAttribute(BLOG_ID)
                : context.getAttribute(BLOG_ID));

        String content = req.getParameter(COMMENT_CONTENT);
        if(commentList == null) {
            commentList = new LinkedList<>();
        }
        commentList.add(new Comment(blogId, author, LocalDateTime.now(), content));

        Blog requiredBlog = blogList.get(blogId);
        List<Comment> requiredComments = new LinkedList<>();
        if(commentList!=null){
            for (Comment actualComment:commentList
                    ) {
                if(actualComment.getId() == blogId){
                    requiredComments.add(actualComment);
                }
            }
        }

        context.setAttribute(COMMENTLIST, commentList);

        context.setAttribute("requiredComments", requiredComments);
        context.setAttribute("requiredBlog", requiredBlog);

        resp.sendRedirect("/post.jsp");
    }
}

package hu.schonherz.basicblogger.servlets;

import hu.schonherz.basicblogger.data.blog.Blog;
import hu.schonherz.basicblogger.data.comment.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 23..
 */
    public class CommentServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(IndexServlet.class);

    private static final String COMMENTER_INPUT_NAME = "userName";
    private static final String COMMENT_CONTENT = "content";

    private static final String BLOGLIST_SESSION = "blogList";
    private static final String BLOG_ID_SESSION = "blogId";
    private static final String COMMENTLIST_SESSION = "commentList";

    private static final String ID = "id";

    private static List<Blog> blogList = new LinkedList<>();
    private static List<Comment> commentList = new LinkedList<>();
    private static int blogId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        blogList = (List<Blog>) session.getAttribute(BLOGLIST_SESSION);
        commentList = (List<Comment>) session.getAttribute(COMMENTLIST_SESSION);
        String userName = (String) session.getAttribute(COMMENTER_INPUT_NAME);
        /*blogId = Integer.parseInt(req.getParameter(ID));
        Blog requiredBlog = blogList.get(blogId);
        List<Comment> requiredComments = new LinkedList<>();
        for (Comment actualComment:commentList
             ) {
            if(actualComment.getId() == blogId){
                requiredComments.add(actualComment);
            }
        }
        session.setAttribute("requiredBlog", requiredBlog);
        session.setAttribute("requiredComments", requiredComments);
        */
        resp.sendRedirect("/post/*");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        blogList = (List<Blog>) session.getAttribute(BLOGLIST_SESSION);
        commentList = (List<Comment>) session.getAttribute(COMMENTLIST_SESSION);
        String userName = (String) session.getAttribute(COMMENTER_INPUT_NAME);
        blogId = Integer.parseInt(req.getParameter(ID));

/**
 * Put comments on the session
 */
        String content = req.getParameter(COMMENT_CONTENT);
        commentList.add(new Comment(blogId, userName, new SimpleDateFormat(),content));
        session.setAttribute(COMMENTLIST_SESSION, commentList);
/**
 * Take the required Blog
 */
        Blog requiredBlog = blogList.get(blogId);
        List<Comment> requiredComments = new LinkedList<>();
/**
 * Take the required Comments
  */
        for (Comment actualComment:commentList
                ) {
            if(actualComment.getId() == blogId){
                requiredComments.add(actualComment);
            }
        }

        session.setAttribute("requiredBlog", requiredBlog);
        session.setAttribute("requiredComments", requiredComments);
        resp.sendRedirect("/post/*");
    }
}

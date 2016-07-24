package hu.schonherz.basicblogger.servlets;

import hu.schonherz.basicblogger.data.blog.Blog;
import hu.schonherz.basicblogger.data.comment.Comment;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
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

        String userName = (req.getParameter(COMMENTER_INPUT_NAME) != null ? req.getParameter(COMMENTER_INPUT_NAME) : "Anonymous");
        blogId = (int) session.getAttribute(BLOG_ID_SESSION);
        blogId--;
        userName = URLDecoder.decode(userName,  "utf-8");
        userName = StringEscapeUtils.escapeHtml4(userName);

        Blog requiredBlog = blogList.get(blogId);
        List<Comment> requiredComments = new LinkedList<>();
        if(commentList!=null){
        for (Comment actualComment:commentList
             ) {
            if(actualComment.getId() == blogId){
                requiredComments.add(actualComment);
            }
        }
        session.setAttribute("requiredComments", requiredComments);
        }

        session.setAttribute("requiredBlog", requiredBlog);

        resp.sendRedirect("/post.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        blogList = (List<Blog>) session.getAttribute(BLOGLIST_SESSION);
        commentList = (List<Comment>) session.getAttribute(COMMENTLIST_SESSION);

        String userName = (req.getParameter(COMMENTER_INPUT_NAME) != null ? req.getParameter(COMMENTER_INPUT_NAME) : "Anonymous");
        blogId = Integer.parseInt(req.getParameter(ID));
        blogId--;
        userName = URLDecoder.decode(userName,  "utf-8");
        userName = StringEscapeUtils.escapeHtml4(userName);
        String content = req.getParameter(COMMENT_CONTENT);
        if(commentList == null) {
            commentList = new LinkedList<>();
        }
        commentList.add(new Comment(blogId, userName, LocalDateTime.now(), content));

        Blog requiredBlog = blogList.get(blogId);
        List<Comment> requiredComments = new LinkedList<>();
        if(commentList!=null){
            for (Comment actualComment:commentList
                    ) {
                if(actualComment.getId() == blogId){
                    requiredComments.add(actualComment);
                }
            }
            session.setAttribute("requiredComments", requiredComments);
        }


        session.setAttribute(COMMENTLIST_SESSION, commentList);
        session.setAttribute("requiredBlog", requiredBlog);

        resp.sendRedirect("/post.jsp");
    }
}

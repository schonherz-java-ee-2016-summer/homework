package hu.nutty.kepzes.blogapp.utils;

import hu.nutty.kepzes.blogapp.beans.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Properties;

import static hu.nutty.kepzes.blogapp.utils.Constants.*;

/**
 * Created by Nutty on 2016.07.21..
 */
public class ParserUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ParserUtils.class);

    private ParserUtils() {
    }

    /**
     * Returns with an instance of {@code CommentsBean}, stored in the Session.
     *
     * @param req the request which is part of the Session.
     * @return an instance of {@code CommentsBean}.
     */

   /* public static Object getListFromSessionByKey(final HttpServletRequest req, String key) {
        HttpSession session = req.getSession(true);

        if (session.getAttribute(key) == null) {
            if (COMMENTS_SESSION_KEY.equals(key)) {
                session.setAttribute(key, new CommentsBean());
            }
            if (POST_SESSION_KEY.equals(key)) {
                session.setAttribute(key, new BlogPostsBean());
            }
        }
        return session.getAttribute(key);
    }*/

    /**
     * Returns with an instance of {@code Object}, stored in the ServletContext.
     *
     * @param req the request which is part of the Context.
     * @return an instance of {@code Object}.
     */
    public static Object getListFromContextByKey(final HttpServletRequest req, String key) {
        ServletContext context = req.getServletContext();

        if (context.getAttribute(key) == null) {
            if (COMMENTS_SESSION_KEY.equals(key)) {
                context.setAttribute(key, new CommentsBean());
            }
            if (INDEX_SESSION_KEY.equals(key)) {
                context.setAttribute(key, new BlogPostsBean());
            }
        }
        return context.getAttribute(key);
    }

    public static Comment parseBodyAsComment(final HttpServletRequest req) {
        Properties formProperties = RequestUtils.parseFormBody(req);
        Comment commentFromBody = new Comment();

        commentFromBody.setCommenter(formProperties.getProperty(COMMENTER_INPUT_NAME, "Anonymous"));
        commentFromBody.setContent(formProperties.getProperty(NEW_COMMENT_INPUT_NAME, ""));

        LOG.debug("Got new comment: {}.", commentFromBody);

        return commentFromBody;
    }

    public static BlogPost parseBodyAsPost(final HttpServletRequest req) {
        Properties formProperties = RequestUtils.parseFormBody(req);
        BlogPost postFromBody = new BlogPost();
        Blogger author = new Blogger();
        author.setFirstName(formProperties.getProperty(POSTER_INPUT_FIRST_NAME));
        author.setLastName(formProperties.getProperty(POSTER_INPUT_LAST_NAME));
        int age;
        try {
            age = Integer.parseInt(formProperties.getProperty(POSTER_INPUT_AGE));
        } catch (NumberFormatException e) {
            age = 0;
            LOG.error("Invalid age, age has been set to 0.", e);
        }
        author.setAge(age);

        author.setNickName(formProperties.getProperty(POSTER_INPUT_NICKNAME));

        postFromBody.setAuthor(author);
        postFromBody.setMessage(formProperties.getProperty(NEW_POST_INPUT_NAME));
        postFromBody.setTitle(formProperties.getProperty(POST_TITLE));

        LOG.debug("Got new post: {}.", postFromBody);

        return postFromBody;
    }
}

package hu.nutty.kepzes.blogapp.utils;

import hu.nutty.kepzes.blogapp.beans.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import static hu.nutty.kepzes.blogapp.utils.Constants.*;

/**
 * This is a utility class for parsing the incoming data as we want.
 */
public class ParserUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ParserUtils.class);

    private ParserUtils() {
    }

    /**
     * Returns with an instance of {@code Object}, stored in the ServletContext.
     *
     * @param req the request which is part of the Context.
     * @param key the name of the List we want to get from the Context.
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

    /**
     * Returns with an instance of {@code Comment}. We are parsing the incoming data as a comment.
     *
     * @param req the request.
     * @return an instance of {@code Comment}.
     */
    public static Comment parseBodyAsComment(final HttpServletRequest req) {
        Comment commentFromBody = new Comment();

        commentFromBody.setCommenter(req.getParameter(COMMENTER_INPUT_NAME));
        commentFromBody.setContent(req.getParameter(NEW_COMMENT_INPUT_NAME));

        LOG.debug("Got new comment: {}.", commentFromBody);

        return commentFromBody;
    }

    /**
     * Returns with an instance of {@code BlogPost}. We are parsing the incoming data as a blog post.
     *
     * @param req the request.
     * @return an instance of {@code Comment}.
     */
    public static BlogPost parseBodyAsPost(final HttpServletRequest req) {
        BlogPost postFromBody = new BlogPost();
        Blogger author = new Blogger();

        author.setFirstName(req.getParameter(POSTER_INPUT_FIRST_NAME));
        author.setLastName(req.getParameter(POSTER_INPUT_LAST_NAME));
        int age;
        try {
            age = Integer.parseInt(req.getParameter(POSTER_INPUT_AGE));
        } catch (NumberFormatException e) {
            age = 0;
            LOG.error("Invalid age, age has been set to 0.", e);
        }
        author.setAge(age);
        author.setNickName(req.getParameter(POSTER_INPUT_NICKNAME));
        postFromBody.setAuthor(author);
        postFromBody.setMessage(req.getParameter(NEW_POST_INPUT_NAME));
        postFromBody.setTitle(req.getParameter(POST_TITLE));

        LOG.debug("Got new post: {}.", postFromBody);

        return postFromBody;
    }
}

package hu.nutty.kepzes.blogapp.utils;

import hu.nutty.kepzes.blogapp.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * Returns with an instance of {@code CommentEntity}. We are parsing the incoming data as a comment.
     *
     * @param req the request.
     * @return an instance of {@code CommentEntity}.
     */
    public static CommentDTO parseBodyAsComment(final HttpServletRequest req) {
        CommentDTO commentFromBody = new CommentDTO();

        commentFromBody.setCommenter(req.getParameter(COMMENTER_INPUT_NAME));
        commentFromBody.setContent(req.getParameter(NEW_COMMENT_INPUT_NAME));

        LOG.debug("Got new comment: {}.", commentFromBody);

        return commentFromBody;
    }

    /**
     * Returns with an instance of {@code BlogPostEntity}. We are parsing the incoming data as a blog post.
     *
     * @param req the request.
     * @return an instance of {@code CommentEntity}.
     */
    public static BloggerDTO parseBodyAsBlogger(final HttpServletRequest req) {
        BloggerDTO author = new BloggerDTO();

        author.setFirstName(req.getParameter(POSTER_INPUT_FIRST_NAME));
        author.setLastName(req.getParameter(POSTER_INPUT_LAST_NAME));
        author.setNickName(req.getParameter(POSTER_INPUT_NICKNAME));

        int age;
        try {
            age = Integer.parseInt(req.getParameter(POSTER_INPUT_AGE));
        } catch (NumberFormatException e) {
            age = 0;
            LOG.error("Invalid age, age has been set to 0.", e);
        }
        author.setAge(age);
        LOG.debug("Got new blogger: {}.", author);
        return author;
    }

    public static BlogPostDTO parseBodyAsPost(final HttpServletRequest req) {
        BlogPostDTO postFromBody = new BlogPostDTO();

        postFromBody.setMessage(req.getParameter(NEW_POST_INPUT_NAME));
        postFromBody.setTitle(req.getParameter(POST_TITLE));

        LOG.debug("Got new post: {}.", postFromBody);

        return postFromBody;
    }
}

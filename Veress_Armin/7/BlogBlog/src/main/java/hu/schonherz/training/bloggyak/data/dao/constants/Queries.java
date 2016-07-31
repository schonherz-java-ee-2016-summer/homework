package hu.schonherz.training.bloggyak.data.dao.constants;

/**
 * Created by Lenovo on 2016.07.29..
 */
public final class Queries {

    public static final String INSERT_POST = "INSERT INTO post (author, title, content, date)" +
            "VALUES (?, ?, ?, ?)";

    public static final String SELECT_ALL_POSTS = "SELECT * FROM post";

    public static final String SELECT_POST = "SELECT * FROM post WHERE id = ?";

    public static  final String INSERT_COMMENT = "INSERT INTO comment (postId, author, content, date)" +
            "VALUES (?, ?, ?, ?)";

    public static final String SELECT_COMMENTS_OF_POST = "SELECT * FROM comment WHERE postId = ?";

    private Queries() {
    }
}

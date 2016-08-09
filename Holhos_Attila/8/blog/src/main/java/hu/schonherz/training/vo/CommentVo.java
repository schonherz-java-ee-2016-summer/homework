package hu.schonherz.training.vo;

/**
 * Created by Attila on 2016.08.06..
 */
public class CommentVo {

    private Long id;

    private Long postid;

    private String commentDate;

    private String content;

    public CommentVo(Long id, Long postid, String commentDate, String content) {
        this.id = id;
        this.postid = postid;
        this.commentDate = commentDate;
        this.content = content;
    }

    public CommentVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

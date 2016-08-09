package hu.schonherz.training.vo;

import hu.schonherz.training.vo.CommentVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Attila on 2016.08.06..
 */
public class PostVo {

    private Long id;

    private String author;

    private String postDate;

    private String title;

    private String content;

    private List<CommentVo> commentVos = new ArrayList<CommentVo>();

    public PostVo() {
    }

    public PostVo(Long id, String author, String postDate, String title, String content) {
        this.id = id;
        this.author = author;
        this.postDate = postDate;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentVo> getCommentVos() {
        return commentVos;
    }

    public void setCommentVos(List<CommentVo> commentVos) {
        this.commentVos = commentVos;
    }
}

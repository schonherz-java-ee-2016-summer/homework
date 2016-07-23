package hu.schonherz.basicblogger.data.comment;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 19..
 * This Bean encapsulating a number of comments
 */
public class CommentsBean implements Serializable{
    private List<Comment> commnentsList = new LinkedList<>();

    public void setCommnents(List<Comment> commnentsList) {
        this.commnentsList = commnentsList;
    }

    public List<Comment> getCommnents() {
        return commnentsList;
    }

}

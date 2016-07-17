package pojo;

import java.text.SimpleDateFormat;

/**
 * Created by bmbal on 2016. 07. 17..
 */
public class Comment {
    /**
     * Komment: id, kommentelés dátuma, tartalom.
     */
    public int id;
    public SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
    public String content;

    public Comment(int id, SimpleDateFormat date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }
}

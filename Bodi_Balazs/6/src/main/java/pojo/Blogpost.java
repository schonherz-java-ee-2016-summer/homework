package pojo;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 17..
 */
public class Blogpost {
     /**
      * Show information about a blogspot.
      * //id,author,date,content,corresponding comments
      *
      *
      *
      * Blogposzt: id, szerző, posztolás dátuma, cím, tartalom, hozzá tartozó kommentek.
      *
     * SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
     * Date date = new Date();
     * logWriter = new BufferedWriter(new FileWriter(dateFormat.format(date) + " serverLog.log", true));
      *
      */
    public Integer id;
    public String author;
    public SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy HH-mm-ss");;;
    public String label;
    public String content;
    public List<Comment> correspondingComments;

    public Blogpost(Integer id, String author, SimpleDateFormat date, String label, String content, List<Comment> correspondingComments) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.label = label;
        this.content = content;
        this.correspondingComments = correspondingComments;
    }
}

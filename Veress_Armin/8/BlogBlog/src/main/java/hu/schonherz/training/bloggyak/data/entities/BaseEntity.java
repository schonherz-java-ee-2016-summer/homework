package hu.schonherz.training.bloggyak.data.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Lenovo on 2016.08.05..
 */
public class BaseEntity {

    @Id
    @GeneratedValue
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

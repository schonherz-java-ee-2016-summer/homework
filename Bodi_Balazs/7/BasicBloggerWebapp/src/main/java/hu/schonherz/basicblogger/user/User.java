package hu.schonherz.basicblogger.user;

import org.springframework.context.annotation.Scope;

/**
 * Created by bmbal on 2016. 07. 31..
 */
@Scope("session")
public class User {
    private String name;

    public User() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

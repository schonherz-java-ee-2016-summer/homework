package hu.nutty.kepzes.blogapp.entities;

import java.io.Serializable;

/**
 * This class represents a BloggerEntity.
 */
public class BloggerEntity extends BaseEntity {
    private static final long serialVersionUID = -2815440504971898685L;

    private String firstName;
    private String lastName;
    private String nickName;
    private int age;

    public BloggerEntity() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}

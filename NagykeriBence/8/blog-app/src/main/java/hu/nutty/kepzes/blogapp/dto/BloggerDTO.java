package hu.nutty.kepzes.blogapp.dto;

import hu.nutty.kepzes.blogapp.entities.BloggerEntity;

import java.io.Serializable;

/**
 * This class represents a BloggerEntity.
 */
public class BloggerDTO implements Serializable, DTOConverter {
    private static final long serialVersionUID = -2815440504971898685L;

    private int bloggerID;
    private String firstName;
    private String lastName;
    private String nickName;
    private int age;

    public BloggerDTO() {
    }

    public BloggerDTO(int bloggerID, String firstName, String lastName, String nickName, int age) {
        this.bloggerID = bloggerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nickName = nickName;
    }

    public BloggerEntity toEntity() {
        return new BloggerEntity(new Long(this.bloggerID), this.firstName, this.lastName, this.nickName, this.age);
    }

    public int getBloggerID() {
        return bloggerID;
    }

    public void setBloggerID(int bloggerID) {
        this.bloggerID = bloggerID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BloggerDTO blogger = (BloggerDTO) o;

        if (age != blogger.age) {
            return false;
        }
        if (!firstName.equals(blogger.firstName)) {
            return false;
        }
        if (!lastName.equals(blogger.lastName)) {
            return false;
        }
        return nickName.equals(blogger.nickName);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + nickName.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "BloggerEntity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }
}

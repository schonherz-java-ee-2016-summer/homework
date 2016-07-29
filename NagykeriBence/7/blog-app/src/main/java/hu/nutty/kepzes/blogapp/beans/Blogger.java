package hu.nutty.kepzes.blogapp.beans;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class represents a Blogger.
 */
public class Blogger implements Serializable {
    private static final long serialVersionUID = -2815440504971898685L;

    private int bloggerID;
    private String firstName;
    private String lastName;
    private String nickName;
    private int age;

    public Blogger() {
    }

    public Blogger(int bloggerID, String firstName, String lastName, String nickName, int age) {
        this.bloggerID = bloggerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nickName = nickName;
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

        Blogger blogger = (Blogger) o;

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
        return "Blogger{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }
}

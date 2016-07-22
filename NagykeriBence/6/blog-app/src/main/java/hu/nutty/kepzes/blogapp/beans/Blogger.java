package hu.nutty.kepzes.blogapp.beans;

/**
 * Created by Nutty on 2016.07.18..
 */
public class Blogger {
    private String firstName;
    private String lastName;
    private String nickName;
    private int age;

    public Blogger() {
    }

    public Blogger(String firstName, String lastName, String nickName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nickName = nickName;
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

package hu.nutty.kepzes.blogapp.entities;

import hu.nutty.kepzes.blogapp.dto.BloggerDTO;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This class represents a BloggerEntity.
 */
@Entity
@Table(name = "Bloggers")
public class BloggerEntity extends BaseEntity implements EntityConverter {
    private static final long serialVersionUID = -2815440504971898685L;

    private String firstName;
    private String lastName;
    private String nickName;
    private int age;

    public BloggerEntity() {
    }

    public BloggerEntity(String firstName, String lastName, String nickName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
    }

    @Override
    public BloggerDTO toDTO(){
        return new BloggerDTO(this.getId().intValue(), this.firstName, this.lastName, this.nickName, this.age);
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

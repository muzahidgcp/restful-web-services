package com.smh.rest.webservices.restfulwebservices.helloworld.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 10, max = 100)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    protected Post() {
    }

    public Post(Integer id, String description) {
        id = id;
        this.description = description;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {

    }

    @Override
    public String toString() {
        return "Post{" +
                "Id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

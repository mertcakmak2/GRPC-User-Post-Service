package com.example.postservice.model;


public class PostResponseWithUser {

    private int id;
    private String subject;
    private String content;
    private UserResponse user;

    public PostResponseWithUser(int id, String subject, String content, UserResponse user) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.user = user;
    }

    public PostResponseWithUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}

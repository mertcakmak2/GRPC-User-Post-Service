package com.example.postservice.model;

public class Post {

    private int id;
    private String subject;
    private String content;
    private int userId;

    public Post(int id, String subject, String content, int userId) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.userId = userId;
    }

    public Post() {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

package com.example.postservice.model;

public class UserResponse {

    private int id;
    private String name;

    public UserResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

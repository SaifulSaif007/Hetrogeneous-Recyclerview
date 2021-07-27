package com.saiful.differentlistinrecyclerview.model;

public class NormalPost {

    String Name;
    String post;
    String time;

    public NormalPost(String name, String post, String time) {
        Name = name;
        this.post = post;
        this.time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getPost() {
        return post;
    }

    public String getTime() {
        return time;
    }
}

package com.saiful.differentlistinrecyclerview.model;

public class PostWithImage {

    String Name;
    int image;
    String time;

    public PostWithImage(String name, int image, String time) {
        Name = name;
        this.image = image;
        this.time = time;
    }

    public String getName() {
        return Name;
    }

    public int getImage() {
        return image;
    }

    public String getTime() {
        return time;
    }
}

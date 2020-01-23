package com.example.differentlistinrecyclerview;

public class User {

    String Name;
    String Address;

    public User(String name, String address) {
        Name = name;
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

}

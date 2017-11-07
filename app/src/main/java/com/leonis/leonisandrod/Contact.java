package com.leonis.leonisandrod;

/**
 * Created by Floglor on 07.11.2017.
 */

public class Contact {
    private String name;
    private String phone_number;
    private String picture;

    public Contact(String name) { //for ListView testing
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

package com.leonis.leonisandrod;

import java.util.Comparator;

/**
 * Created by Floglor on 07.11.2017.
 */

public class Contact {
    private String name;
    private String phone_number;
    private String picture;

    public Contact(String name, String phone_number) {
        this.name = name;
        this.phone_number = phone_number;
    }

    static Comparator<Contact> sortByName = new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            String driverName1 = o1.getName().toUpperCase();
            String driverName2 = o2.getName().toUpperCase();

            return driverName1.compareTo(driverName2);
        }
    };

    Contact(String name) { //for ListView testing
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

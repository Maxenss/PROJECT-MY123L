package com.leonis.leonisandrod.ContactPackage;

import java.util.Comparator;

/**
 * Created by Floglor on 07.11.2017.
 */

public abstract class Contact {
    private String firstname;
    private String phone_number;
    private String picture;

    public Contact(String firstname, String phone_number) {
        this.firstname = firstname;
        this.phone_number = phone_number;
    }

    public Contact(String firstname) { //for ListView testing
        this.firstname = firstname;
    }


    public static Comparator<Contact> sortByName = new Comparator<Contact>() {
        @Override
        public int compare(Contact o1, Contact o2) {
            String driverName1 = o1.getFirstname().toUpperCase();
            String driverName2 = o2.getFirstname().toUpperCase();

            return driverName1.compareTo(driverName2);
        }
    };

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

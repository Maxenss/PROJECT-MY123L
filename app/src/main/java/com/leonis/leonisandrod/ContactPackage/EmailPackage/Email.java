package com.leonis.leonisandrod.ContactPackage.EmailPackage;

/**
 * Created by Floglor on 15.11.2017.
 */

public abstract class Email {

    protected static final String EMAIL_WORK_EXTENTION = "work";
    protected static final String EMAIL_PERSONAL_EXTENTION = "personal";
    protected static final String EMAIL_OTHER_EXTENTION = "other";

    private int id;
    private String email;
    private String email_extention;
    private int sort;

    public Email(String email, String email_extention) {
        this.email = email;
        this.email_extention = email_extention;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_extention() {
        return email_extention;
    }

    public void setEmail_extention(String email_extention) {
        this.email_extention = email_extention;
    }
}

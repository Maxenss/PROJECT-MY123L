package com.leonis.leonisandrod.ContactPackage.PhonePackage;

/**
 * Created by Floglor on 15.11.2017.
 */

public abstract class Phone {
    protected static final String PHONE_WORK_EXTENTION = "work";
    protected static final String PHONE_MOBILE_EXTENTION = "mobile";
    protected static final String PHONE_HOME_EXTENTION = "home";
    protected static final String PHONE_OTHER_EXTENTION = "other";

    private int id;
    private int value;
    private String extention;
    private int sort;

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Phone(int value, String extention) {
        this.value = value;
        this.extention = extention;
    }
}

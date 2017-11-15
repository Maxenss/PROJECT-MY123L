package com.leonis.leonisandrod.ContactPackage.URLPackage;

/**
 * Created by Floglor on 15.11.2017.
 */

public abstract class URL {
    protected static final String URL_WORK_EXTENTION = "work";
    protected static final String URL_PERSONAl_EXTENTION = "personal";
    protected static final String URL_OTHER_EXTENTION = "other";

    private int id;
    private String value;
    private String extention;
    private int sort;

    public URL(String value, String extention) {
        this.value = value;
        this.extention = extention;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}

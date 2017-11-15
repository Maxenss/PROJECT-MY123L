package com.leonis.leonisandrod.ContactPackage.IMPackage;

/**
 * Created by Floglor on 15.11.2017.
 */

public abstract class IM {
    protected static final String IM_SKYPE_EXTENTION = "skype";
    protected static final String IM_ICQ_EXTENTION = "icq";
    protected static final String IM_JABBER_EXTENTION = "jabber";
    protected static final String IM_YAHOO_EXTENTION = "yahoo";
    protected static final String IM_AIM_EXTENTION = "aim";
    protected static final String IM_MSN_EXTENTION = "msn";
    protected static final String IM_OTHER_EXTENTION = "other";

    private int id;
    private String value;
    private String extention;
    private int sort;

    public void setSort(int sort) {
        this.sort = sort;
    }

    public IM(String value, String extention) {
        this.value = value;
        this.extention = extention;
    }
}

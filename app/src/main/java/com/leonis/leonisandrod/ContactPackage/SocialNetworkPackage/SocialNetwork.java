package com.leonis.leonisandrod.ContactPackage.SocialNetworkPackage;

/**
 * Created by Floglor on 15.11.2017.
 */

public abstract class SocialNetwork {
    protected static final String SOCIALNETWORK_FACEBOOK_EXTENTION = "facebook";
    protected static final String SOCIALNETWORK_TWITTER_EXTENTION = "twitter";
    protected static final String SOCIALNETWORK_LINKEDIN_EXTENTION = "linkedin";
    protected static final String SOCIALNETWORK_VKONTAKTE_EXTENTION = "vkontakte";
    protected static final String SOCIALNETWORK_OTHER_EXTENTION = "other";

    private int id;
    private String value;
    private String extention;
    private int sort;

    public SocialNetwork(String value, String extention) {
        this.value = value;
        this.extention = extention;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}

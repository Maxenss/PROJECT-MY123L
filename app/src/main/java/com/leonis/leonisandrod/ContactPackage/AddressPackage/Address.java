package com.leonis.leonisandrod.ContactPackage.AddressPackage;

/**
 * Created by Floglor on 15.11.2017.
 */

public abstract class Address {
    protected static final String ADDRESS_HOME_EXTENTION = "home";
    protected static final String ADDRESS_SHIPPING_EXTENTION = "shipping";
    protected static final String ADDRESS_BILLING_EXTENTION = "billing";
    protected static final String ADDRESS_OTHER_EXTENTION = "other";

    private int id;
    private String country;
    private String region;
    private String city;
    private String street;
    private String zip;
    private String extention;
    private int sort;

    public Address(String country, String region, String city, String street, String zip, String extention) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.zip = zip;
        this.extention = extention;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}

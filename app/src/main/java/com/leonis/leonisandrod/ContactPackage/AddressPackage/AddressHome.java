package com.leonis.leonisandrod.ContactPackage.AddressPackage;

/**
 * Created by Floglor on 15.11.2017.
 */

public class AddressHome extends Address {
    public AddressHome(String country, String region, String city, String street, String zip) {
        super(country, region, city, street, zip, ADDRESS_HOME_EXTENTION);
    }
}

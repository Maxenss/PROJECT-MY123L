package com.leonis.leonisandrod.ContactPackage.AddressPackage;

/**
 * Created by Floglor on 15.11.2017.
 */

public class AddressShipping extends Address {
    public AddressShipping(String country, String region, String city, String street, String zip) {
        super(country, region, city, street, zip, ADDRESS_SHIPPING_EXTENTION);
    }
}

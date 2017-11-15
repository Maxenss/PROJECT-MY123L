package com.leonis.leonisandrod.ContactPackage;

import com.leonis.leonisandrod.ContactPackage.AddressPackage.Address;
import com.leonis.leonisandrod.ContactPackage.EmailPackage.Email;
import com.leonis.leonisandrod.ContactPackage.IMPackage.IM;
import com.leonis.leonisandrod.ContactPackage.PhonePackage.Phone;
import com.leonis.leonisandrod.ContactPackage.SocialNetworkPackage.SocialNetwork;
import com.leonis.leonisandrod.ContactPackage.URLPackage.URL;

import java.util.ArrayList;

/**
 * Created by Floglor on 15.11.2017.
 */

public class FullContact extends Contact {

    String firstname;
    String lastname;
    String middlename;
    String company;
    String jobtitle;
    String about;
    private ArrayList<Email> emails;


    public FullContact(String name, String phone_number) {
        super(name, phone_number);
    }

    public FullContact(String name) {
        super(name);
    }
    
    public void setEmailsSortPositions(ArrayList<Email> emails) {
        int i = 0;

        for (Email e :
                emails) {
            e.setSort(i);
            i++;
        }
    }

    public void setPhonesSortPositions(ArrayList<Phone> phones) {
        int i = 0;

        for (Phone p :
                phones) {
            p.setSort(i);
            i++;
        }
    }

    public void setIMSortPositions(ArrayList<IM> ims) {
        int i = 0;

        for (IM im :
                ims) {
            im.setSort(i);
            i++;
        }
    }

    public void setURLSortPositions(ArrayList<URL> urls) {
        int i = 0;

        for (URL url :
                urls) {
            url.setSort(i);
            i++;
        }
    }

    public void setSocialNetworkSortPositions(ArrayList<SocialNetwork> socialNetworks) {
        int i = 0;

        for (SocialNetwork socialNetwork :
                socialNetworks) {
            socialNetwork.setSort(i);
            i++;
        }
    }

    public void setAddressSortPositions(ArrayList<Address> addresses) {
        int i = 0;

        for (Address address :
                addresses) {
            address.setSort(i);
            i++;
        }
    }
}

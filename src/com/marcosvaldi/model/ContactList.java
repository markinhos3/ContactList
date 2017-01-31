package com.marcosvaldi.model;


import java.util.ArrayList;
import java.util.List;

public class ContactList {

    private List<ContactDetails> contactList = new ArrayList<>();

    public List<ContactDetails> getContactList() {
        return contactList;
    }

    public void setContactList(List<ContactDetails> contactList) {
        this.contactList = contactList;
    }


}

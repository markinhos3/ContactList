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


    public ContactDetails getContactDetails(int i) {
        return contactList.get(i);
    }

    public void addDates(ContactDetails contactDetails) {
        contactList.add(contactDetails);

    }

    public void removeDates(int i) {
        contactList.remove(i);
    }
}

package com.marcosvaldi.actions;


import com.marcosvaldi.model.ContactDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddContact {

    public static ContactDetails writeContact(){

        //ask Name
        System.out.printf("\n     ✍ NAME: ");
        Scanner date1 = new Scanner(System.in);
        String name = date1.nextLine();

        System.out.printf("--------------------");

        //ask Phone
        System.out.printf("\n     ☎ PHONE: ");
        Scanner date2 = new Scanner(System.in);
        String phone = date2.nextLine();

        // object from class ContactDetails
        ContactDetails person = new ContactDetails();

        person.setName(name);
        person.setPhone(phone);

        return person;
    }
}

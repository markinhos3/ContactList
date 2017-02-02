package com.marcosvaldi.actions;


import java.util.Scanner;

public class DeleteContact {

    public static int removeContact(){

        System.out.printf("\n✂ Contact number to DELETE: ");
        Scanner rm = new Scanner(System.in);
        String place = rm.nextLine();
        int index = Integer.parseInt(place);

        return index;
    }
}

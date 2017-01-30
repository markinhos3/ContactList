package com.marcosvaldi.views;


import java.util.Scanner;

public class Prompt {

    public static String waitingToRead(){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static void indexContact(int i){

        System.out.println("❥ " + "<" + i + ">: ");
    }

}

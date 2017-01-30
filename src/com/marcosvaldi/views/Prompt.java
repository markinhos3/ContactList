package com.marcosvaldi.views;


import java.util.Scanner;

public class Prompt {

    public static void print(){
        System.out.print("❥ ");

    }

    public static String waitingToRead(){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

}

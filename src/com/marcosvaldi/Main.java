package com.marcosvaldi;

import com.marcosvaldi.generate.GenerateDiary;
import com.marcosvaldi.views.Welcome;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // generate App ContactList
        GenerateDiary.generate();
    }
}

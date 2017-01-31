package com.marcosvaldi.managers;


import com.marcosvaldi.model.ContactDetails;
import com.marcosvaldi.model.ContactList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExportFile {

    private File outFile = new File("ContactList");

    public static void createFile(String file, List<ContactDetails> arrData)
            throws IOException {
        FileWriter writer = new FileWriter(file);
        int size = arrData.size();

        for (int i=0;i<size;i++) {
            String cadena1 = arrData.get(i).getName().toString();
            String cadena2 = arrData.get(i).getPhone().toString();
            writer.write(i + " - NAME: " + cadena1 + "\n");
            writer.write(" | " + i + " - PHONE: " + cadena2 + " __||__ ");

            if(i < size-1) {//This prevent creating a blank like at the end of the file**
                writer.write("\n");
            }
        }
        writer.close();
    }

    public static List<ContactDetails> readFile(File fileName) {
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new
                BufferedReader(fileReader);
        List<ContactDetails> con = new ArrayList<ContactDetails>();
        String line = null;

        try {
            ContactDetails contact = new ContactDetails();
            int i = 0;
            while ((line = bufferedReader.readLine()) != null){
                if (i == 0){
                    contact.setName(line);
                }else {
                    con.add(contact);
                    contact.setPhone(line);
                    contact = new ContactDetails();
                    i = 0;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return con;
    }
}

package com.marcosvaldi.generate;


import com.marcosvaldi.actions.AddContact;
import com.marcosvaldi.actions.DeleteContact;
import com.marcosvaldi.managers.CommandParser;
import com.marcosvaldi.model.Command;
import com.marcosvaldi.model.ContactDetails;
import com.marcosvaldi.model.ContactList;
import com.marcosvaldi.views.Prompt;
import com.marcosvaldi.views.ShowHelp;
import com.marcosvaldi.views.Welcome;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateDiary {
    ContactList contactList = new ContactList();

    public static void generate() throws IOException {


        System.out.printf("\n     ☸ Enter the KEY: ");
        Scanner key = new Scanner(System.in);
        String accessKey = key.nextLine();

        if (accessKey.equals("musho_beti")) {

            // call printWelcomeMessage method
            Welcome.printWelcomeMessage();

            // build contactList object
            ContactList contactList = new ContactList();

            // call method readFile
            try {
                readFilesAndWrite();
            }catch (Exception e){
                System.out.println("");
            }

            boolean end = false;

            while (end != true) {

                // call indexContact method and pass size
                Prompt.indexContact(contactList.getContactList().size());

                // read from prompt something from keyboard
                String command = Prompt.waitingToRead();
                Command com = CommandParser.parse(command);

                switch (com) {

                    case ADD:
                        ContactDetails printAdd = AddContact.writeContact();
                        contactList.addDates(printAdd);
                        System.out.println("\n     ✔ Contact SAVED! ✔\n");
                        break;
                    case DELETE:
                        try {
                            int i = DeleteContact.removeContact();
                            if (i < 0 || i > contactList.getContactList().size() - 1) {
                                System.out.println("\n     ☝ Not possible to do that!");
                            } else {
                                contactList.removeDates(i);
                                System.out.println("\n     ✘ Contact REMOVED! ✘\n");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\n     ☝ Not possible to do that!");
                        }
                        break;
                    case HELP:
                    ShowHelp.printHelp();
                    break;
                    case QUIT:
                        // call method writeFile
                        writeListToFiles(contactList.getContactList());
                        System.out.println("\n     ❤❤❤ Hope to see you soon! ❤❤❤");
                        end = true;
                        break;
                    case LIST:
                    if (contactList.getContactList().size() == 0) {
                        System.out.println("\n     ✍ 1st Add Contact!");
                    } else {
                        for (int i = 0; i < contactList.getContactList().size(); i++) {
                                ContactDetails details = contactList.getContactDetails(i);
                                System.out.println("\n▶ " + i + " → " + details.getName() + " → " + details.getPhone() + "\n");
                            }
                    }
                    break;
                    case UNKNOWN:
                        System.out.println("\n     ✈ Visit the (h)elp if you are in the clouds\n");
                }
            }
        }else {
            System.out.println("Go and read the README.md file");
        }
   }

   // writeToFile
    public static void writeListToFiles(List<ContactDetails> contacts){

        List<String> names = new ArrayList<>();
        List<String> phones = new ArrayList<>();


        for (ContactDetails c : contacts) {
            names.add(c.getName());
            phones.add(c.getPhone());
        }

        try {
            createFile("names.txt", names);
            createFile("phones.txt", phones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //createFile
    public static void createFile(String file, List<String> arrData) throws IOException {
        FileWriter writer = new FileWriter(file);
        int size = arrData.size();
        for (int i=0;i<size;i++) {
            String str = arrData.get(i).toString();
            writer.write(str);
            if(i < size-1) {
                writer.write("\n");
            }
        }
        writer.close();
    }

    // readFromFile
    public static void readFilesAndWrite(){

        List<String> names = readFile("names.txt");
        List<String> phones = readFile("phones.txt");

        List<ContactDetails> contacts = new ArrayList<>();
            for(int i = 0; i < names.size(); ++i) {
                ContactDetails c = new ContactDetails();
                c.setName(names.get(i));
                c.setPhone(phones.get(i));
                contacts.add(c);
            }
    }

    // readFile
    public static List<String>readFile(String fileName) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("      ● The .txt files do not exist yet! ●");
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Empy File!");
        }
        return lines;
    }
}

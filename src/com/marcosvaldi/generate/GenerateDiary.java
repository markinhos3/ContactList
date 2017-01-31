package com.marcosvaldi.generate;


import com.marcosvaldi.actions.AddContact;
import com.marcosvaldi.actions.DeleteContact;
import com.marcosvaldi.managers.CommandParser;
import com.marcosvaldi.managers.ExportFile;
import com.marcosvaldi.model.Command;
import com.marcosvaldi.model.ContactDetails;
import com.marcosvaldi.model.ContactList;
import com.marcosvaldi.views.Prompt;
import com.marcosvaldi.views.ShowHelp;
import com.marcosvaldi.views.Welcome;

import java.io.File;
import java.io.IOException;

public class GenerateDiary {

   public static void generate() throws IOException {
       File file = new File("ContactList");

       // build contactList object
       ContactList contactList = new ContactList();

       // check if the file exists
       if (file.exists()){
           contactList.setContactList(ExportFile.readFile(file));
       }

       boolean end = false;

       // call printWelcomeMessage method
       Welcome.printWelcomeMessage();

       while (end != true){

           // call indexContact method and pass size
           Prompt.indexContact(contactList.getContactList().size());

           // read from prompt something from keyboard
           String command = Prompt.waitingToRead();
           Command com = CommandParser.parse(command);

           switch (com){

               case HELP:
                   ShowHelp.printHelp();
                   break;
               case QUIT:
                   System.out.println("\n     ❤❤❤ Hope to see you soon! ❤❤❤");
                   // write ContactList File
                   file = new File("ContactList");
                   ExportFile.createFile("ContactList.txt", contactList.getContactList());
                   end = true;
                   break;
               case LIST:
                   if (contactList.getContactList().size() == 0){
                       System.out.println("\n     ✍ 1st Add Contact!");
                   }else {
                       for (int i = 0; i < contactList.getContactList().size(); i++) {
                           ContactDetails details = contactList.getContactDetails(i);
                           System.out.println("\n▶ " + i + " → " + details.getName() + " → " + details.getPhone() + "\n");
                       }
                   }
                   break;
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
                   }catch (NumberFormatException e){ // Treat the exception if it is String Format
                       System.out.println("\n     ☝ Not possible to do that!");
                   }
                   break;
               case UNKNOWN:
                   System.out.println("\n     ✈ Visit the (h)elp if you are in the clouds\n");
           }
       }
   }
}

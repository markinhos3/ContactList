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

public class GenerateDiary {

   public static void generate(){

       // build contactList object
      ContactList contactList = new ContactList();
       boolean end = false;

       // call printWelcomeMessage method
       Welcome.printWelcomeMessage();

       while (end != true){

           // call indexContact method and give
           Prompt.indexContact(contactList.getContactList().size());

           // read from prompt something from keyboard
           String command = Prompt.waitingToRead();
           Command com = CommandParser.parse(command);

           switch (com){

               case HELP:
                   ShowHelp.printHelp();
                   break;
               case QUIT:
                   end = true;
                   break;
               case LIST:
                   for (int i = 0; i < contactList.getContactList().size() ; i++) {
                       ContactDetails details = contactList.getContactDetails(i);
                       System.out.println("\n▶ " + i + " → " + details.getName() + " → " + details.getPhone() + "\n");
                   }
                   break;
               case ADD:
                   ContactDetails printAdd = AddContact.writeContact();
                   contactList.addDates(printAdd);
                   System.out.println("\n ✔ Contact SAVED! ✔\n");
                   break;
               case DELETE:
                   int i = DeleteContact.removeContact();
                   contactList.removeDates(i);
                   System.out.println("\n ✘ Contact REMOVED! ✘\n");
                   break;
               case UNKNOWN:
                   System.out.println("✈ Visit the (h)elp if you are in the clouds\n");

           }
       }
   }
}

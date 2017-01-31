package com.marcosvaldi.managers;


import com.marcosvaldi.model.Command;

public class CommandParser {

    public static Command parse(String option) {

        if (option.equalsIgnoreCase("help") || option.equalsIgnoreCase("h")) {
            return Command.HELP;
        }
        if (option.equalsIgnoreCase("quit") || option.equalsIgnoreCase("q")) {
            return Command.QUIT;
        }
        if (option.equalsIgnoreCase("list") || option.equalsIgnoreCase("l")) {
            return Command.LIST;
        }
        if (option.equalsIgnoreCase("add") || option.equalsIgnoreCase("a")) {
            return Command.ADD;
        }
        if (option.equalsIgnoreCase("delete") || option.equalsIgnoreCase("d")) {
            return Command.DELETE;
        }
        return Command.UNKNOWN;
    }
}

package com.fges.todoapp;
import org.apache.commons.cli.*;

public class CommandParser {
    public static CommandLine parseArguments(String[] args) throws ParseException {
        Options cliOptions = new Options();
        cliOptions.addRequiredOption("s", "source", true, "File containing the todos");
        cliOptions.addOption("d","done",false, "Marks task as done");
        cliOptions.addOption("o", "output", true, "Output file");

        CommandLineParser parser = new DefaultParser();
        return parser.parse(cliOptions, args);
    }
}
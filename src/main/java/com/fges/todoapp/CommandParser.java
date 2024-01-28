package com.fges.todoapp;

import org.apache.commons.cli.*;
import java.util.List;

public class CommandParser {
    private final String[] args;
    private CommandLine cmd;

    public CommandParser(String[] args) {
        this.args = args;
    }

    public void parse() throws ParseException {
        Options cliOptions = new Options();
        CommandLineParser parser = new DefaultParser();
        cliOptions.addRequiredOption("s", "source", true, "File containing the todos");
        cmd = parser.parse(cliOptions, args);
    }

    public String getFileName() {
        return cmd.getOptionValue("s");
    }

    public String getCommand() {
        return cmd.getArgList().isEmpty() ? "" : cmd.getArgList().get(0);
    }

    public List<String> getPositionalArgs() {
        return cmd.getArgList();
    }
}

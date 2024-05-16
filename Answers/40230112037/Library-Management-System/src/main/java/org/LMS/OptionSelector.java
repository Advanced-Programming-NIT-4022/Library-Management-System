package org.LMS;

import java.util.ArrayList;
import java.util.Arrays;

public class OptionSelector {
    ArrayList<Option> options = new ArrayList<>();

    void add(String optionName, Func function) {
        options.add(new Option(optionName, function));
    }

    void add(ArrayList<Option> options) {
        this.options.addAll(options);
    }

    void help(){
        System.out.println("Available options:");
        for(Option option : options){
            System.out.print(option.option);
            if(option.help!=null){
                System.out.printf(": %s",option.help);
            }
            System.out.println();
        }
    }

    void select(String[] arguments) {
        if (arguments.length == 0) {
            PrintError.fewArguments();
            return;
        }
        for (Option option : this.options) {
            if (option.option.equals(arguments[0])) {
                option.func(Arrays.copyOfRange(arguments, 1, arguments.length));
                return;
            }
        }
        System.out.printf("Unknown option %s.\n", arguments[0]);
        help();
    }
}

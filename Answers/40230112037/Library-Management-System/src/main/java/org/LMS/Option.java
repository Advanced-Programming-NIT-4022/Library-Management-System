package org.LMS;


@FunctionalInterface
interface Func {
    void func(String[] arguments);
}

public class Option implements Func {
    final public String option;
    final public String help;
    final private Func function;

    Option(String option, Func function) {
        this.function = function;
        this.option = option;
        this.help = null;
    }

    Option(String option, Func function, String help) {
        this.function = function;
        this.option = option;
        this.help = help;
    }

    @Override
    public void func(String[] arguments) {
        if (this.function != null) {
            this.function.func(arguments);
        }
    }
}

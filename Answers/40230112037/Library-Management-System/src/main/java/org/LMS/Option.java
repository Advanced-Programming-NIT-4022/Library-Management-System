package org.LMS;


@FunctionalInterface
interface Func {
    void func(String[] arguments);
}

public class Option implements Func {
    final private Func function;
    final public String option;

    Option(String option, Func function) {
        this.function = function;
        this.option = option;
    }

    @Override
    public void func(String[] arguments) {
        if (this.function != null) {
            this.function.func(arguments);
        }
    }
}

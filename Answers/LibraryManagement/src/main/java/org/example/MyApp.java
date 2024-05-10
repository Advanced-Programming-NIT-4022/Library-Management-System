package org.example;

public class MyApp{

    public static void main(String[] args) {
        Library library = new Library(Library.getname(), Library.getcapacity(), Library.getOperatingHours());
        CLI cli = new CLI(library);
        cli.start();
    }
}
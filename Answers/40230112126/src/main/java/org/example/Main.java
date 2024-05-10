package org.example;


import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library libraryObj = new Library("Vezarat etelalat", "8am-14pm", "8734732");

        Scanner scanner = new Scanner(System.in);
        String[] command = new String[10];

        for ( ; ; ) {
            System.out.println("                               HELLO");
            System.out.println("                      Welcome to vezarate etelat \n");
            System.out.println("please enter command(if you need a guide, please enter *help!*)");

            String input = scanner.nextLine();
            command = input.split(" ");

            if (!command[0].equals("lib")) {
                System.out.println("Wrong input");
                continue;
            }
            else {

                if (command[1].equals("add") && command[2].equals("book"))
                    libraryObj.AddNewBook();

                if (command[1].equals("get") && command[2].equals("hrs"))
                    System.out.println(libraryObj.operatingHours);

                if (command[2].equals("rent"))
                    libraryObj.RentBook(libraryObj.usersId, libraryObj.booksId);

                if (command[1].equals("add") && command[2].equals("member"))
                    libraryObj.AddNewUser(null, null, null);

                if (command[1].equals("get") && command[2].equals("available"))
                    libraryObj.ShowBookList();

                if (command[1].equals("remove") && command[2].equals("member"))
                    libraryObj.RemoveUser(libraryObj.usersId);

                if (command[1].equals("return"))
                    libraryObj.ReturnBook(libraryObj.usersId, libraryObj.booksId);
            }
                System.out.println("Wrong input");
        }
    }
}
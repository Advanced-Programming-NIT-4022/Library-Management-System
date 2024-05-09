package org.example;

import java.util.*;

public class Library {
    public void CLIComment()
    {
        boolean flag = true;
        while (flag) {
            System.out.println("lib add book");
            System.out.println("lib get hrs");
            System.out.println("lib rent book");
            System.out.println("lib add member");
            System.out.println("lib rent");
            System.out.println("lib get available books");
            System.out.println("lib remove member");
            System.out.println("lib return book");
            System.out.println("Enter your comment :");
            Scanner scanner = new Scanner(System.in);
            String comment = scanner.nextLine();
            switch (comment) {
                case "lib add book":

                    break;
                case "lib get hrs":

                    break;
                case "lib rent book":

                    break;
                case "lib add member":

                    break;
                case "lib get available books":

                    break;
                case "lib remove member":

                    break;
                case "lib return book":

                    break;
                case "exit":
                    flag = false;
                    break;
                default:
                    System.out.println("please enter again");
                    break;
            }
        }
    }
}

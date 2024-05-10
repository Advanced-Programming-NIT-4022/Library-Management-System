package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Library {
    User user;
    private final String LibraryName;
    private final String OperatingHours;
    private final String Capacity;
    public Library(){
        user = new User();
        this.LibraryName = "HOMA";
        this.OperatingHours =  "9 a.m. - 9 p.m.";
        this.Capacity = "Infinity";
    }
    public String getCapacity() { return Capacity; }
    public String getOperatingHours() { return OperatingHours; }
    public String getLibraryName() {  return LibraryName; }
    public  void ReadFileUser()
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("User.txt"));
            String line;
            user.getPeople().clear();
            while ((line = bufferedReader.readLine()) != null)
            {
                user.getPeople().add(line);
            }
            bufferedReader.close();
        } catch (IOException r){
            System.out.println("An error occurred.");
        }
        user.setPeople(user.getPeople());
    }
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

                    CLIComment();
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

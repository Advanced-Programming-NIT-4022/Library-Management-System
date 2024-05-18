package myLibrary;


import java.io.IOException;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arian=new ArrayList<>();
        arian.add("Manger");
        arian.add("arian");
        arian.add("40230112011");
        arian.add("09301579868");
        library mylibrary = new library(arian);
        mylibrary.greeting();
//        ArrayList<String> myArray=new ArrayList<>();
//        myArray.add("admin");
//        admin newAdmin=new admin("C:/Users/Dr Techno/Desktop/admin.txt",myArray);
//normal_user myuser=new normal_user();
//        menuPage arian = new menuPage();
//        System.out.println(mylibrary.myUser);
//        gettingUserInput arian=new gettingUserInput("user","Client");
    }
}
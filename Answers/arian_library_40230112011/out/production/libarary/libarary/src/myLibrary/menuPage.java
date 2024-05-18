package myLibrary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menuPage extends library{
   private void showBook() throws IOException {
        File bookFile=new File("C:/Users/Dr Techno/Desktop/book.txt");
        if (bookFile.exists()){
            Scanner scan=new Scanner(bookFile);
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                ArrayList myBook=new ArrayList<>(List.of(line.substring(1,line.length()-1).split(", ")));
                System.out.println(myBook.get(3));
            }
        }
        else {
            System.out.println("No book are available at the moment manger");
        }
        menuPage arian=new menuPage("Manger",givingPersonInfo());
    }
    public menuPage(String membership,ArrayList<String> K) throws IOException {
       super(K);
       setConfig(K);
        switch (membership) {
            case "Manger" -> {
                System.out.println("1:Book repository");
                System.out.println("2:Manger and rental registries");
                System.out.println("3:Books that been borrowed");
                System.out.println("4:show name of admins");
                System.out.println("5:show name of clients");
                System.out.println("6:remove admin");
                System.out.println("7:add admin");
                System.out.println("8:exit");
                String x = order();
                if (x.equals("1")) {
                    showBook();
                } else if (x.equals("2")) {
                    AdminsCommandLine();
                }else if (x.equals("3")) {
                  borrowedBook arian=new borrowedBook(givingPersonInfo());
                }else if (x.equals("4")) {
                    showPersonal("admin","Manger");
                }else if (x.equals("5")) {
                    showPersonal("user","Manger");
                } else if (x.equals("6")) {
                   System.out.println("Enter the number of that baster");
                   String garbageNumber=order();
                   removingPersonal remove=new removingPersonal(garbageNumber,"admin","Manger");
                   remove.setter(givingPersonInfo());
                }  else if (x.equals("7")) {
                    ArrayList Admin=new ArrayList<>();
                    Admin.add("admin");
                    admin myAdmin=new admin("C:/Users/Dr Techno/Desktop/admin.txt",Admin);
                    menuPage arian=new menuPage("Manger",givingPersonInfo());
                } else if (x.equals("8")) {

                } else {
                    System.out.println("I couldn't understand manger please repeat");
                    menuPage arian=new menuPage("Manger",givingPersonInfo());
                }
            }
            case "Admin" -> {
                System.out.println("1:Book repository");
                System.out.println("2:Admin and rental registries");
                System.out.println("3:Books that been borrowed");
                System.out.println("4:show name of clients");
                System.out.println("5:exit");
                String x = order();
                if (x.equals("1")) {
                    showBook();
                } else if (x.equals("2")) {
                    AdminsCommandLine();
                } else if (x.equals("3")){
                    borrowedBook arian=new borrowedBook(givingPersonInfo());
                }else if (x.equals("4")){
               showPersonal("user","Admin");
                } else if (x.equals("5")) {
                    System.out.println("Thanks for visiting us");
                    System.out.println("have a good day");
                }else {
                    System.out.println("Enter the command properly");
                    menuPage Clinet=new menuPage("Client",givingPersonInfo());
                }
            }
            case "Client" -> {
                System.out.println("1:Book repository");
                System.out.println("2:Client and rental registries");
                System.out.println("3:Books that been borrowed");
                System.out.println("4:exit");
                String x = order();
                if (x.equals("1")) {
                    showBook();
                } else if (x.equals("2")) {
                    UserComendline();
                } else if (x.equals("3")) {
                   borrowedBook arian=new borrowedBook(givingPersonInfo());
                } else if (x.equals("4")) {

                } else {
                    System.out.println("Enter the command properly");
                    menuPage Clinet=new menuPage("Client",givingPersonInfo());
                }
            }
        }
    }
}

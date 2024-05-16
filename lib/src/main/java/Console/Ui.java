package Console;

import com.example.lib.*;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;
import java.util.jar.JarException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ui {
    Library lib=new Library();
    final String regex1="\\d{11}";
    final String regex2="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";

    public Ui() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
Ui x=new Ui();
        x.mainPage();
    }
    public  void mainPage() throws SQLException {
        String username="";
        boolean Admin=false;
        String Description="";

        Scanner input=new Scanner(System.in);
        System.out.println("lib add book <title> <author> <description>");
        System.out.println("lib get hrs");
        System.out.println("lib rent <bookName> <author>");
        System.out.println("lib get available books");
        System.out.println("lib remove member <user-name> <phone_number>");
        System.out.println("lib return <bookName> <author>");
        System.out.println("lib remove book <title> <author>\n");
        while(true){
            if(Objects.equals(username,"")){
                System.out.println("enter your command:");
            }
            else{
                System.out.println("<"+username+"> "+"enter your command:");
            }

            String command;
            command=input.nextLine();
            try{
                String split[]=command.split(" ");
                Pattern pattern1=Pattern.compile(regex1);
                Pattern pattern2=Pattern.compile(regex2);
                switch (split[0]+split[1]){
                    case "signup":
                        Matcher match1=pattern1.matcher(split[4]);
                        Matcher match2=pattern2.matcher(split[4]);
                        if(match1.find()){
                            normalUser user=new normalUser(split[2]+" "+split[3],split[4],split[5]);
                            lib.addMember(user.getName(),user.getNumber(),user.getId(),split[5]);
                            break;
                        }
                        else{
                            System.out.println("please enter a valid phone number!");
                            break;
                        }
                    case "signin":
                        if(lib.checkUserexistence(split[2]+" "+split[3],split[4])){
                            username=split[2];
                            System.out.println("Welcome "+split[2]+"!");
                        }
                        else{
                            System.out.println("Wrong password try again");
                        }
                        break;
                    case "addbook":
                        Description="";
                        for(int i=4;i<split.length;i++)
                            Description+=split[i]+" ";
                        Book book=new Book(split[2],split[3],Description);
                        lib.addBook(book);
                        break;
                    case "getavailable":
                        if(Objects.equals(split[2],"books")){
                                lib.getbooks(username);
                        }
                        break;
                    case "removemember":
                           lib.rmUser(split[2], Admin);
                        break;
                    case "rentbook":
                        lib.rentBook(split[2]);
                        break;

                }
                if(Objects.equals(split[0],"return")){
                    lib.returnBook(split[1],username);

                }
            }
            catch (Exception e){
                System.out.println("please enter your command correctly");
            }


        }
    }
}

package myLibrary;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class library {
  private ArrayList<String> person=new ArrayList<>();
    int password=12345;
    String name="Nit library";
    int capacity=2500;
    String operatingHours="8Am to 10Pm";
    String MangerPass="Cause i know the government is always lying to you";
    int number=0;
    int number1=0;
    void setConfig(ArrayList<String> x){
        this.person=x;
    }
    ArrayList<String> givingPersonInfo(){
      return this.person;
    }
    public void showPersonal(String x,String y) throws IOException {
        File myFile=new File("C:/Users/Dr Techno/Desktop/"+x+".txt");
        if (myFile.exists()){
            Scanner scan=new Scanner(myFile);
            while (scan.hasNextLine()){
                String xyz= scan.nextLine();
                ArrayList<String> myArray=new ArrayList<>(List.of(xyz.substring(1, xyz.length() - 1).split(", ")));
                System.out.println(myArray.get(1));
            }
            menuPage newOne=new menuPage(y,givingPersonInfo());
        }else {
            System.out.println("you don't have any "+y);
            menuPage newOne=new menuPage(y,givingPersonInfo());
        }
    }
    public void findAvailbleBook(int G) throws IOException {
        File fileBook=new File("C:/Users/Dr Techno/Desktop/book.txt");
        if (fileBook.exists()){
            Scanner scan=new Scanner(fileBook);
            while (scan.hasNextLine()){
                String x= scan.nextLine();
                ArrayList<String> myArray=new ArrayList<>(List.of(x.substring(1,x.length()-1).split(", ")));
                if (myArray.get(5).equals("true")){
                    System.out.println("the name of book: "+myArray.get(3));
                    System.out.println("the author"+myArray.get(1));
                   while (true){
                    System.out.println("1:Choose from books that are available");
                    System.out.println("2:back");
                    String answer=order();
                       if (answer.equals("1")) {
                           System.out.println("Please enter the name of the book");
                           String Title=order();
                           System.out.println("Please enter the name of the author");
                           String Author=order();
                          rent arian=new rent(Author,Title,givingPersonInfo());
                           break;
                       }
                       else if (answer.equals("2")) {
                           if (G==1){
                               AdminsCommandLine();
                           } else if (G==2) {
                               UserComendline();
                           }
                           break;

                       }else
                       {
                           System.out.println("I didn't understand what did you say?");
                       }
                   }
                }
            }
        }else{
            System.out.println("No books are available at the moment");
        }
    }
    protected void accessLvl() throws IOException {
        System.out.println("membership page\n \n");
        System.out.println("which membership do you have?");
        System.out.println("1:Manger");
        System.out.println("2:Admin");
        System.out.println("3:Client");
        System.out.println("4:Back");
       String x=order();
       if (x.equals("1")){
           System.out.println("Why do you think you are the manger?");
           for ( number1=number1;number1<5;number1++){
               String Pass=order();
               if (Objects.equals(Pass, MangerPass)){
                   number1=0;
                   System.out.println("welcome back manger \n \n");
                   menuPage arian=new menuPage("Manger",givingPersonInfo());
                   return;
               } else {
                   System.out.println("wrong pass");
                   System.out.println("1:member ship page");
                   System.out.println("2:Retry putting password");
                   String xy=order();
                   if (xy.equals("1")){
                       accessLvl();
                   }
                   else {
                       System.out.println("Why do you think you are the manger again?");
                   }
               }
           }
        System.out.println("Too many tries please try again in 5 minutes");
       } else if (x.equals("2")) {
           gettingUserInput arian=new gettingUserInput("admin","Admin");
            return;
       } else if (x.equals("3")) {
           gettingUserInput arian=new gettingUserInput("user","Client");
           return;
       } else if (x.equals("4")) {
           validation();
           return;
       }
        {System.out.println("unknown command");}
    }
    void UserComendline() throws IOException {
        System.out.println("lib add book <name> <author> <subtitle>: Add book to library.");
        System.out.println("lib get hrs: Retrieve library operating hours.");
        System.out.println("lib rent <bookName> <author>: Rent a book from the library.");
        System.out.println("lib rent <bookName> <memberName> <memberID>: Rent a book for a specific member.");
        System.out.println("lib get available books: View available books for rental.");
        System.out.println("lib return <bookName> <author>: Return a rented book to the library.");
        System.out.println("back:back to member ship page");
        String x=order();
        try {
            String y=x.substring(0,24);
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Please type the order you want like it supposed to \n Thank you for you cooperation \n");
            UserComendline();
        }
        String y=x.substring(0,3);
        if (y.equals("lib")){
            for (int i=0;i<x.length();i++){
                if (x.charAt(i)=='#'||x.charAt(i)=='*'||x.charAt(i)=='%'||x.charAt(i)=='@'){
                    System.out.println("Unknown command");
                    UserComendline();
                    return;
                }
            }
            if (x.startsWith("add book", 4)){
               book book1=new book(x,2);
            } else if (x.startsWith("get hrs", 4)) {
                showTime();
            } else if (x.startsWith("rent", 4)) {
                String xyz2="";
                ArrayList<String> xyz=new ArrayList<>();
                for (int i=0;i<x.length();i++){
                    if (x.charAt(i)=='<'){
                        xyz2="";
                        for (int z=i+1;z<x.length();z++){
                            xyz2=xyz2 + x.charAt(z);
                            if (x.charAt(z)=='>'){
                                xyz.add(xyz2.substring(0,xyz2.length()-1));
                                break;
                            }
                        }
                    }
                }
                rent arian=new rent(xyz.get(1),xyz.get(0), givingPersonInfo());
            } else if ((x.startsWith("rent", 4))&&(x.length()>11)) {
                String xyz2="";
                ArrayList<String> xyz=new ArrayList<>();
                for (int i=0;i<x.length();i++){
                    if (x.charAt(i)=='<'){
                        xyz2="";
                        for (int z=i+1;z<x.length();z++){
                            xyz2=xyz2 + x.charAt(z);
                            if (x.charAt(z)=='>'){
                                xyz.add(xyz2.substring(0,xyz2.length()-1));
                                break;
                            }
                        }
                    }
                }
                File myFile=new File("C:/Users/Dr Techno/Desktop/user.txt");
                File myFile2=new File("C:/Users/Dr Techno/Desktop/admin.txt");
                Scanner scan=new Scanner(myFile);
                Scanner scan2=new Scanner(myFile2);
                while (scan.hasNextLine()){
                    String validate=scan.nextLine();
                    ArrayList myArray=new ArrayList<>(List.of(validate.substring(1,validate.length()-1).split(", ")));
                    if (xyz.get(1).equals(myArray.get(1))&&xyz.get(0).equals(myArray.get(2))){
                        rent arian=new rent(xyz.get(3),xyz.get(2), myArray);
                        System.out.println("here's your book have a great day");
                        UserComendline();
                        return;
                    }
                }
                while (scan2.hasNextLine()){
                    String validate=scan2.nextLine();
                    ArrayList myArray=new ArrayList<>(List.of(validate.substring(1,validate.length()-1).split(", ")));
                    if (xyz.get(1).equals(myArray.get(1))&&xyz.get(0).equals(myArray.get(2))){
                        rent arian=new rent(xyz.get(3),xyz.get(2), myArray);
                        System.out.println("here's your book have a great day");
                        UserComendline();
                        return;
                    }
                }
            } else if (x.startsWith("get available", 4)) {
                findAvailbleBook(1);

            }  else if (x.startsWith("return", 4)) {
                String xyz2="";
                ArrayList<String> xyz=new ArrayList<>();
                for (int i=0;i<x.length();i++){
                    if (x.charAt(i)=='<'){
                        xyz2="";
                        for (int z=i+1;z<x.length();z++){
                            xyz2=xyz2 + x.charAt(z);
                            if (x.charAt(z)=='>'){
                                xyz.add(xyz2.substring(0,xyz2.length()-1));
                                break;
                            }
                        }
                    }
                }
                ReturnBook arian=new ReturnBook(xyz.get(0),xyz.get(1),givingPersonInfo());
                UserComendline();
            } else if (x.startsWith("back",4)) {
                accessLvl();
            }
        }else {
            System.out.println("unknown command!!");
            AdminsCommandLine();
        }
    }

    public library() throws IOException {
    }
protected void greeting() throws IOException {
    System.out.println("Hello welcome to "+name+" we have over "+capacity+" books"+"\n"+
            "our shift starts from "+operatingHours+"\n"+"how can i be at service sir?");
    validation();
}
protected String order(){
    Scanner scan = new Scanner(System.in);
    return scan.nextLine();
}
protected void AdminsCommandLine() throws IOException {
    System.out.println("lib add book <name> <author> <subtitle>: Add book to library.");
    System.out.println("lib get hrs: Retrieve library operating hours.");
    System.out.println("lib rent <bookName> <author>: Rent a book from the library.");
    System.out.println("lib add member <studentID> <password>: Add a new member to the library.");
    System.out.println("lib rent <memberID> <memberName> <bookName> <author>: Rent a book for a specific member.");
    System.out.println("lib get available books: View available books for rental.");
    System.out.println("lib return <bookName>: Return a rented book to the library.");
    System.out.println("back:back to member ship page");
String x=order();
    try {
        String y=x.substring(0,24);
    }catch (StringIndexOutOfBoundsException e){
        System.out.println("Please act like a professional \n don't fool yor self");
        UserComendline();
    }
String y=x.substring(0,3);
    if (y.equals("lib")){
       if (x.startsWith("add book", 4)){
          book book2=new book(x,1);
       } else if (x.startsWith("get hrs", 4)) {
           showTime();
       } else if (x.startsWith("rent", 4)) {
           String xyz2="";
           ArrayList<String> xyz=new ArrayList<>();
           for (int i=0;i<x.length();i++){
               if (x.charAt(i)=='<'){
                   xyz2="";
                   for (int z=i+1;z<x.length();z++){
                       xyz2=xyz2 + x.charAt(z);
                       if (x.charAt(z)=='>'){
                           xyz.add(xyz2.substring(0,xyz2.length()-1));
                           break;
                       }
                   }
               }
           }
           rent arian=new rent(xyz.get(1),xyz.get(0), givingPersonInfo());
       } else if (x.startsWith("add member", 4)) {

       } else if ((x.startsWith("rent", 4))&&(x.length()>11)) {
           String xyz2="";
           ArrayList<String> xyz=new ArrayList<>();
           for (int i=0;i<x.length();i++){
               if (x.charAt(i)=='<'){
                   xyz2="";
                   for (int z=i+1;z<x.length();z++){
                       xyz2=xyz2 + x.charAt(z);
                       if (x.charAt(z)=='>'){
                           xyz.add(xyz2.substring(0,xyz2.length()-1));
                           break;
                       }
                   }
               }
           }
           File myFile=new File("C:/Users/Dr Techno/Desktop/user.txt");
           File myFile2=new File("C:/Users/Dr Techno/Desktop/admin.txt");
           Scanner scan=new Scanner(myFile);
           Scanner scan2=new Scanner(myFile2);
           while (scan.hasNextLine()){
             String validate=scan.nextLine();
             ArrayList myArray=new ArrayList<>(List.of(validate.substring(1,validate.length()-1).split(", ")));
               if (xyz.get(1).equals(myArray.get(1))&&xyz.get(0).equals(myArray.get(2))){
                   rent arian=new rent(xyz.get(3),xyz.get(2), myArray);
                   System.out.println("here's your book have a great day");
                   AdminsCommandLine();
                   return;
               }
           }
           while (scan2.hasNextLine()){
               String validate=scan2.nextLine();
               ArrayList myArray=new ArrayList<>(List.of(validate.substring(1,validate.length()-1).split(", ")));
               if (xyz.get(1).equals(myArray.get(1))&&xyz.get(0).equals(myArray.get(2))){
                   rent arian=new rent(xyz.get(3),xyz.get(2), myArray);
                   System.out.println("here's your book have a great day");
                   AdminsCommandLine();
                   return;
               }
           }

       } else if (x.startsWith("get available", 4)) {
           findAvailbleBook(1);

       } else if (x.startsWith("return", 4)) {
           String xyz2="";
           ArrayList<String> xyz=new ArrayList<>();
           for (int i=0;i<x.length();i++){
               if (x.charAt(i)=='<'){
                   xyz2="";
                   for (int z=i+1;z<x.length();z++){
                       xyz2=xyz2 + x.charAt(z);
                       if (x.charAt(z)=='>'){
                           xyz.add(xyz2.substring(0,xyz2.length()-1));
                           break;
                       }
                   }
               }
           }
           ReturnBook arian=new ReturnBook(xyz.get(0),xyz.get(1),givingPersonInfo());
           AdminsCommandLine();
       } else if (x.startsWith("back",4)) {
           accessLvl();
       }
    }else {
        System.out.println("unknown command!!");
        AdminsCommandLine();
    }
}
public void showTime() throws IOException {
    System.out.println(operatingHours);
    System.out.println("1:back");
    System.out.println("2:exit");
  String x=order();
  if (x.equals("1")){
      AdminsCommandLine();
  } else if (x.equals("2")) {
      System.out.println("thanks for visiting us have a good day");
      return;
  }else {
      System.out.println("i didn't understand please choose from choices below");
      showTime();
  }
}
 void validation() throws IOException {
    System.out.println("are you a member of our community");
    System.out.println("1:Yes i am");
    System.out.println("2:No im not");
    String x=order();
    if (x.equals("1"))
    {
        accessLvl();
    }
    else if (x.equals("2")) {
          System.out.println("1:register");
          System.out.println("2:exit");
          String y=order();
          if (y.equals("1")){
              System.out.print("please put your admins code: ");
              String z=order();
              if (z.equals(String.valueOf(password))){
                  ArrayList<String> myUser = new ArrayList<>();
                  myUser.add("user");
                  normal_user newOne1 = new normal_user("C:/Users/Dr Techno/Desktop/user.txt",myUser);
                  validation();
              }else {
                  number++;
                  if (number==5){
                      System.out.println("wrong password");
                      System.out.println("Too many tries please try again in 5 minutes");
                      return;
                  }
                      for (int i=number;i<5;i++) {
                          System.out.println("wrong password");
                          System.out.println("1:retry putting password");
                          System.out.println("2:back");
                          String guess = order();
                          if (guess.equals("1")) {
                              System.out.print("please put your admins code: ");
                              int xyz=Integer.parseInt(order());
                              if (xyz==password){
                                  ArrayList myUser=new ArrayList<>();
                                  myUser.add("user");
                                  normal_user newOne = new normal_user("C:/Users/Dr Techno/Desktop/admin.txt",myUser);
                                  setConfig(newOne.givingData());
                                  validation();
                                  return;
                              }
                          } else if (guess.equals("2")) {
                              validation();
                              return;
                          }
                      }
                  System.out.println("wrong password");
                  System.out.println("Too many tries please try again in 5 minutes");
              }
          }
       }else {
        System.out.println("I didn't understand could please repeat");
        validation();
    }
    }
 }

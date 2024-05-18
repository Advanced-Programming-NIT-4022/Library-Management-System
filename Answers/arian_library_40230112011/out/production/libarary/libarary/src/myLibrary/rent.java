package myLibrary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class rent extends library {
    int F=0;
    ArrayList<String> person=new ArrayList<>();
    void setter(ArrayList<String> x){
        this.person=x;
    }
    ArrayList<String> getter(){
        return this.person;
    }
    public rent(String Author, String Title, ArrayList<String> x,ArrayList<String> GE) throws IOException {
        super(x);
        setter(x);
           File arian=new File("C:/Users/Dr Techno/Desktop/RentalRegistries.txt");
           if (!arian.exists()){
               FileWriter arian2=new FileWriter("C:/Users/Dr Techno/Desktop/RentalRegistries.txt");
           }
        File fileBook=new File("C:/Users/Dr Techno/Desktop/book.txt");
        if (fileBook.exists()){
            ArrayList<String> settingStatus=new ArrayList<>();;
            Scanner scan=new Scanner(fileBook);
          while (scan.hasNextLine()){
              settingStatus.add(scan.nextLine());
          }
          try {
              for (int i = 0; settingStatus.get(i) != null; i++) {
                  ArrayList<String> bookStatus = new ArrayList<>(List.of(settingStatus.get(i).substring(1, settingStatus.get(i).length() - 1).split(", ")));
                  if (Objects.equals(bookStatus.get(3), Title) && Objects.equals(bookStatus.get(1), Author) && bookStatus.get(5).equals("true")) {
                      bookStatus.set(5, "false");
                      settingStatus.set(i, String.valueOf(bookStatus));
                      FileWriter arian3 = new FileWriter("C:/Users/Dr Techno/Desktop/book.txt");
                      PrintWriter pw2 = new PrintWriter(arian3);
                      for (int G = 0; settingStatus.get(G) != null; G++) {
                          pw2.println(settingStatus.get(G));
                      }
                      pw2.close();
                      arian3.close();
                      ArrayList<String> newOne = new ArrayList<>();
                      newOne.add(getter().get(1));
                      newOne.add(Title);
                      newOne.add(Author);
                      FileWriter rentalRegistries = new FileWriter("C:/Users/Dr Techno/Desktop/RentalRegistries.txt");
                      PrintWriter pw = new PrintWriter(rentalRegistries);
                      pw.println(newOne);
                      pw.close();
                      rentalRegistries.close();
                      System.out.println("here's your book have a fun time reading");
                      F=1;
                      break;
                    }
                  }
              if (F==0){
                  System.out.println("no such book is available");

                  if (Objects.equals(x.get(0), "user")){
                      UserComendline();
                  }
                  else if (Objects.equals(x.get(0), "admin")) {
                      AdminsCommandLine();
                  }
                  return;
              }
                  }catch(IndexOutOfBoundsException ignored){
                  }
          finally{
                      FileWriter arian3 = new FileWriter("C:/Users/Dr Techno/Desktop/book.txt");
                      PrintWriter pw2 = new PrintWriter(arian3);
                    try {
                        for (int G = 0; settingStatus.get(G) != null; G++) {
                            pw2.println(settingStatus.get(G));
                        }
                    }catch (IndexOutOfBoundsException ignored){
                    }
                    finally {
                      pw2.close();
                      arian3.close();
                      ArrayList<String> newOne = new ArrayList<>();
                      newOne.add(getter().get(1));
                      newOne.add(Title);
                      newOne.add(Author);
                      FileWriter rentalRegistries = new FileWriter("C:/Users/Dr Techno/Desktop/RentalRegistries.txt");
                      PrintWriter pw = new PrintWriter(rentalRegistries);
                      pw.println(newOne);
                      pw.close();
                      rentalRegistries.close();
                  }
                    }
        }else {
            System.out.println("we don't have any kind of available book to rent please come back later");

        }
          if (GE != null){
             library mine=new library(GE);
              if (Objects.equals(x.get(0), "user")){
                mine.UserComendline();

              }
              else if (Objects.equals(x.get(0), "admin")) {
                  mine.AdminsCommandLine();
              }
          }else {
              if (Objects.equals(x.get(0), "user")){
                  UserComendline();

              }
              else if (Objects.equals(x.get(0), "admin")) {
                 AdminsCommandLine();
              }
          }
    }
}

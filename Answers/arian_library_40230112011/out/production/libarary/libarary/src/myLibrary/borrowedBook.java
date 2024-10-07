package myLibrary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class borrowedBook {
   ArrayList<String> myArray = new ArrayList<>();

   void giveData(ArrayList<String> x) {
      this.myArray = x;
   }

   ArrayList showConfig() {
      return this.myArray;
   }

   borrowedBook(ArrayList<String> x) throws IOException {
      giveData(x);
      File showReturn = new File("C:/Users/Dr Techno/Desktop/RentalRegistries.txt");
      if (showReturn.exists()) {
         Scanner scan = new Scanner(showReturn);
         while (scan.hasNextLine()) {
            String xyz = scan.nextLine();
            ArrayList<String> Abass = new ArrayList<>(List.of(xyz.substring(1, xyz.length() - 1).split(", ")));
            if (showConfig().get(1).equals(Abass.get(0))) {
               System.out.println(Abass.get(1) + "\n");
               menuPage arian = new menuPage(String.valueOf(showConfig().get(0)), myArray);
            }
         }
         System.out.println("no books were borrowed");
         menuPage arian = new menuPage(String.valueOf(showConfig().get(0)), myArray);
      }else {
         System.out.println("no books were borrowed");
         menuPage arian = new menuPage(String.valueOf(showConfig().get(0)), myArray);
      }
   }
}
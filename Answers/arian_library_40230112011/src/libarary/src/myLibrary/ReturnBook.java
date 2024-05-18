package myLibrary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ReturnBook {
    ArrayList<String> myPerson=new ArrayList<>();
    void setter(ArrayList<String> x){
        this.myPerson=x;
    }
    ArrayList<String> getter(){
        return this.myPerson;
    }
    ReturnBook(String Title, String Author, ArrayList<String> x) throws IOException {
        setter(x);
        File rentalBookFile=new File("C:/Users/Dr Techno/Desktop/RentalRegistries.txt");
        if (rentalBookFile.exists()){
            Scanner Scanner=new Scanner(rentalBookFile);
            ArrayList<String> Array=new ArrayList<>();
            while (Scanner.hasNextLine()){
                String xyz=Scanner.nextLine();
                Array.add(xyz);
            }
            Scanner.close();
           try{
                for (int i=0;Array.get(i)!=null;i++){
                    ArrayList<String> myOwnArray=new ArrayList<>(List.of(Array.get(i).substring(1,Array.get(i).length()-1).split(", ")));
                    if (myOwnArray.get(0).equals(getter().get(1))&& myOwnArray.get(2).equals(Author)&&myOwnArray.get(1).equals(Title)){
                        File returningBook=new File("C:/Users/Dr Techno/Desktop/book.txt");
                        if (returningBook.exists()){
                        java.util.Scanner scan=new Scanner(returningBook);
                        ArrayList<String> bookSetting=new ArrayList<>();
                        while (scan.hasNextLine()){
                            bookSetting.add(scan.nextLine());
                        }
                        try {
                            for (int G = 0; bookSetting.get(G)!=null; G++){
                                ArrayList<String> bookAdjusting=new ArrayList<>(List.of(bookSetting.get(i).substring(1,bookSetting.get(i).length()-1).split(", ")));
                                if (Objects.equals(bookAdjusting.get(3),Title)&&Objects.equals(Author,bookAdjusting.get(1))){
                                    bookAdjusting.set(5, "true");
                                    bookSetting.set(i,String.valueOf(bookAdjusting));
                                    break;
                                }
                            }
                        }
                        catch (IndexOutOfBoundsException ignored){
                        }finally {
                            FileWriter Writer=new FileWriter("C:/Users/Dr Techno/Desktop/book.txt");
                            Array.remove(i);
                            for (int G=0;bookSetting.get(G)!=null;G++){
                            PrintWriter pw=new PrintWriter(Writer);
                            pw.println(bookSetting.get(G));
                            pw.close();
                            }
                            Writer.close();
                             }
                        }
                        break;
                    }else {
                        System.out.println("NO such user or book have been found");
                    }
                }
            }catch (IndexOutOfBoundsException exception){
               FileWriter NewOne=new FileWriter("C:/Users/Dr Techno/Desktop/RentalRegistries.txt");
             try {
                 for (int K=0;Array.get(K)!=null;K++){
               PrintWriter pw=new PrintWriter(NewOne);
                     pw.println(Array.get(K));
                     pw.close();
                 }
             }catch (IndexOutOfBoundsException exception1){
               NewOne.close();
             }
               NewOne.close();
           }
        }else {
        }
    }
}

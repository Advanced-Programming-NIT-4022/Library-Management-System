package myLibrary;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class removingPersonal {
    ArrayList<String> myArray=new ArrayList<>();
    void setter(ArrayList<String> x){
        this.myArray=x;
    }
    ArrayList<String> getter(){
        return this.myArray;
    }
    public removingPersonal( String z, String y,String u) throws IOException {
        File execution = new File("C:/Users/Dr Techno/Desktop/"+y+".txt");
        if (execution.exists()) {
            Scanner scan = new Scanner(execution);
            ArrayList<String> removingUser = new ArrayList<>();
            while (scan.hasNextLine()) {
                removingUser.add(scan.nextLine());
            }
             try {
                 for (int i = 0; removingUser.get(i) != null; i++) {
                     ArrayList<String> execute = new ArrayList<>(List.of(removingUser.get(i).substring(1, removingUser.get(i).length() - 1).split(", ")));
                     if (Objects.equals(execute.get(2), (z))) {
                         removingUser.remove(i);
                         if (y.equals("admin")){
                         System.out.println("The admin was deleted from our library");
                             menuPage arian=new menuPage(u,getter());
                         }else if(y.equals("user")){
                             System.out.println("The Client was deleted from our library");
                             menuPage arian2=new menuPage(u,getter());
                         }
                         break;
                     }
                 }
             }catch (IndexOutOfBoundsException exception) {

                FileWriter newFile = new FileWriter("C:/Users/Dr Techno/Desktop/" + y + ".txt");
                PrintWriter writer1 = new PrintWriter(newFile);
                try {
                    for (int G = 0; removingUser.get(G) != null; G++) {
                        writer1.println(removingUser.get(G));
                    }
                } catch (IndexOutOfBoundsException exception1) {
                    newFile.close();
                    writer1.close();
                }
                newFile.close();
                writer1.close();
            }finally {
                 FileWriter newFile = new FileWriter("C:/Users/Dr Techno/Desktop/" + y + ".txt");
                 PrintWriter writer1 = new PrintWriter(newFile);
                 try {
                     for (int G = 0; removingUser.get(G) != null; G++) {
                         writer1.println(removingUser.get(G));
                     }
                 } catch (IndexOutOfBoundsException exception1) {
                     newFile.close();
                     writer1.close();
                 }
                 newFile.close();
                 writer1.close();
             }
        }
    }
}





package myLibrary;

import java.io.*;
import java.util.*;

public class admin extends  user implements Interface{
   String  showPassword(){
      return this.password;
   }
   private  String password;
   Date date=new Date();
   private final String dateOfAdministretion= String.valueOf(date);
   public String givingDate(){
      return this.dateOfAdministretion;
   }
admin(String x, ArrayList<String> y) throws IOException {
   super(y);
  savingFile(x,y);
      File myAdmin=new File("C:/Users/Dr Techno/Desktop/user.txt");
      if (myAdmin.exists()){
         Scanner scan=new Scanner(myAdmin);
         ArrayList<String> removingUser=new ArrayList<>();
         while (scan.hasNextLine()){
            removingUser.add(scan.nextLine());
         }
         try{
            for (int i=0;removingUser.get(i)!=null;i++){
               ArrayList<String> execute=new ArrayList<>(List.of(removingUser.get(i).substring(1,removingUser.get(i).length()-1).split(", ")));
               if (Objects.equals(execute.get(1), y.get(1))){
                  removingUser.remove(i);
                  break;
               }}
         }catch (IndexOutOfBoundsException e){
               FileWriter newFile=new FileWriter("C:/Users/Dr Techno/Desktop/user.txt");
               PrintWriter writer1=new PrintWriter(newFile);
               try {
                  for (int G=0;removingUser.get(G)!=null;G++){
                     writer1.println(removingUser.get(G));
                  }
               }catch (IndexOutOfBoundsException exception){
                  newFile.close();
                  writer1.close();
                  return;
               }
               newFile.close();
               writer1.close();
            }finally {
            FileWriter newFile=new FileWriter("C:/Users/Dr Techno/Desktop/user.txt");
            PrintWriter writer1=new PrintWriter(newFile);
            try {
               for (int G=0;removingUser.get(G)!=null;G++){
                  writer1.println(removingUser.get(G));
               }
            }catch (IndexOutOfBoundsException exception){
               newFile.close();
               writer1.close();
               return;
            }
            newFile.close();
            writer1.close();
         }
         }
      }

   public void savingFile(String x,ArrayList<String> y) throws IOException {
      File myAdminFile=new File(x);
      if (myAdminFile.exists()){
         System.out.print("Enter the password of your admin:");
         this.password=strOrder();
         y.add(showPassword());
         y.add(givingDate());
         FileWriter writer=new FileWriter(x,true);
         PrintWriter pw=new PrintWriter(writer);
         pw.println(y);
         pw.close();
         writer.close();
      } else {
         System.out.print("Enter the password of your admin:");
         this.password=strOrder();
         y.add(showPassword());
         y.add(givingDate());
         FileWriter writer=new FileWriter(x);
         PrintWriter pw=new PrintWriter(writer);
         pw.println(y);
         pw.close();
         writer.close();
      }
   }
}

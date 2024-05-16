import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NormalUsers extends User {
    String registeryDate;
    String password;
    String rentBooks = "";
    static ArrayList<NormalUsers> normalUsersArray = new ArrayList<>();
    public NormalUsers(String C_name , String C_pass, String C_registryDate){
        name=C_name;
        password=C_pass;
        registeryDate=C_registryDate;
    }
    public static void  copyFileOnNormalUser() {
        try {
            File normalUsers = new File("C:\\Users\\MSI\\OneDrive\\Desktop\\Lib\\Library-Management-System\\Answers\\Library\\src\\normalUsers.txt");
            normalUsers.createNewFile();
            Scanner reader = new Scanner(normalUsers);
            while (reader.hasNextLine()) {
                String[] copy = reader.nextLine().split("#");
                NormalUsers normalUser = new NormalUsers(copy[0],copy[1],copy[2]);
                normalUser.uniqueID= Integer.parseInt(copy[3]);
                for(int i=3 ; i< copy.length;i++){
                    normalUser.rentBooks = copy[i] + "#";
                }
                normalUsersArray.add(normalUser);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("sorry");
        }
    }
    public static void copyNormalUserOnFile() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\MSI\\OneDrive\\Desktop\\Lib\\Library-Management-System\\Answers\\Library\\src\\normalUsers.txt");
            for (int i=0 ; i< normalUsersArray.size(); i++){
                writer.write((normalUsersArray.get(i).name)+"#"+(normalUsersArray.get(i).password)+"#"+normalUsersArray.get(i).registeryDate+"#"+normalUsersArray.get(i).uniqueID+"#");
                for(int j=0; j< normalUsersArray.get(i).rentBooks.split("#").length;j++){
                    writer.write(normalUsersArray.get(i).rentBooks.split("#")[j]+"#");
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("sorry");
            throw new RuntimeException(e);
        }


    }
    public static int  getUserID(String name){
        for(int i=0 ; i< NormalUsers.normalUsersArray.size();i++){
            if(NormalUsers.normalUsersArray.get(i).name.equals(name)){
                return i ;
            }


        }
        return (-1);
    }
    public static boolean  checkPass(int userID, String userPass){
        if(NormalUsers.normalUsersArray.get(userID).password.equals(userPass)) {
            return true;
        }
        return false;
    }
    public static boolean checkUsers(String name){
        for(int i=0; i<normalUsersArray.size();i++){
            if(name.equals(normalUsersArray.get(i).name)){
                return true;
            }
        }
        return false;
    }

}

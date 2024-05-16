import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User{
    String password;
    static ArrayList<Admin> adminArray = new ArrayList<>();
    final String manegerPass = "DonNotHoldaGrudge";
    public Admin(String C_name,String C_pass){
        name=C_name;
        password=C_pass;
    }
    public static  void  copyFileOnAdmin() {
        try {

            File admins = new File("C:\\Users\\MSI\\OneDrive\\Desktop\\Lib\\Library-Management-System\\Answers\\Library\\src\\admins.txt");
            admins.createNewFile();
            Scanner reader = new Scanner(admins);
            while (reader.hasNextLine()) {
                String[] copy = reader.nextLine().split("#");
                Admin admin = new Admin(copy[0],copy[1]);
                adminArray.add(admin);

            }
            reader.close();
        } catch (Exception e) {
            System.out.println("sorry");
        }
    }
    public static void copyAdminOnFile() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\MSI\\OneDrive\\Desktop\\Lib\\Library-Management-System\\Answers\\Library\\src\\admins.txt");
            for (int i=0 ; i< adminArray.size(); i++){
                writer.write((adminArray.get(i).name)+"#"+(adminArray.get(i).password)+"\n");
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("sorry");
            throw new RuntimeException(e);
        }


    }
    public static int  getAdminID(String name){
        for(int i=0 ; i< Admin.adminArray.size();i++){
            if(Admin.adminArray.get(i).name.equals(name)){
                return i ;
            }
        }
        return (-1);
    }
    public static boolean  checkAdminPass(int adminID, String adminPass){
        if(Admin.adminArray.get(adminID).password.equals(adminPass)) {
            return true;
        }
        return false;
    }
    public static boolean checkAdmins(String name){
        for(int i=0; i<adminArray.size();i++){
            if(name.equals(adminArray.get(i).name)){
                return true;
            }
        }
        return false;
    }

}

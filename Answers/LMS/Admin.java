import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Admin extends User{
    File passAdminsFile = new File("passwordAdmin.txt");
    public Admin (String userName , String userID , String phoneNumber){
        super("AdminUserName", "AdminUserID", "AdminPhoneNumber");
        
        try{
            boolean isName = userNameFile.createNewFile();
            boolean isID = userIDFile.createNewFile();
            boolean isPhone = phoneNumberFile.createNewFile();
            boolean isPass = passAdminsFile.createNewFile();

        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
    }
}

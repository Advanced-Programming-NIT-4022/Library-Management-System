import java.io.File;
import java.io.IOException;

public class Admin extends User{
    File passAdminsFile = new File("passwordAdmin.txt");
    public Admin (String userName , String userID , String phoneNumber){
        super("AdminUserName", "AdminUserID", "AdminPhoneNumber");
        
        try{
            boolean isPass = passAdminsFile.createNewFile();

        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
    }
}

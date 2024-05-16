import java.io.File;
import java.io.IOException;

public class NormalUser extends User {
    File dateUserFile = new File("dateUser.txt");

    public NormalUser(String userName , String userID , String phoneNumber ){
        super("NormalUserName", "NormalUserID", "NormalPhoneNumber");
        
        try{
            boolean isDate = dateUserFile.createNewFile();

        }catch(IOException e){
            System.out.println("error 404!\npage not found!");
        }
    }
    
}

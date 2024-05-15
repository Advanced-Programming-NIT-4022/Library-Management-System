import java.io.File;
import java.io.IOException;

public class User {
    public User(String userName , String userID , String phoneNumber){
        
        try {
            File phoneNumberFile = new File(phoneNumber+".txt");
            File userIDFile = new File(userID+".txt");
            File userNameFile = new File(userName+".txt");

            boolean isCreated = userNameFile.createNewFile();
            isCreated = userIDFile.createNewFile();
            isCreated = phoneNumberFile.createNewFile();
        } catch (IOException e) {
            System.out.println("error 404!\npage not found! " + e);
        }
    }
}

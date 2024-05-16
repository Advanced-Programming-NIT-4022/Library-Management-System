import java.io.File;

public class User {

    public User(String userName, String userID, String phoneNumber) {

        File userNameFile = new File(userName + ".txt");

        File userIDFile = new File(userID + ".txt");

        File phoneNumberFile = new File(phoneNumber + ".txt");
        try {
            boolean isName = userNameFile.createNewFile();
            boolean isID = userIDFile.createNewFile();
            boolean isPhone = phoneNumberFile.createNewFile();
        } catch (Exception e) {
            System.out.println("error 404!\npage not found!");
        }
        
    }
}

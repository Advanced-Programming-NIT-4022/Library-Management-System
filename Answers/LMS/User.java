import java.io.File;

public class User {
    String userName;
    File userNameFile = new File(userName+".txt");
    String userID;
    File userIDFile = new File(userID+".txt");
    String phoneNumber;
    File phoneNumberFile = new File(phoneNumber+".txt");

    public User(String userName , String userID , String phoneNumber){
        this.userName = userName;
        this.userID = userID;
        this.phoneNumber = phoneNumber;
    }
}

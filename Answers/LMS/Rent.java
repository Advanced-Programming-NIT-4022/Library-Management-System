import java.io.File;
import java.io.IOException;

public class Rent {
    File bookName = new File("rentBookName.txt");
    File bookID = new File("rentBookID.txt");
    File userName = new File("rentUserName.txt");
    File userID = new File("rentUserID.txt");
    File rentDate = new File("rentDate.txt");

    public Rent(){
        try{
            boolean isRentBookName = bookName.createNewFile();
            boolean isRentBookID = bookID.createNewFile();
            boolean isRentUserName = userName.createNewFile();
            boolean isRentUserID = userID.createNewFile();
            boolean isRentDate = rentDate.createNewFile();
        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }

    }
}

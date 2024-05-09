import java.io.File;
import java.io.FileWriter;

public class Admin extends User {
    public Admin(String studentId , String password){
        super();
        this.Id = studentId;
        this.password = password;
    }

    public void add(){
        try {
            FileWriter addAdmin = new FileWriter("admin.txt");
            addAdmin.write(Id + "," + name + "," + phoneNumber + "," + password + "\n");
            addAdmin.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

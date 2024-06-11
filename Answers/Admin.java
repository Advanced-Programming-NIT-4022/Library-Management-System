import java.util.HashMap;

public class Admin extends User {
    HashMap<String,String> adminsave=new HashMap<>();
    public void addAdmin(String adname,String adpass) {
        uname=adname;
        userpass=adpass;
        adminsave.put(adname, adpass);
    }
}

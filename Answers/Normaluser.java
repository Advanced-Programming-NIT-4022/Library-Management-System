import java.time.LocalDate;

public class Normaluser extends User {
    LocalDate logindate=LocalDate.now();
    public void makeaccount(String lname,String lpass) {
        uname = lname;
        userpass = lpass;
        memidsave.put(lname,userid);
        userid++;
        mempasssave.put(lname,lpass);
    }
}
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

class NormalUser extends User{

    String id;
    Timestamp time = new Timestamp(System.currentTimeMillis());
    public void addMember(String phoneNumber, String name) {
        if (numberCheck(getPhoneNumber(), "student")) {
            Connect.getConnect("INSERT INTO student (name, registration, phonenumber) VALUES ('"+getName()+"','"+time+"','"+getPhoneNumber()+"')");

            try{
                ResultSet rs = Connect.getConnectExecute("SELECT id FROM student WHERE phonenumber = '"+getPhoneNumber()+"'");
                if(rs.next()) {
                    id = rs.getString("id");
                    System.out.println("Your id is: " + id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("You entered a duplicate number!!!");
        }
    }
}

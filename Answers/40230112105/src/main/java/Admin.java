import java.sql.ResultSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Admin extends User{

    private String password;
    private String id;

    public void setPassword(String password) {
        boolean flag = true;
        while(flag) {
            if(Pattern.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9\\\\s]).{6,}", password)){
                this.password = password;
                flag = false;
            } else {
                System.out.print("NOTE: your password should contain at least one word, one digit \n" +
                        "and one special character and also contain more than 5 characters: ");
                Scanner strScanner = new Scanner(System.in);
                password = strScanner.next();
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void addAdmin(String name, String phoneNumber) {
        if (numberCheck(getPhoneNumber(), "manager")) {
            Connect.getConnect("INSERT INTO manager (name, password, phonenumber) VALUES ('" +getName()+ "','" +password+ "','" +getPhoneNumber()+ "')");

            try{
                ResultSet rs = Connect.getConnectExecute("SELECT id FROM manager WHERE phonenumber = '" +getPhoneNumber() +"'");
                System.out.println("Your account created!");
                if (rs.next()) {
                    id = rs.getString("id");
                    System.out.println("Your id is: " + id);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            System.out.println("You entered a duplicate number!!!");
        }
    }

    public boolean accessed(String id, String password) {
        ResultSet rs = Connect.getConnectExecute("SELECT id FROM manager WHERE id = '" + id + "'");
        try {
            if (rs.next()) {
                ResultSet rs2 = Connect.getConnectExecute("SELECT password,name FROM manager WHERE id = '" + id + "'");
                if (rs2.next() && rs2.getString("password").equals(password)) {
                    System.out.println("Welcome " + rs2.getString("name") + "!");
                    return true;
                } else {
                    System.out.println("Access denied!");
                }
            } else {
                System.out.println("Can't fine this admin!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

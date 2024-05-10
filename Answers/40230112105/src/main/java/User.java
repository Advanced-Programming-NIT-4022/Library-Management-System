import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User{

    public String name;
    public String phoneNumber;
    public String id;
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        boolean flag = true;
        while(flag){
            if(Pattern.matches("^[a-zA-Z\\s]+$", name)) {
                this.name = name;
                flag = false;
            } else {
                System.out.print("You entered invalid name.Try again: ");
                Scanner strScanner = new Scanner(System.in);
                name = strScanner.nextLine();
            }
        }
    }

    public void setphoneNumber(String number) {
        boolean flag = true;
        while(flag) {
            if(Pattern.matches("^09[0-9]{9}$", number)){
                this.phoneNumber = number;
                flag = false;
            } else {
                System.out.print("You entered invalid number.Try again: ");
                Scanner strScanner = new Scanner(System.in);
                number = strScanner.next();
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getId() {
        return id;
    }

    public boolean numberCheck(String phonenumber) {
        String[] number= new String[1000];
        ResultSet rs = Connect.getConnectExecute("SELECT * FROM student");
        int i = 0;
        try {
            while(rs.next()) {
                number[i] = rs.getString("phonenumber");
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int j = 0; j < i; j++) {
            if(number[j].equals(phonenumber)){
                return false;
            }
        }
        return  true;
    }

    public void removeMember(String id) {
        try {
            ResultSet rs = Connect.getConnectExecute("SELECT id FROM student WHERE id = '"+ id +"'");
            if(rs.next()){
                Connect.getConnect("DELETE FROM student WHERE id = '"+ id +"'");
                System.out.println("The user account has been deleted");
            } else {
                System.out.println("There is no id like this!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
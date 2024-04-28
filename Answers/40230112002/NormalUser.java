import java.util.Date;


public class NormalUser extends User {
    private String regDate;

    private int Unique_NormalUserID;

    public NormalUser(String name , String Phone_Number) {
        super(name ,Phone_Number);
        this.regDate = String.valueOf(CurrentDateTime());
        this.Unique_NormalUserID = getUnique_UserID();
    }


    public Date CurrentDateTime(){
        java.util.Date date = new java.util.Date();
        return date;
    }

    public String toString(){
        return super.toString() +" " + regDate;
    }

}

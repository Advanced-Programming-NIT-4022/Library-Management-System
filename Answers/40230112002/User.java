import java.util.Random;

public class User{

    private String name;
    private static int Unique_UserID = 0;
    private String Phone_Number;
    public User(String name , String Phone_Number){

        this.name = name;
        this.Unique_UserID = generateUniqueUserID();
        this.Phone_Number = Phone_Number;

    }

    public String toString(){
        return this.name + " " + this.Phone_Number + " " + this.Unique_UserID;
    }

    public static int generateUniqueUserID() {
        return ++Unique_UserID;
    }

    public int getUnique_UserID(){
        return Unique_UserID;
    }
}

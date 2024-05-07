public class User {
    private static int UserID;
    private String Name;
    private String PhoneNumber;
    public User(String Name , String PhoneNumber , int UserID){
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.UserID = UserID;
    }
    public int getUserID(){

        return UserID;
    }
    public String getName(){

        return Name;
    }
    public String getPhoneNumber(){

        return PhoneNumber;
    }
}

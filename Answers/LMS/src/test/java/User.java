public class User {
    private int UserID;
    private String Name;
    private int PhoneNumber;
    public User(String Name , int PhoneNumber){
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
    public int getPhoneNumber(){

        return PhoneNumber;
    }
}

 public class User {

    private String name;
    public static Integer LastUserID = 0;
    private int UserID;
    private String phoneNumber;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.UserID = ++LastUserID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getUserID() {
        return UserID;
    }

    public String toString(){
        return this.name + " " + this.phoneNumber + " " + this.UserID;
    }


}

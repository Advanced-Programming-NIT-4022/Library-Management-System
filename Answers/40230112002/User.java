abstract public class User {

    private String name;
    private static Integer userID = 0;
    private String phoneNumber;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        userID++;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getUserID() {
        return userID;
    }
    public static int generateUserID() {
        return ++userID;
    }

    public String toString(){
        return this.name + " " + this.phoneNumber + " " + userID;
    }
}

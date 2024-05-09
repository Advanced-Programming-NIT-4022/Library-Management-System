public class User {
    private String user_name;
    private String userID;
    private String phonenumber;
    private String role;

    // constructor
    public User(String userName, String userId, String phoneNumber, String role)
    {
        this.role = role;
        this.phonenumber = phoneNumber;
        this.user_name = userName;
        this.userID = userId;
    }

    // getters
    public String getUserID() { return this.userID; }
    public String getUser_name() { return this.user_name; }
    public String getPhonenumber() { return this.phonenumber; }
    public String getRole() { return this.role; }
}

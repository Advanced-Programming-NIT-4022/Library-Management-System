public class User {
    private String user_name;
    private String userID;
    private String phonenumber;
    private String role;
    private String password;

    // constructor
    public User(String userName, String userId, String phoneNumber, String role, String _pass)
    {
        this.role = role;
        this.phonenumber = phoneNumber;
        this.user_name = userName;
        this.userID = userId;
        this.password = _pass;
    }

    // getters
    public String getUserID() { return this.userID; }
    public String getUser_name() { return this.user_name; }
    public String getPhonenumber() { return this.phonenumber; }
    public String getRole() { return this.role; }
    public String getPassword() { return this.password; }

    public void set_new_username(String new_user){
        this.user_name = new_user;
    }
}

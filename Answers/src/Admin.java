public class Admin extends User {
    private String password;

    public Admin(String name, String phoneNumber, String password) {
        super(name, phoneNumber);
        this.password = password;
    }
    // to verify the password
    public boolean Verify(String password) {
        if (this.password.equals(password))
            return true;
        return false;
    }
}

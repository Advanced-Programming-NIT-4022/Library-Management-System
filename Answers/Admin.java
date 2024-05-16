public class Admin extends User {
    private String password;
    String uniqueAId;
    public Admin(String name, String uniqueID, String phoneNumber, String password) {
        super(name, uniqueID, phoneNumber);
        this.password = password;
        this.uniqueAId = uniqueID;
    }

    public String getPassword() {
        return password;
    }
    public String getUniqueId() {
        return uniqueAId;
    }

}


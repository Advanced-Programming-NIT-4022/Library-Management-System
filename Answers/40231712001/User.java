class User {
    // Attributes
    private final long userID;
    private String name;
    private String phoneNumber;
    private String password;

    // Contructor
    public User(long userID_a, String name_a, String phoneNumber_a, String password_a) {
        userID = userID_a;
        name = name_a;
        phoneNumber = phoneNumber_a;
        password = password_a;
    }

    // Getter/Setter(s)
    public long getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }

    /* return-value             meaning
     *      (-2)       (password isn't strong)
     *      (-1)           (wrong password)
     *      (1)        (wrong repeated password)
     *      (0)           (password reseted)
     */ 
    public int resetPassword(String prePass, String newPass, String repeatPass) {
        if (prePass != password)
            return -1;

        if (newPass != repeatPass)
            return 1;

        if (!Util.isPassStrong(newPass))
            return -2;

        password = newPass;
        return 0;
    }
}

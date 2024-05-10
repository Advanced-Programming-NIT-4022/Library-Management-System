
public class Admin extends User {
    private final String password;

    public Admin(String name, String phoneNumber, String password) throws IllegalArgumentException {
        super(name, phoneNumber);

        // validate password
        if (!password.matches(".*\\d.*") && !password.matches(".*[a-z].*") &&
                !password.matches(".*[A-Z].*") && !password.matches("[^(\"\\s)]*"))
            throw new IllegalArgumentException("Password should contain at least one digit," +
                    "one capital and small letter\nand should not have \" character and white spaces.");

        this.password = password;
    }

    // to verify the password
    public boolean verify(String password) {
        return this.password.equals(password);
    }
}

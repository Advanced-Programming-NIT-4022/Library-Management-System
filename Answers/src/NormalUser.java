import java.sql.Timestamp;

public class NormalUser extends User {
    private Timestamp registerTimestamp;

    public NormalUser(String name, String phoneNumber, Timestamp registerDateTime) {
        super(name, phoneNumber);
        this.registerTimestamp = registerDateTime;
    }

    public NormalUser(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.registerTimestamp = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getRegisterTimestamp() {
        return registerTimestamp;
    }
}
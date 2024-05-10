import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class NormalUser extends User {
    private final Date registerDate;
    private final Time registerTime;

    public NormalUser(String name, String phoneNumber, Date registerDate, Time registerTime) {
        super(name, phoneNumber);
        this.registerDate = registerDate;
        this.registerTime = registerTime;
    }

    public NormalUser(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.registerDate = Date.from(Instant.from(LocalDate.now()));
        this.registerTime = Time.valueOf(LocalTime.now());
        }

    public Date getRegisterDate() {
            return registerDate;
        }

    public Time getRegisterTime() {
            return registerTime;
        }
    }
// this class inherits from class User
// and simulates the NormalUser
import java.time.LocalDate;
import java.time.LocalTime;

public class NormalUser extends User {
    private LocalDate registerDate;
    private LocalTime registerTime;

    public NormalUser(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.registerDate = LocalDate.now();
        this.registerTime = LocalTime.now();
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public LocalTime getRegisterTime() {
        return registerTime;
    }
}
import java.time.LocalTime;
import java.time.LocalDate;

public class NormalUser extends User {
        private final LocalDate registerDate;
        private final LocalTime registerTime;

        public NormalUser(String name, String phoneNumber) throws IllegalArgumentException {
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
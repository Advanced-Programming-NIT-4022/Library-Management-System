import java.util.Date;

    public class NormalUser extends User {
        private Date registrationDate;

        public NormalUser(String name, String phoneNumber) {
            super(name, phoneNumber);
            this.registrationDate = new Date();
        }

        public Date getRegistrationDate() {
            return registrationDate;
        }
    }


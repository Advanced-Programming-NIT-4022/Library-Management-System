import java.util.Date;
class NormalUser extends User {
    private Date registrationDate;

    public NormalUser(String name, String uniqueID, String phoneNumber) {
        super(name, uniqueID, phoneNumber);
        this.registrationDate = new Date();
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}

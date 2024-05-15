public class NormalUser extends User {
    private String registrationDate;
    public NormalUser(String name,int UniqueID,int phoneNumber,String registrationDate) {
        super( name, UniqueID, phoneNumber);
        this.registrationDate=registrationDate;
    }
    public String getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    
}

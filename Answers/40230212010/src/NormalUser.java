public class NormalUser extends User {

    private String registrationDate;

    public NormalUser(String name,int phoneNumber,String registrationDate) {
        super( name,  phoneNumber);
        this.registrationDate=registrationDate;
    }


    public String getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    
}

import java.util.Date;

class NormalUser extends User{
    private Date RegistrationDate;
    public NormalUser(String Name , int PhoneNumber){
        super(Name , PhoneNumber);
        this.RegistrationDate = new Date();
    }
    public Date getRegistrationDate(){

        return RegistrationDate;
    }
}

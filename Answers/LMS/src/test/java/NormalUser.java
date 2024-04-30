import java.util.Date;

class NormalUser extends User{
    private Date RegistrationDate;
    public NormalUser(String Name , String PhoneNumber , int UserID , Date RegistrationDate){
        super(Name , PhoneNumber , UserID);
        this.RegistrationDate = RegistrationDate;
    }
    public Date getRegistrationDate(){

        return RegistrationDate;
    }
}

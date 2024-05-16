public class Admin extends User
{
    private String Password;

    public Admin(String name , int ID , String number , String Password)
    {
        super(name, ID, number);
        this.setPassword(Password);
    }
    public String getPassword()
    {
        return Password;
    }
    public void setPassword(String Password)
    {
        this.Password=Password;
    }
}
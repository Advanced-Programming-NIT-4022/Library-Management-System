public class Admin extends User {
    private String Password;
    public Admin(String name , int ID , String phonnumber , String Password)
    {
        super(name, ID, phonnumber);
        this.setPassword(Password);
    }
    public void setPassword(String Password)
    {
        this.Password=Password;
    }
    public String getPassword()
    {
        return Password;
    }

}

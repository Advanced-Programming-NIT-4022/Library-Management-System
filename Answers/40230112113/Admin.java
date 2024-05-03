public class Admin extends User
{
    String Password="Hst1234";
    public Admin(String name , int ID , int number , String Password)
    {
        super(name, ID, number);
        this.Password=Password;
    }
}

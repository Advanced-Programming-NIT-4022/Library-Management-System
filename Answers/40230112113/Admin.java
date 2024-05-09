import java.util.Scanner;

public class Admin extends User
{
    private String Password;
    Scanner sc = new Scanner(System.in);

    public Admin(String name , int ID , int number , String Password)
    {
        super(name, ID, number);
        this.Password=Password;
    }
    public String getPassword()
    {
        return Password;
    }
}
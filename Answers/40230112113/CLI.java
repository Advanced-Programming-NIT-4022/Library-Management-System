import java.util.ArrayList;
import java.util.Scanner;

public class CLI
{
    //i shouldn't have written this class. using only the library class was sufficient :')

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";

    static Scanner sc = new Scanner(System.in);

    Library library;
    public CLI(Library library)
    {
        this.library=library;
    }

    Boolean First_Run=true;
    public void Run()
    {
        if(First_Run)
        {
            System.out.println(BLUE+"WELCOME"+RESET);
            First_Run=false;
        }
        System.out.println(PURPLE+"1-ADMIN\n"+"2-NORMAL USER\n"+"3-Exit\n"+RESET);
        int a = sc.nextInt();
        switch(a)
        {
            case 1:
                AdminPanel();
                break;
            case 2:
                NormalUserPanel();
                break;
            case 3:
                System.out.println(GREEN+"Have a nice day!"+RESET);
                break;
        }
        sc.close();
    }


    Boolean First_time_ad=true;
    public void AdminPanel()
    {
        if(First_time_ad)
        {
            System.out.println(BLUE+"WELCOME TO ADMIN PANEL"+RESET);
            First_time_ad=false;
        }
        System.out.println("please enter your name and password");
        System.out.print("Name: ");
        String AdminName = sc.nextLine();
        
        if(AdminName.equalsIgnoreCase("exit"))
        {
            Run();
        }
        else if(library.CheckName(AdminName))
        {

        }
        else
        {
            System.out.println("no match found. please try again.");
            AdminPanel();
        }
    }


    Boolean First_time_us=true;
    public void NormalUserPanel()
    {
        if(First_time_us)
        {
            System.out.println("WELCOME TO RAIN LIBRARY");
            First_time_us=false;
        }
        System.out.println("Please enter your Phone Number and Student ID");
        System.out.println("to go back to the main menu please enter \"exit\" ");
        System.out.print("Phone Number: ");
        String phonenumber = sc.nextLine();

        
    }


    public void AllCommands()
    {

    }
}

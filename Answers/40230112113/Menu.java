import java.util.Scanner;

public class Menu
{
    public final String RESET = "\u001B[0m";
    public final String RED = "\u001B[31m";
    public final String GREEN = "\u001B[32m";
    public final String YELLOW = "\u001B[33m";
    public final String PURPLE = "\u001B[35m";
    public final String BLUE = "\u001B[34m";

    public void MainMenu()
    {
        System.out.println(BLUE+"WELCOME"+RESET);
        System.out.println(PURPLE+"1-ADMIN\n"+"2-User\n"+"3-Exit\n"+RESET);
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch(a)
        {
            case 1:

                break;
            case 2:

                break;
            case 3:
                System.out.println(GREEN+"Have a nice day!"+RESET);
                break;
        }
    }
}

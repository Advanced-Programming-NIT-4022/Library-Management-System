import java.util.Scanner;

public class MyApp
{
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args)
    {
        System.out.println(BLUE+"WELCOME"+RESET);
        System.out.println(PURPLE+"1-ADMIN\n"+"2-User\n"+"3-Exit\n"+RESET);
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.close();
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

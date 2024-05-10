import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        Library lib = new Library("Nit central library", "7a.m.to7p.m.",100);
        Scanner scn = new Scanner(System.in);
        String cmd;
        while (true){
            System.out.print("\033[H\033[2J");
            System.out.println("***************************************************");
            System.out.println("Welcome to "+ lib.getLibName());
            System.out.println("Each commands start with lib : Example below.");
            System.out.println("to add book : lib add etc. ");
            System.out.println("to login : lib login");
            System.out.println("to sign up as normal user : lib signup");
            System.out.print(">>>");
            cmd = scn.nextLine();
            if(!cmd.contains("lib")){
                System.out.println("Wrong format, try again.");
            }
            else{
                if(Objects.equals(cmd, "lib signup")){
                    System.out.print("\033[H\033[2J");
                    lib.add_normalUser();
                }
                else if (Objects.equals(cmd, "lib login")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Login as Admin / Normal user (type admin or normal):");
                    System.out.print(">>>");
                    cmd = scn.nextLine();
                    if(Objects.equals(cmd, "admin") || Objects.equals(cmd,"Admin")){
                        lib.login_AdminUsers();
                    }
                    else{
                        lib.login_normalUsers();
                    }
                }
            }
        }
    }
}

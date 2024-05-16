import java.util.Scanner;

public class MyAPP {
    public static void main(String[] args) {
        System.out.println("Hello, welcome to merciful Aryaan library");
        Scanner scan = new Scanner(System.in);
        Book.copyFileOnBook();
        Admin.copyFileOnAdmin();
        NormalUsers.copyFileOnNormalUser();
        Cli cli =new Cli();
        lable:while (true) {
            String massage = cli.getMassage();
            if(massage.equals("exit")){
                break lable;
            }
            if(cli.massageCompile()){
                String answer;
                while (true) {
                    System.out.println("do you have an other command ? y/n ");
                    answer = scan.next();
                    if (answer.equals("y")) {
                        continue lable;
                    } else if (answer.equals("n")) {
                        break lable;
                    } else {
                        System.out.println("wrong command.");
                        continue ;
                    }
                }

            }
        }
        System.out.println("Thank you for choosing our Library Management System. We're excited to provide you with an efficient and user-friendly platform for all your library needs. Happy reading!\n");
        Book.copyBookOnFile();
        Admin.copyAdminOnFile();
        NormalUsers.copyNormalUserOnFile();
    }


}

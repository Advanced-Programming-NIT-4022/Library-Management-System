import java.util.Objects;
import java.util.Scanner;

public class Admin implements C {
    public Admin(){
    }





    public void Ad() {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the password: ");
        int i = 3;
        while(true) {
            String s = input.nextLine();
            if (Objects.equals(s, "abc123")) break;

            else{
                System.out.println("you entered wrong password!");}

        }
        try {
            System.out.println("please enter one option" + "\n" + "1-add new member" + "\n" + "2-remove member" + "\n" + "for choosing option you need to write something like this : (lib add member) ");
            String a = input.nextLine();
            if (Objects.equals(a, "lib remove member")) {
                System.out.println("please enter the member ID");
                String R = input.nextLine();
                remove_member(R);

            }
            if (Objects.equals(a, "lib add member")) {
                System.out.println("please enter the Student ID and Password");
                String P = input.nextLine();
                String S = input.nextLine();
                add_member(S, P);
            }
        }catch(Exception e) {
            System.out.println("Something went wrong");
        }



    }

    @Override
    public void add_book(String name, String author, String subtitle) {

    }

    @Override
    public void get_hrs() {

    }

    @Override
    public void rent(String book_name) {

    }

    @Override
    public void add_member(String std_id, String password) {
        while(true){
            Scanner input  = new Scanner(System.in);
            password = input.nextLine();
            if(Objects.equals(password, "abc123"))break;
            else System.out.println("password is wrong");
        }



    }

    @Override
    public void rent(String book_name, String member_name, String member_id) {

    }

    @Override
    public void available_book() {

    }

    @Override
    public void remove_member(String member_id) {

    }

    @Override
    public void return_book(String book_name) {

    }
}

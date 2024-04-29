import java.util.Objects;
import java.util.Scanner;

public class Admin implements C {


    public Admin() {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the password: ");
        int i = 3;
        while(true) {
            String s = input.nextLine();
            if (Objects.equals(s, "abc123")) {
                System.out.println("please enter one option" + "\n" + "add new member" + "remove member");
                String a = input.nextLine();
                if(Objects.equals(a, "lib remove member")){
                    System.out.println("please enter the member ID");
                    String R = input.nextLine();
                    remove_member(R);
                }
                if(Objects.equals(a, "lib add member")){
                    System.out.println("please enter the Student ID and Password");
                    String P = input.nextLine();
                    String S = input.nextLine();
                    add_member(S , P);
                }

            }
            else{
                if(i == 0 ) {
                    System.out.println("you entered wrong password!");
                    break;
                }
                System.out.println("wrong!!!");
                System.out.format("%d times left \n" , i);
                i--;

            }

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

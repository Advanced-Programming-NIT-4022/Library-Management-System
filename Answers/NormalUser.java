import jdk.management.jfr.FlightRecorderMXBean;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.matches;

public class NormalUser implements C {
    public String[]Name = new String[20];
    public String[]User_ID = new String[20];
    public String[]phone_number = new String[20];
    public NormalUser() {
    }

    public void sing() {
        System.out.println("Welcome to our library");
        System.out.println("for sign in please enter: 1" + "\n" + "for sign up please enter : 2");
        Scanner input = new Scanner(System.in);
        String AA = input.nextLine();
        while (true) {
            if (Objects.equals(AA, "1")) {
                Check();
                break;
            }
            if (Objects.equals(AA, "2"))
                signup();
            else {
                System.out.println("Wrong+");
                AA = input.nextLine();
            }
        }
    }

    public void signup() {
        String phone;
        Random random = new Random();
        System.out.println("please enter your name and phone number");
        Scanner input = new Scanner(System.in);
        System.out.println("name:");
        String name = input.nextLine();
        System.out.println("phone number:");
        phone = input.nextLine();
        while (true) {

            if (Pattern.matches("[0][0-9]{10}", phone)) {
                break;
            } else {
                System.out.println("wrong phone number please try again");
                phone = input.nextLine();
            }
        }

        int ID = random.nextInt(1000);
        String id = String.valueOf(ID);
        User user = new User();
        user.save(name, phone, id);
    }

    public void Check() {
        int o = 0;
        User user = new User();

        System.out.println("please enter your ID");
        Scanner input = new Scanner(System.in);
        String ID = input.nextLine();
                    while(true) {
                        for (int k = 1; k < User_ID.length; k++) {
                            if (Objects.equals(User_ID[k], ID)) {
                                o = 1;
                                System.out.format("name :%s \nID :%s \nphone number:%s\n", Name[k], User_ID[k], phone_number[k]);
                                break;
                            }
                        }
                        if(o==1)break;
                        else{
                            System.out.println("wrrrrrong");
                            ID = input.nextLine();
                        }
                    }


                    signin();


    }



    public void signin() {


            Scanner input = new Scanner(System.in);
            System.out.println("please enter one option" + "\n" + "1-add book" + "\n" + "2-get hrs" + "\n" + "3-rent" + "\n" + "4-Rent(for specific member) " + "\n" + "5-get available books" + "\n" + "6-return" + "\n" + "for choosing option you have to write something like this : (lib rent)");
            String A = input.nextLine();
        while (true) {


            if (Objects.equals(A, "lib add book")) {
                System.out.println("please enter name,author and subtitle");
                String N = input.nextLine();
                String Author = input.nextLine();
                String S = input.nextLine();
                add_book(N, Author, S);
            }
            if (Objects.equals(A, "lib get hrs")) {
                get_hrs();
            }
            if (Objects.equals(A, "lib rent")) {
                System.out.println("please enter the book_name");
                String BN = input.nextLine();
                rent(BN);
            }
            if (Objects.equals(A, "lib Rent")) {
                System.out.println("please enter the BookName,MemberName and MemberID");
                String BN = input.nextLine();
                String MN = input.nextLine();
                String MID = input.nextLine();
                rent(BN, MN, MID);
            }
            if (Objects.equals(A, "lib get available books")) {
                available_book();
            }
            if (Objects.equals(A, "lib return")) {
                System.out.println("please enter BookName");
                String BN = input.nextLine();
                return_book(BN);
            } else {
                System.out.println("wrong+++");
                A = input.nextLine();

            }
        }
        }



    @Override
    public void add_book(String name, String author, String subtitle) {

    }

    @Override
    public void get_hrs() {
        System.out.println("8AM - 5PM");
        System.out.println("\n");
        signin();

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

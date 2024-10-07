package myLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class user {
    public String strOrder() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    private String name="arian azami";
    private String studentId="40230112011";
    private String phoneNumber="09301579868";
   public user(){

    }
    public user(ArrayList<String> x) {

        if (x.get(0).equals("user")){
        System.out.print("your user name: ");
        this.name = strOrder();
        System.out.print("your user studentId: ");
        this.studentId = strOrder();
        System.out.print("your user phoneNumber: ");
        this.phoneNumber = strOrder();
        x.add(showName());
        x.add(showStudentId());
        x.add(showPhoneNumber());
        } else if (x.get(0).equals("admin")) {
            System.out.print("your Admin name: ");
            this.name = strOrder();
            System.out.print("your Admin studentId: ");
            this.studentId = strOrder();
            System.out.print("your Admin phoneNumber: ");
            this.phoneNumber = strOrder();
            x.add(showName());
            x.add(showStudentId());
            x.add(showPhoneNumber());
        }
    }
    ArrayList<String> x=new ArrayList<>();
   void setter(ArrayList<String> x){
       this.x=x;
   }
   ArrayList<String> givingData(){
       return this.x;
   }
    public String showName() {
        return this.name;
    }

    public String showStudentId() {
        return this.studentId;
    }

    public String showPhoneNumber() {
        return this.phoneNumber;
    }

    }


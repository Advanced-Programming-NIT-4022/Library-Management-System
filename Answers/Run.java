import java.time.LocalTime;
import java.util.Scanner;

public class Run {
    Book bk=new Book();
    CLI tab=new CLI();
    Normaluser u=new Normaluser();
    Admin ad=new Admin();
    Library bc=new Library();
    Rent rt=new Rent();
    LocalTime t=LocalTime.now();
    LocalTime t1=LocalTime.of(9,00,00);
    LocalTime t2=LocalTime.of(23,00,00);
    public void runner() {
        Scanner sc=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        if (t.isAfter(t1) && t.isBefore(t2)) {
            u.makeaccount("Aran Rafiaei","40230212043");
            ad.addAdmin("Aran Rafiaei","40230212043");
            tab.libaddbook("binavayan","Victor Hogo","ketab dar morede chand binavast.");
            tab.libaddbook("bishoori","Xavier Crement","ye ketab dar morede bishoori.");
            tab.libaddbook("nooshirvani kojast","nashenas","addresse nooshivani be zaban haye mokhtalef.");
            System.out.println("Welcome to Nooshirvani library! choose the number of one of options below.");
            System.out.println("1.Yes");
            System.out.println("2.No"+"\n");
            System.out.print("Are you Admin: ");
            String name="";
            for (;;) {
                String yn=sc.nextLine();
                boolean l=false;
                switch (yn) {
                    case "1":
                        System.out.print("enter the password: ");
                        for (;;) {
                            String pass=sc.nextLine();
                            if (ad.adminsave.containsValue(pass)) {
                                name="Aran Rafiaei";
                                break;
                            } else {
                                System.out.print("admin not found!try another password: ");
                            }
                        }
                        l=true;
                        break;
                    case "2":
                        System.out.println("you must make account.first, enter your name below.");
                        System.out.print("my name is: ");
                        for (;;) {
                            name=sc.nextLine();
                            if (u.mempasssave.containsKey(name)==false) {
                                break;
                            } else {
                                System.out.print("your name must be unique.try another: ");
                            }
                        }
                        System.out.print("enter a password: ");
                        String pasw;
                        while (true) {
                            pasw=sc2.nextLine();
                            if (u.mempasssave.containsValue(pasw)) {
                                System.out.print("this password is not unique: ");
                            } else {
                                break;
                            }
                        }
                        u.makeaccount(name,pasw);
                        l=true;
                        System.out.println("now you have an account.");
                        break;
                    default:
                        System.out.print("wrong option.try again: ");
                        break;
                }
                if (l==true) {
                    break;
                }
            }
            System.out.println("here they are our options of library.choose the number of one of them.");
            boolean m=true;
            for (;;) {
                if (m) {
                    System.out.println("1.add a book");
                    System.out.println("2.get work hours");
                    System.out.println("3.rent a book");
                    System.out.println("4.add a member (admins only)");
                    System.out.println("5.rent a book for a member");
                    System.out.println("6.see available books");
                    System.out.println("7.remove a member (admins only)");
                    System.out.println("8.return a book");
                    System.out.println("9.exit");
                    System.out.print("I choose: ");
                }
                boolean kh=false;
                String op=sc.nextLine();
                switch (op) {
                    case "1":
                        m=true;
                        System.out.print("enter book name: ");
                        String bname=sc.nextLine();
                        System.out.print("enter the author: ");
                        String nv=sc.nextLine();
                        System.out.print("what is the book about: ");
                        String caption=sc2.nextLine();
                        tab.libaddbook(bname,nv,caption);
                        if (!(bc.bookesm.contains(bname) && bk.writerdooni.containsValue(nv) && bk.subdooni.containsValue(caption))) {
                            System.out.println("book added.");
                        }
                        break;
                    case "2":
                        m=true;
                        tab.libgethrs();
                        break;
                    case "3":
                        m=true;
                        System.out.print("enter the name of the book: ");
                        String boname=sc.nextLine();
                        tab.librent(boname,name);
                        break;
                    case "4":
                        m=true;
                        System.out.print("enter the admin password: ");
                        String adminpass=sc.nextLine();
                        if (ad.adminsave.containsValue(adminpass)==false) {
                            System.out.println("seems like you are not admin.");
                            break;
                        }
                        System.out.print("enter a name: ");
                        String mname= sc.nextLine();
                        System.out.print("enter a password: ");
                        String mpass=sc2.nextLine();
                        boolean a=false;
                        if (u.mempasssave.containsKey(mname)==false && u.mempasssave.containsValue(mpass)==false) {
                            a=true;
                        }
                        tab.libaddmember(mname,mpass);
                        if (a) {
                            System.out.println("would you like to consider your member as admin?");
                            System.out.print("enter yes\\no: ");
                            for (;;) {
                                String ans = sc2.nextLine();
                                boolean b = false;
                                switch (ans) {
                                    case "yes":
                                        ad.addAdmin(mname, mpass);
                                        System.out.println("admin added!");
                                        b = true;
                                        break;
                                    case "no":
                                        b = true;
                                        break;
                                    default:
                                        System.out.print("you must enter \"yes\" or \"no\": ");
                                        break;
                                }
                                if (b == true) {
                                    break;
                                }
                            }
                        }
                        break;
                    case "5":
                        m=true;
                        System.out.print("enter the name: ");
                        String mename=sc.nextLine();
                        System.out.print("enter the name of the book: ");
                        String bn=sc.nextLine();
                        tab.librentforamember(bn,mename);
                        break;
                    case "6":
                        m=true;
                        tab.libgetavailablebooks();
                        break;
                    case "7":
                        m=true;
                        System.out.print("enter the admin password: ");
                        String pw=sc.nextLine();
                        if (ad.adminsave.containsValue(pw)==false) {
                            System.out.println("seems like you are not admin.");
                            break;
                        }
                        System.out.print("enter the name of member: ");
                        String rm=sc.nextLine();
                        tab.libremovemember(rm);
                        break;
                    case "8":
                        m=true;
                        System.out.print("enter the name of the book: ");
                        String rbn=sc.nextLine();
                        tab.libreturn(rbn);
                        break;
                    case "9":
                        kh=true;
                        break;
                    default:
                        m=false;
                        System.out.print("wrong option.try again: ");
                        break;
                }
                if (kh) {
                    System.out.print("see you later.");
                    break;
                }
                if (m) {
                    System.out.println("anything else?");
                }
            }
        } else {
            System.out.println("Sorry,we are closed!");
        }
    }
}
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Commands extends Library {
    Book book = new Book();
    Rent rent = new Rent();
    int registered_adminID = 1001;
    int registered_userID = 2000;
    int registered_bookID = 3000;
    User user = new User();
    Admin admin = new Admin();
    ArrayList<Integer> deleted_userID = new ArrayList<>();
    ArrayList<Integer> deleted_adminID = new ArrayList<>();
    public String getStr() {
        Scanner sc = new Scanner(System.in);
        String str = "";
        try {
            str = sc.nextLine();
        }catch (Exception e) {
            System.out.println("Error : illegal entry , please try again.");
        }
        return str;
    }
    public int getInt() {
        Scanner sc = new Scanner(System.in);
        int id = 0;
        try {
            id = sc.nextInt();
        }catch (Exception e) {
            System.out.println("Error : illegal entry , please try again.");
        }
        return id;
    }
    public int getKey(String value , HashMap<Integer,String> map) {
        int ID = 0;
        for (int i : map.keySet()) {
            if (value.equals(map.get(i))) {
                ID = i;
            }
        }
        return ID;
    }
    public void hello() {
        System.out.println("Welcome to our Library Management System.");
        System.out.println("Do you wish to sign up or sign in?");
        System.out.println("a)sign up as normal user    b)sign in as normal user");
        System.out.println("c)sign in as admin          d)quit");
    }
    public int sign_up_normal_user() {
        String name = "";
        String phone = "";
        do {
            System.out.println("Please enter your name :");
            name = getStr();
            System.out.println("Please enter your phone number :");
            phone = getStr();
        }while(name.isEmpty() || phone.isEmpty() || user.userID_NameList.containsValue(name) || user.userID_PhoneNum.containsValue(phone));
        int newID;
        if(deleted_userID.isEmpty()) {
            newID = registered_userID;
            registered_userID++;
        }else{
            newID = deleted_userID.get(0);
            deleted_userID.remove(0);
        }
        user.userID_NameList.put(newID,name);
        user.userID_PhoneNum.put(newID,phone);
        user.userID_date.put(newID, LocalDateTime.now());
        System.out.println("You have signed up successfully");
        System.out.println("ID | Name | Phone number | Date");
        System.out.println(newID + " | " + user.userID_NameList.get(newID) + " | " + user.userID_PhoneNum.get(newID) + " | " + user.userID_date.get(newID));
        return newID;
    }
    public void sign_up_admin() {
        String name = "";
        String phone = "";
        do {
            System.out.println("Please enter your name :");
            name = getStr();
            System.out.println("Please enter your phone number :");
            phone = getStr();
        } while (name.isEmpty() || phone.isEmpty());
        int newID;
        if (deleted_adminID.isEmpty()) {
            newID = ++registered_adminID;
        } else {
            newID = deleted_adminID.get(0);
            deleted_adminID.remove(0);
        }
        System.out.println("Please enter a custom password ;");
        String password = "";
        do {
            password = getStr();
        } while (password.isEmpty());
        admin.setAdminID_password(newID, password);
        System.out.println("Password registered successfully.");
        admin.userID_NameList.put(newID, name);
        admin.userID_PhoneNum.put(newID, phone);
        admin.userID_date.put(newID, LocalDateTime.now());
        System.out.println("You have signed up successfully");
        System.out.println("You have signed up successfully");
        System.out.println("ID | Name | Phone number | Date");
        System.out.println(newID + " | " + admin.userID_NameList.get(newID) + " | " + admin.userID_PhoneNum.get(newID) + " | " + admin.userID_date.get(newID));
    }
        public void change_password ( int id){
            System.out.println("Please enter your new password");
            String password = "";
            do {
                password = getStr();
            } while (password.isEmpty());
            admin.setAdminID_password(id, password);
        }
        public int sign_in_normal_user () {
            String answear = "";
            System.out.println("(a)sign in via name and phone number\t(b)sign in via user ID");
            do {
                answear = getStr();
            } while (!answear.equals("a") && !answear.equals("b"));
            String name = "";
            String phone = "";
            int id = 2;
            switch (answear) {
                case "a":
                    do {
                        do {
                            System.out.println("Please enter your name :");
                            name = getStr();
                            System.out.println("Please enter your phone number :");
                            phone = getStr();
                        } while (!user.userID_NameList.containsValue(name) || !user.userID_PhoneNum.containsValue(phone));
                        if (getKey(phone, user.userID_PhoneNum) != getKey(name, user.userID_NameList)) {
                            System.out.println("Name and phone number don't match.");
                        }
                    } while (getKey(phone, user.userID_PhoneNum) != getKey(name, user.userID_NameList));
                    id = getKey(phone, user.userID_PhoneNum);
                    break;
                case "b":
                    do {
                        System.out.println("Please enter your ID :");
                        id = getInt();
                    } while (id == 0 || !user.userID_NameList.containsKey(id));
                    break;
            }
            System.out.println("You signed in successfully.");
            System.out.println("You have signed up successfully");
            System.out.println("ID | Name | Phone number | Date");
            System.out.println(id + " | " + user.userID_NameList.get(id) + " | " + user.userID_PhoneNum.get(id) + " | " + user.userID_date.get(id));
            return id;
        }
        public void view_Users () {
            System.out.println("Users :");
            System.out.println("Name | phone number | date");
            System.out.println("--------------------------");
            for (int id : user.userID_NameList.keySet()) {
                System.out.println(user.userID_NameList.get(id) + " | " + user.userID_PhoneNum.get(id) + " | " + user.userID_date.get(id));
                System.out.println("--------------------------");
            }
        }
        public void view_Admins () {
            System.out.println("Admins :");
            System.out.println("Name | phone number | date");
            System.out.println("--------------------------");
            for (int id : admin.userID_NameList.keySet()) {
                System.out.println(admin.userID_NameList.get(id) + " | " + admin.userID_PhoneNum.get(id) + " | " + admin.userID_date.get(id));
                System.out.println("--------------------------");
            }
        }
        public void deleteNormalUser ( int userID){
            deleted_userID.add(userID);
            user.userID_NameList.remove(userID);
            user.userID_PhoneNum.remove(userID);
            user.userID_date.remove(userID);
            System.out.println("User " + userID + "was removed.");
        }
        public void deleteAdminlUser ( int userID){
            if (userID != 1000) {
                deleted_userID.add(userID);
                deleted_adminID.add(userID);
                admin.userID_NameList.remove(userID);
                admin.userID_PhoneNum.remove(userID);
                admin.userID_date.remove(userID);
                admin.delete_password(userID);
                System.out.println("Admin " + userID + "was removed.");
            }
        }
        public int enter () {
            admin.userID_NameList.put(1000, "Boss");
            admin.userID_PhoneNum.put(1000, "09111111111");
            admin.userID_date.put(1000, LocalDateTime.now());
            admin.firstPassword();
            Scanner sc = new Scanner(System.in);
            int currentID = 0;
            hello();
            String answear = "";
            do {
                try {
                    answear = sc.nextLine();
                } catch (Exception e) {
                    System.out.println("Please enter your choice correctly.");
                }
            } while (!answear.equals("a") && !answear.equals("b") && !answear.equals("c") && !answear.equals("d"));
            switch (answear) {
                case "a":
                    currentID = sign_up_normal_user();
                    break;
                case "b":
                    currentID = sign_in_normal_user();
                    break;
                case "c":
                    currentID = admin.sign_in_admin();
                    break;
                case "d":
                    currentID = -1;
                    break;
            }
            return currentID;
        }
        public void normalUserClearance ( int currentID){
            boolean stay = true;
            do {
                System.out.println("You have normal user clearance.");
                System.out.println("You can choose one of the commands below :");
                System.out.println("(1) add a new book to the library.");
                System.out.println("(2) view the operating hours of the library.");
                System.out.println("(3) rent a book.");
                System.out.println("(4) rent a book for another member.");
                System.out.println("(5) view available books.");
                System.out.println("(6) return a book.");
                System.out.println("(7) delete your account.");
                System.out.println("(8) quit.");
                Scanner sc = new Scanner(System.in);
                int answear = 0;
                System.out.println("Enter your number here :");
                do {
                    try {
                        answear = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter one of the numbers above :");
                    }
                } while (answear <= 0 || answear >= 9);
                switch (answear) {
                    case 1:
                        book.add_book(registered_bookID);
                        registered_bookID++;
                        break;
                    case 2:
                        showHours();
                        break;
                    case 3:
                        rent.rent(currentID);
                        break;
                    case 4:
                        String bookname = "";
                        do {
                            System.out.println("Please enter the name of the book :");
                            bookname = getStr();
                        } while (bookname.isEmpty());
                        rent.rentForSb(bookname);
                        break;
                    case 5:
                        book.viewAvailableBooks();
                        break;
                    case 6:
                        rent.returnBook(currentID);
                        break;
                    case 7:
                        deleteNormalUser(currentID);
                        stay = false;
                        break;
                    case 8:
                        stay = false;
                        break;
                }
            } while (stay);
        }
        public void adminUserClearance ( int currentID){
            boolean stay = true;
            do {
                System.out.println("You have normal user clearance.");
                System.out.println("You can choose one of the commands below :");
                System.out.println("(1) add a new book to the library.");
                System.out.println("(2) remove a book from the library.");
                System.out.println("(3) set library name.");
                System.out.println("(4) view library name.");
                System.out.println("(5) set library capacity.");
                System.out.println("(6) view library capacity.");
                System.out.println("(7) set operating hours.");
                System.out.println("(8) view operating hours.");
                System.out.println("(9) view rental history.");
                System.out.println("(10) view books.");
                System.out.println("(11) view users.");
                System.out.println("(12) view admins.");
                System.out.println("(13) add admin.");
                System.out.println("(14) delete admin.");
                System.out.println("(15) delete normal user.");
                System.out.println("(16) delete your account.");
                System.out.println("(17) quit.");
                Scanner sc = new Scanner(System.in);
                int answear = 0;
                System.out.println("Enter your number here :");
                do {
                    try {
                        answear = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter one of the numbers above :");
                    }
                } while (answear <= 0 || answear >= 18);
                switch (answear) {
                    case 1:
                        book.add_book(registered_bookID);
                        registered_bookID++;
                        break;
                    case 2:
                        book.remove_book();
                        break;
                    case 3:
                        setLibraryName();
                        break;
                    case 4:
                        showLibraryName();
                        break;
                    case 5:
                        setCapacity();
                        break;
                    case 6:
                        showCapacity();
                        break;
                    case 7:
                        setOperatingHours();
                        break;
                    case 8:
                        showHours();
                        break;
                    case 9:
                        show_rental_history();
                        break;
                    case 10:
                        book.viewBooks();
                        break;
                    case 11:
                        view_Users();
                        break;
                    case 12:
                        view_Admins();
                        break;
                    case 13:
                        sign_up_admin();
                        break;
                    case 14:
                        int id = 0;
                        do {
                            System.out.println("Please enter the ID you want removed :");
                            id = getInt();
                        } while (id == 0 || !admin.userID_NameList.containsKey(id) || currentID == id);
                        deleteAdminlUser(id);
                        break;
                    case 15:
                        id = 0;
                        do {
                            System.out.println("Please enter the ID you want removed :");
                            id = getInt();
                        } while (id == 0 || !user.userID_NameList.containsKey(id));
                        deleteNormalUser(id);
                        break;
                    case 16:
                        deleteAdminlUser(currentID);
                        stay = false;
                        break;
                    case 17:
                        stay = false;
                        break;
                }
            } while (stay);
        }
}

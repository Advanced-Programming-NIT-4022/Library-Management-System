package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Admin extends User{
    private String password;
    public Admin(String name, int uniqueID, char[] phone, String password) {
        super(name, uniqueID, phone);
        this.password = password;
    }
    public Admin() {
        super();
        this.password = null;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() { return password; }

    public void removeBook(ArrayList<Book> booksList, String title) {
        for (int i = 0; i < booksList.size(); i++) {
            if (title.equals(booksList.get(i))) {
                booksList.remove(i);
                break;
            }
        }
    }
    public void addNewUser(String[] cm) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        boolean flag = true;
        do {
            flag = true;
            for (int i = 0; i < lib.getUserList().size(); i++) {
                if (cm[3].equalsIgnoreCase(Integer.toString(lib.getUserList().get(i).getUniqueID()))) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                System.out.println("This ID already exists. Enter another one. ");
                cm[3] = sc.nextLine();
            }
        } while(!flag);

        System.out.println("Enter their name: ");
        String name = sc.nextLine();
        flag = true;
        char[] phone = null;
        do {
            System.out.println("Enter their phone number: ");
            String input = sc.nextLine();
            char[] tmp = input.toCharArray();
            for (char i : tmp) {
                int ascii = (int) i;
                if (ascii < 48 || ascii > 57) {
                    System.out.println("Invalid number. Try again.");
                    flag = false;
                    break;
                }
                else {
                    flag = true;
                    phone = tmp;
                }
            }
        } while (!flag);

        int date = 2;
        NormalUser newUser = new NormalUser(name, Integer.valueOf(cm[3]), phone, date);
        lib.getUserList().add(newUser);
    }
    public boolean removeMember(int id) {
        Library lib = new Library();
        boolean result = false;
        for (int i = 0; i < lib.getUserList().size(); i++) {
            if (id == lib.getUserList().get(i).getUniqueID()) {
                lib.getUserList().remove(i);
                result = true;
                return result;
            }
        }
        return result;
    }
    public void addNewAdmin(){
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        String name;
        boolean flag = true;
        do {
            flag = false;
            System.out.println("Enter the name of the user: ");
            name = sc.nextLine();
            boolean user_found = false;
            for (NormalUser i : lib.getUserList()) {
                if (i.getName().equals(name)) {
                    flag = true;
                    user_found = true;
                    break;
                }
            }
            if (user_found)
                System.out.println("No user found. Try again.");
        } while (!flag);

        System.out.println("Enter a password for them: ");
        String password = sc.nextLine();

        flag = true;
        int uniqueID = 0;
        do {
            Random id = new Random();
            int tmpID = id.nextInt(9000) + 1000;

            flag = true;

            for(NormalUser i : lib.getUserList()) {
                if (i.getUniqueID() == tmpID) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                uniqueID = tmpID; // Update uniqueID only if ID is unique
            }
        } while(!flag);

//        lib.getAdminList().add()
    }
}

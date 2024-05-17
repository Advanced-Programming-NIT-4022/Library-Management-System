package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Library {
    private final String operatingHours = "From 8 A.M. to 6 P.M.";
    private ArrayList<Book> booksList = new ArrayList<>();
    private ArrayList<NormalUser> userList = new ArrayList<>();
    private ArrayList<Admin> adminList = new ArrayList<>();

    public void addBookElement(Book obj) {
        booksList.add(obj);
    }
    public void addUserElement(NormalUser obj) {
        userList.add(obj);
    }
    public void addAdminElement(Admin obj) { adminList.add(obj); }

    public Library() {
        Admin owner = new Admin("Mahta", 1234, "09036339284".toCharArray(), "1234");
        adminList.add(owner);
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    public ArrayList<NormalUser> getUserList() {
        return userList;
    }

    public ArrayList<Admin> getAdminList() {
        return adminList;
    }

    public void signup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        boolean flag = true;
        char[] phone = null;
        do {
            System.out.println("Enter your phone: ");
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

        flag = true;
        int uniqueID = 0;
        do {
            Random id = new Random();
            int tmpID = id.nextInt(9000) + 1000;

            flag = true;

            for(NormalUser i : userList) {
                if (i.getUniqueID() == tmpID) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                uniqueID = tmpID; // Update uniqueID only if ID is unique
            }
        } while(!flag);
        System.out.println("\n\n\t\tWelcome " + name + "! Here is your unique ID: " + uniqueID);
        System.out.println("\n\nThank you for choosing our Library Management System." +
                "\nWe're excited to provide you with an efficient and user-friendly platform for all your library needs." +
                "\nHappy reading!");
        int date = 1;
        NormalUser newUser = new NormalUser(name, uniqueID, phone, date);
        userList.add(newUser);
    }
    public String login(boolean isUser) {
        System.out.println("Welcome back! Enter your name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String password;

        boolean flag = true;
        if (isUser) {
            do {
                System.out.println("Enter your unique ID: ");
                int uniqueID = sc.nextInt();
                flag = false;

                for(NormalUser i : userList) {
                    if (i.getUniqueID() == uniqueID) {
                        if (i.getName().equalsIgnoreCase(name)) {
                            flag = true;
                            break;
                        }
                    }
                }

                if (!flag) {
                    System.out.println("Invalid ID; Try again. ");
                }
            } while(!flag);

        }
        else {
            do {
                System.out.println("Enter your unique ID: ");
                int uniqueID = sc.nextInt();
                flag = false;

                for(Admin i : adminList) {
                    if (i.getUniqueID() == uniqueID) {
                        if (i.getName().equalsIgnoreCase(name)) {
                            flag = true;
                            break;
                        }
                    }
                }

                if (!flag) {
                    System.out.println("Invalid ID; Try again. ");
                }
            } while(!flag);

            do {
                System.out.println("Enter your password: ");
                password = sc.nextLine();
                flag = false;

                for(Admin i : adminList) {
                    if (i.getPassword().equals(password)) {
                            flag = true;
                            return password;
                    }
                }

                if (!flag) {
                    System.out.println("Invalid password; Try again. ");
                }
            } while(!flag);
        }
        return null;

    }

    public void homePage() {
        System.out.println("Welcome to our library! Please sign up or log in.");
        System.out.println("1- Sign Up\t\t\t2- Log In");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        boolean isUser = true;
        switch(choice) {
            case 1:
                signup();
                break;
            case 2:
                System.out.println("Choose your position.\n1- User\t\t\t2- Admin");
                int pos = sc.nextInt();
                isUser = true;
                switch(pos) {
                    case 1:
                        login(isUser);
                        break;
                    case 2:
                        isUser = false;
                        login(isUser);
                        break;
                }
        }

        User u = new User();
        Book b = new Book();
        Admin a = new Admin();
        boolean flag = true;
        outerLoop:
        do {
            flag = true;
            System.out.println("\nWhat do you want to do?");
            Scanner scs = new Scanner(System.in);
            String command = scs.nextLine();
            String[] cm = command.split(" ");
            if (cm[0].equalsIgnoreCase("lib")) {
                if (cm[1].equalsIgnoreCase("add")) {
                    if (cm[2].equalsIgnoreCase("book")) {
                        if (cm.length == 6) {
                            boolean retry = u.addBook(cm);
                            if (retry) {
                                flag = false;
                            } else
                                break outerLoop;
                        } else {
                            System.out.println("Invalid command. What do you want to do?" +
                                    "\n1- Try another command\t\t\t2- Exit");
                            choice = sc.nextInt();
                            if (choice == 1) {
                                flag = false;
                            } else {
                                break outerLoop;
                            }
                        }
                    } else if (cm[2].equalsIgnoreCase("member")) {
                        if (!isUser) {
                            if (cm.length == 5) {
                                a.addNewUser(cm);
                                System.out.println("Member successfully added. What do you want to do next?" +
                                        "\n1- Try another command\t\t\t2- Exit");
                                choice = sc.nextInt();
                                if (choice == 1) {
                                    flag = false;
                                } else {
                                    break outerLoop;
                                }
                            } else {
                                System.out.println("Invalid command. What do you want to do?" +
                                        "\n1- Try another command\t\t\t2- Exit");
                                choice = sc.nextInt();
                                if (choice == 1) {
                                    flag = false;
                                } else {
                                    break outerLoop;
                                }
                            }
                        } else {
                            System.out.println("Only admins can do this. What do you want to do?" +
                                    "\n1- Try another command\t\t\t2- Exit");
                            choice = sc.nextInt();
                            if (choice == 1) {
                                flag = false;
                            } else {
                                break outerLoop;
                            }
                        }
                    } else {
                        System.out.println("Invalid command. What do you want to do?" +
                                "\n1- Try another command\t\t\t2- Exit");
                        choice = sc.nextInt();
                        if (choice == 1) {
                            flag = false;
                        } else {
                            break outerLoop;
                        }
                    }
                }
                else if (cm[1].equalsIgnoreCase("get")) {
                    if (cm[2].equalsIgnoreCase("hrs")) {
                        System.out.println(operatingHours);
                        flag = false;
                    } else if (cm[2].equalsIgnoreCase("available")) {
                        if (cm[3].equalsIgnoreCase("books")) {
                            for (Book l : getBooksList()) {
                                for (int k = 0; k < booksList.size(); k++) {
                                    System.out.println("bookID\t\ttitle\t\tauthor");
                                    System.out.println(getBooksList().get(k).getBookID() +
                                                        "\t\t\t" + getBooksList().get(k).getTitle() +
                                                        "\t\t\t" + getBooksList().get(k).getAuthor());
                                    System.out.println("\nWhat do you want to do next?" +
                                            "\n1- Try another command\t\t\t2- Exit");
                                    choice = sc.nextInt();
                                    if (choice == 1) {
                                        flag = false;
                                    } else {
                                        break outerLoop;
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid command. What do you want to do?" +
                                "\n1- Try another command\t\t\t2- Exit");
                        choice = sc.nextInt();
                        if (choice == 1) {
                            flag = false;
                        } else {
                            break outerLoop;
                        }
                    }
                }
                else if (cm[1].equalsIgnoreCase("rent")) {

                }
                else if (cm[1].equalsIgnoreCase("remove")) {
                    if (!isUser) {
                        if (cm.length == 4) {
                            if (cm[2].equalsIgnoreCase("member")) {
                                int id = Integer.valueOf(cm[3]);
                                boolean result = a.removeMember(id);
                                if(result) {
                                    System.out.println("Member successfully removed. What do you want to do?" +
                                            "\n1- Try another command\t\t\t2- Exit");
                                    choice = sc.nextInt();
                                    if (choice == 1) {
                                        flag = false;
                                    } else {
                                        break outerLoop;
                                    }
                                }
                                else {
                                    System.out.println("No member found. What do you want to do?" +
                                            "\n1- Try another command\t\t\t2- Exit");
                                    choice = sc.nextInt();
                                    if (choice == 1) {
                                        flag = false;
                                    } else {
                                        break outerLoop;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Invalid command. What do you want to do?" +
                                    "\n1- Try another command\t\t\t2- Exit");
                            choice = sc.nextInt();
                            if (choice == 1) {
                                flag = false;
                            } else {
                                break outerLoop;
                            }
                        }
                    }
                    else {
                        System.out.println("Only admins can do this. What do you want to do?" +
                                "\n1- Try another command\t\t\t2- Exit");
                        choice = sc.nextInt();
                        if (choice == 1) {
                            flag = false;
                        } else {
                            break outerLoop;
                        }
                    }
                }
                else {
                    System.out.println("Invalid command. What do you want to do?" +
                            "\n1- Try another command\t\t\t2- Exit");
                    choice = sc.nextInt();
                    if (choice == 1) {
                        flag = false;
                    } else {
                        break outerLoop;
                    }
                }
            }
            else {
                System.out.println("Invalid command. What do you want to do?" +
                        "\n1- Try another command\t\t\t2- Exit");
                choice = sc.nextInt();
                if (choice == 1) {
                    flag = false;
                } else {
                    break outerLoop;
                }
            }
        } while(!flag);

        System.out.println("Goodbye!!");
    }
}

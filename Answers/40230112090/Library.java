
package org.example;

import java.time.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library {
    public Library() {
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        NormalUsers normalUsers = new NormalUsers();
        Book book = new Book();
        Rent rent = new Rent();
        String idInMysql = "SELECT id FROM normal_users WHERE username = ? AND password = ?";
        String updateIdInMysql = "UPDATE normal_users SET password = ? WHERE username = ? AND phoneNumber = ?";
        String idOfAdminInMysql = "SELECT id FROM admins WHERE adminName = ? AND adminPassword = ?";
        String updateOfAdminInMysql = "UPDATE admin SET adminPassword = ? WHERE adminName = ? AND phoneNumber = ?";
        LocalTime localTime = LocalTime.now();
        int hoursOfWork = localTime.getHour();
        int capacity = 0, number = 0;
        if (hoursOfWork > 9 && hoursOfWork < 17) {
            String name;
            String password;
            System.out.println("            Hell, you are very welcome!!");

            while (true) {
                System.out.println("Please enter your name and password :");
                System.out.print("Name : ");
                name = input.nextLine();
                System.out.print("Password : ");
                password = input.nextLine();

                if (normalUsers.getPassword(name, password, idOfAdminInMysql, updateOfAdminInMysql).equals("success")) {
                    if (capacity < 50) {
                        while (true) {
                            System.out.println("           >>>Admin section<<<");
                            System.out.print("""
                                    1-lib add book <title> <author> <description>
                                    2-lib remove book <title> <author>
                                    3-lib add user <username> <phoneNumber> <password>
                                    4-lib remove user <username> <phoneNumber>
                                    5-lib add admin <adminName> <phoneNumber> <password>
                                    6-lib remove admin <adminName> <phoneNumber>
                                    7-lib increase capacity <number>
                                    8-lib capacity reduction <number>
                                    7-lib <exit>
                                    Please enter the desired word :
                                    """);
                            String word = (input.nextLine()).toLowerCase();
                            Pattern input1 = Pattern.compile("^lib\\s+(rent|return)\\s+<([a-z\\s]+|\\d{2})>\\s+<([a-z\\s]+|\\d{10})>\\s+<([a-z\\s]+|\\d{4,9})>$");
                            Matcher input11 = input1.matcher(word);
                            String firstValue = "";
                            String secondValue = "";
                            String thirdValue = "";
                            if (input11.matches()) {
                                firstValue = input11.group(2);
                                secondValue = input11.group(3);
                                thirdValue = input11.group(4);
                            }
                            if (word.equals("lib add book <" + firstValue + "> <" + secondValue + "> <" + thirdValue + ">")) {
                                firstValue = book.title(firstValue);
                                secondValue = book.title(secondValue);
                                thirdValue = book.title(thirdValue);
                                admin.addBook(firstValue, secondValue, thirdValue);
                            }
                            if (word.equals("lib remove book <" + firstValue + "> <" + secondValue + ">")) {
                                firstValue = book.title(firstValue);
                                secondValue = book.title(secondValue);
                                admin.removeBook(firstValue, secondValue);
                            }
                            if (word.equals("lib add user <" + firstValue + "> <" + secondValue + "> <" + thirdValue + ">")) {
                                firstValue = book.title(firstValue);
                                secondValue = "+98" + secondValue;
                                admin.addUser(firstValue, secondValue, thirdValue, number, capacity);
                                number++;
                            }
                            if (word.equals("lib remove user <" + firstValue + "> <" + secondValue + ">")) {
                                firstValue = book.title(firstValue);
                                secondValue = "+98" + secondValue;
                                admin.removeUser(firstValue, secondValue);
                            }
                            if (word.equals("lib add admin <" + firstValue + "> <" + secondValue + "> <" + thirdValue + ">")) {
                                firstValue = book.title(firstValue);
                                secondValue = "+98" + secondValue;
                                admin.addAdmin(firstValue, thirdValue, secondValue);
                            }
                            if (word.equals("lib remove admin <" + firstValue + "> <" + secondValue + ">")) {
                                firstValue = book.title(firstValue);
                                secondValue = "+98" + secondValue;
                                admin.removeAdmin(firstValue, secondValue);
                            }
                            if (word.equals("lib <" + firstValue + ">")) {
                                break;
                            }
                            if (word.equals("lib increase capacity <" + firstValue + ">")) {
                                capacity = capacity + Integer.parseInt(firstValue);
                            }
                            if (word.equals("lib capacity reduction <" + firstValue + ">")) {
                                int amount = capacity - number;
                                if (capacity - Integer.parseInt(firstValue) < number) {
                                    System.out.println("You can't reduce the capacity of the library by " + firstValue + " people because the gap between the number of people who have registered and the capacity of the library is " + amount + " people");
                                } else {
                                    capacity = capacity - Integer.parseInt(firstValue);
                                }
                            }
                        }
                    } else {
                        System.out.println();
                    }
                }

                if (normalUsers.getPassword(name, password, idInMysql, updateIdInMysql).equals("success")) {

                    while (true) {
                        System.out.println("           >>>User section<<<");
                        System.out.print("""
                                Guide:
                                1-lib get available books
                                2-lib rent <bookName> <author>
                                3-lib rent <bookName> <author> <memberName> <memberPassword> a specific member.
                                3-lib return <bookName> <author>
                                5-lib my books
                                6-lib <exit>
                                Please enter the desired word :
                                """);
                        String word = (input.nextLine()).toLowerCase();
                        Pattern input1 = Pattern.compile("^lib\\s+(rent|return)\\s+<([a-z\\s]+)>\\s+<([a-z\\s]+)>\\s+<([a-z\\s]+)>\\s+<(\\d{4,9})>$");
                        Matcher input11 = input1.matcher(word);
                        String firstValue = "";
                        String secondValue = "";
                        String thirdValue = "";
                        String fourthValue = "";
                        if (input11.matches()) {
                            firstValue = input11.group(2);
                            secondValue = input11.group(3);
                            thirdValue = input11.group(4);
                            fourthValue = String.valueOf(input11.group(5));

                        }

                        if (word.equals("lib get available books")) {
                            book.viewAvailableBooks();
                        }
                        if (word.equals("lib rent <" + firstValue + "> <" + secondValue + ">")) {
                            firstValue = book.title(firstValue);
                            secondValue = book.title(secondValue);
                            rent.rentBook(firstValue, secondValue);

                        }
                        if (word.equals("lib rent <" + firstValue + "> <" + secondValue + "> <" + thirdValue + "> <" + fourthValue + ">")) {
                            firstValue = book.title(firstValue);
                            secondValue = book.title(secondValue);
                            thirdValue = book.title(thirdValue);
                            fourthValue = book.title(fourthValue);
                            rent.rentBookForSpecialMember(firstValue, secondValue, thirdValue, fourthValue);
                        }
                        if (word.equals(" return <" + firstValue + "> <" + secondValue + ">")) {
                            firstValue = book.title(firstValue);
                            secondValue = book.title(secondValue);
                            rent.returnBook(firstValue, secondValue);
                        }

                        if (word.equals("lib my books")) {
                            rent.rentedOfBook();
                        }
                        if (word.equals("lib <" + firstValue + ">")) {
                            break;
                        }
                    }
                }

            }
        } else {
            System.out.println("I apologize,but the working hours of the library are from 9 am to 5 pm.Please visit the library tomorrow.");
        }
    }
}



package org.example;
import java.time.LocalDate;

public class Rent {
    private static int firstId = 1;
    private static String bookname;
    private static String normalUsername;
    private static String RentalId;
    private static LocalDate RentalDate;

    static String idgenerator() {
        String ID = "Rental Id is " + firstId;
        firstId += firstId;
        return (ID);
    }

    public Rent(String bookname, String normalUsername,String RentalId){
        this.bookname = bookname;
        this.normalUsername = normalUsername;
        this.RentalId = idgenerator();
        }

    public static String getBookname(){
        return bookname;
    }
    public static String getNormalUsername(){
        return normalUsername;
    }
    public static String getRentalId(){
        return RentalId;
    }
    public static LocalDate getRentalDate(){
        return RentalDate;
    }

}
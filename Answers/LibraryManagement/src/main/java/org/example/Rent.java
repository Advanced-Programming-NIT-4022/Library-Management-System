package org.example;
import java.time.LocalDate;

public class Rent {
    private static int firstId = 1;
    private static Book book;
    private static NormalUser normalUser;
    private static String RentalId;
    private static LocalDate RentalDate;

    static String idgenerator() {
        String ID = "Rental Id is " + firstId;
        firstId += firstId;
        return (ID);
    }

    public Rent(Book book, NormalUser normalUser,String RentalId,LocalDate RentalDate){
        this.book = book;
        this.normalUser = normalUser;
        this.RentalId = idgenerator();
        this.RentalDate = RentalDate;
        }

    public static Book getBook(){
        return book;
    }
    public static NormalUser getNormalUser(){
        return normalUser;
    }
    public static String getRentalId(){
        return RentalId;
    }
    public static LocalDate getRentalDate(){
        return RentalDate;
    }

}
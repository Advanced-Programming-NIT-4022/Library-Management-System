package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Rent extends UniqueID{
    Book book;
    User user;
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String RentalDate = currentDateTime.format(formatter);
    private final String RentID = getUniqueID();
    public String getRentID() { return RentID; }
    public String getRentalDate() { return RentalDate; }
}

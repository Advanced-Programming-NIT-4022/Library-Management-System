package org.example;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Rent {
    Book book ;
    User user ;
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String RentalDate ;
    public String getRentalDate() { return RentalDate; }
    public Rent()
    {
        RentalDate = currentDateTime.format(formatter);
    }
}
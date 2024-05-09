package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class NormalUser extends User {

    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String formattedDateTime = currentDateTime.format(formatter);
    public NormalUser(String name, String phoneNumber) {
        super(name, phoneNumber);
    }
    public NormalUser() { super(); }
    public String getFormattedDateTime() { return formattedDateTime; }
}

package org.example;

import java.time.LocalDate;

public class Normal extends User{
    LocalDate _Date;
    public Normal(String Name, long Unique_ID, String Phone_number) {
        super( Name , Unique_ID , Phone_number);
        _Date = LocalDate.now();
    }

}



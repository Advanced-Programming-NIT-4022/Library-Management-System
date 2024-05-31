package org.example;

import java.time.LocalDate;

public class Rent {
    Book _B ;
    Normal _normal;
    long _Rental_ID;
    static int id=0;
    LocalDate _Rental_date;
    public Rent( Book B , Normal normal , long id){
        _B = B;
        _normal = normal;
        _Rental_ID = id++;
        _Rental_date = LocalDate.now();
    }
}

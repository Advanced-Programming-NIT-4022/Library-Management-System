package com.example.lib;

import java.time.LocalDate;

public class normalUser extends User{
    private LocalDate registration;
    normalUser(String name,String Id,String phoneNumber){
        super(name,phoneNumber,Id);
        
    }
}

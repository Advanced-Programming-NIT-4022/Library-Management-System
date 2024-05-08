package org.example;

import javax.xml.crypto.Data;
import java.util.Date;

public class NormalUsers extends User{
    // Attributes
    private Date registrationDate;
    // Getters & Setters
    public Date getRegistrationDate() {
        return registrationDate;
    }
    // Constructor
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }



    NormalUsers(String name, String uniqueID, String phoneNumber, Date registrationDate) {
        super(name, uniqueID, phoneNumber);
        this.registrationDate = registrationDate;
    }
}

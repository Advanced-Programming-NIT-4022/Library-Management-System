package org.example;

import java.util.Date;

public class NormalUser extends User{
    private Date registrationDate;

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public NormalUser(String name, int ID, String phoneNum, Date registrationDate)
    {
        super(name,ID,phoneNum);
        this.registrationDate= registrationDate;
    }
}

package org.example;

public class Admin extends User{
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    public Admin (String name, int ID, int phoneNuM, String password)
    {
        super(name, ID, phoneNuM);
        this.password= password;
    }

}

package org.example;

class Admin extends User {
    private final String Password;
    public Admin(String name, String phonenumber)
    {
        super(name, phonenumber);
        this.Password = "8488";
    }
    public String getPassword() {return Password;}
}





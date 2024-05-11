package org.example;

public class Admin extends User {
    private String _Password;
    public String get_Password() {
        return _Password;}

    public Admin(String Name, long Unique_ID, String Phone_number ,String Password) {
        super( Name , Unique_ID , Phone_number);
        _Password = Password;
    }

}
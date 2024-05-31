package org.example;


public class User{
    private String _Name;
    public String getName() {
        return _Name;}
    public void setName(String newName) {
        _Name = newName;}

    private long _Unique_ID;
    public long getId() {
        return _Unique_ID;}
//    public void setId(int ID) {
//        _Unique_ID = ID;}
//
    private String _Phone_number;
    public String get_Phone_number() {
        return _Phone_number;}
    public void set_Phone_number(String phoneNumber) {
        _Phone_number = phoneNumber;}

    public User(String Name , long Unique_ID , String Phone_number){

        _Name =  Name;
        _Unique_ID= Unique_ID;
        _Phone_number = Phone_number;

    }
}

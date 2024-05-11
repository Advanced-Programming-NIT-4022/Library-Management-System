package org.example;

import java.util.ArrayList;

public class Library {
    String _Library_name;
    public String get_Library_name() {
        return _Library_name;}
    public void setName(String Libraryname) {
        _Library_name= Libraryname;}

    String _Capacity;
    int[] _Operating_hours;
    public int[] get_hours(){
        return _Operating_hours;}
    public int[] set_hours(){
        return _Operating_hours;}
    ArrayList<Book> _Book_repository;
    ArrayList<Normal> _Trustee;
    ArrayList<Admin> _Boss;
    ArrayList<Rent> _rental_registries;
    public Library(String Library_name , String Capacity , int[] Operating_hours){
        _Library_name= Library_name;
        _Capacity= Capacity;
        _Operating_hours = Operating_hours;
        _Book_repository = new ArrayList<>();
        _Trustee = new ArrayList<>();
        _Boss =new ArrayList<>();
        _rental_registries= new ArrayList<>();

    }
}

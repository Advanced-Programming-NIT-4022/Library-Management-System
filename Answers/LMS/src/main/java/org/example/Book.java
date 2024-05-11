package org.example;

public class Book {
    private int _bookID;
    public int get_bookID() {
        return _bookID;}
    public void set_bookID(int bookID) {
        _bookID= bookID;}
    private String _Title;
    public String get_Title() {
        return _Title;}
    public void set_Title(String title) {
        _Title= title;}

    private String _Author;
    private boolean _Availability_status;
    public boolean get_Availability() {
        return _Availability_status;}
    public void set_Availability(boolean Availability) {
        _Availability_status= Availability;}
    private String _Description;

    public Book(int bookID, String Title, String Author, boolean Availability_status, String Description) {
        _bookID = bookID;
        _Title = Title;
        _Author = Author;
        _Availability_status = Availability_status;
        _Description = Description;

    }

}


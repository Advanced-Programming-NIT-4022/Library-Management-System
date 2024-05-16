package org.example;

public class Admin {
    private static int firstId;
    private String Id;
    private static String Name;
    private static String PhoneNumber;

    static String idgenerator() {
        String ID = "Admin Id is " + firstId;
        firstId += firstId;
        return (ID);
    }

    public Admin(String Id, String Name, String PhoneNumber) {
        this.Id = idgenerator();
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public static void Login(String password){

    }
}

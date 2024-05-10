package org.example;

public class User {

    private static int firstId;
    private static String Id;
    private static String Name;
    private static String PhoneNumber;

    static String idgenerator() {
        String ID = "User Id is " + firstId;
        firstId += firstId;
        return (ID);
    }

    public User(String Id, String Name, String PhoneNumber) {
        this.Id = idgenerator();
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
    }

    public static String getId() {
        return Id;
    }

    public static String getName() {
        return Name;
    }

    public static String getPhoneNumber() {
        return PhoneNumber;
    }
}
package org.example;

public class NormalUser {
    private static int firstId;
    private static String Id;
    private static String Name;
    private static String PhoneNumber;
    private static String Date;

    static String idgenerator() {
        String ID = "Normal User Id is " + firstId;
        firstId += firstId;
        return (ID);
    }

    public NormalUser(String Id, String Name, String PhoneNumber, String Date) {
        this.Id = idgenerator();
        this.Name = Name;
        this.PhoneNumber = PhoneNumber;
        this.Date = Date;

    }

    public static String getId() {
        return Id;
    }

    public static String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public String getDate() {
        return Date;
    }

}

public class Admin extends User {
    public Admin(String name, String surname, String phoneNumber, String userId, String password) {
        super(name, surname, phoneNumber, userId, password);
    }

    static final String Adminpass = "e";
    public static void adminCli(){
        System.out.println("1.add book---2.del user\n3.rent book---4.delete book\n5.add book book");
    }

}

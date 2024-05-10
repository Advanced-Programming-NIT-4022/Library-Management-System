import java.util.Scanner;

public class User {
    private String Name;
    private String FamilyName;
    private String PhoneNumber;
    private String Id;
    private String password;

    public User(String name, String surname, String phoneNumber, String userId, String password) {
        this.Name = name;
        this.FamilyName = surname;
        this.PhoneNumber = phoneNumber;
        this.password = password;
    }
    public String getName() {
        return Name;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getId() {
        return Id;
    }

    public String getPassword() {
        return password;
    }

    public void setInformation(){
        try (Scanner scanner = new Scanner(System.in)) {
            this.Name = scanner.nextLine();
            this.FamilyName = scanner.nextLine();
            this.Id = scanner.nextLine();
            this.password = scanner.nextLine();
            this.PhoneNumber = scanner.nextLine();
        }
    }
}

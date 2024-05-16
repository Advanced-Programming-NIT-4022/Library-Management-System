import java.util.List;
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

    public String[] setInformation() {
        try (Scanner scanner = new Scanner(System.in)) {
            this.Name = scanner.nextLine();
            this.FamilyName = scanner.nextLine();
            this.Id = scanner.nextLine();
            this.password = scanner.nextLine();
            this.PhoneNumber = scanner.nextLine();
        }
        String[] values ={Name, FamilyName, Id, password, PhoneNumber};
        return values;
    }

   /*  @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        User user = (User) obj;
        return Name.equals(user.Name) &&
                FamilyName.equals(user.FamilyName) &&
                PhoneNumber.equals(user.PhoneNumber) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, FamilyName, PhoneNumber, password);
    }*/

    public static User userfinder(String n, String p , String j) {
        
        List<User> me = Library.getuser();
        for (User u : me) {
            if (u.getName().equals(n) && u.getPassword().equals(p) && u.getPhoneNumber().equals(j)) {
                System.out.println("User found");
                return u;
            }
        }
        System.out.println("User not found");
        return null;
    }
    public String toString2() {
        return "User{" +
                "ID='" + Id + '\'' +
                ", name='" + Name + '\'' +
                ", FamilyName='" + FamilyName + '\'' +
                ", PhoneNumber=" + PhoneNumber +'\'' +
                '}';
    }
}


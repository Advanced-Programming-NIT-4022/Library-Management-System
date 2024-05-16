
public class User extends Library{
    private String name;
    private String phoneNumber;

    private int Id;


    public User(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getId(){
        String IdStr = toString(Id);
        return IdStr;
    }

    String toString(int id) {
        return toString(id);
    }

    public User() {

    }
}

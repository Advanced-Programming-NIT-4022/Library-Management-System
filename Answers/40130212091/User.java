public class User extends Library{
    String name;
    String Id, phoneNumber, password;

    private int c = 0;

    public String[] add(String[] members){
        members[c] = Id + "," + name + "," + phoneNumber + "," + password;
        return members;
    }
}

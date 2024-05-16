
public class Admin extends User {

    private String password, Id;
    public Admin(String name ,String phoneNumber, String password){
        super(name, phoneNumber);
        this.password = password;
    }

    public String getPassword(){
        return password;
    }


}

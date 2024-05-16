public class Admin extends User{
    private String password;
    public Admin(String Name , long Unique_ID , String Phone_number, String password){
        super(Name, Unique_ID , Phone_number);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}

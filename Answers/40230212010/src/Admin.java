public class Admin extends User{
    private String password;
    public Admin(String name,int phoneNumber,String password) {
        super( name, phoneNumber);
        this.password=password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    

}

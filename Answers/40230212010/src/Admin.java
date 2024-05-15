public class Admin extends User{
    private String password;
    public Admin(String name,int UniqueID,int phoneNumber,String password) {
        super( name, UniqueID, phoneNumber);
        this.password=password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    

}

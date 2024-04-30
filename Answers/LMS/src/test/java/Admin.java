class Admin extends User{
    private String Password;
    public Admin(String Name , String PhoneNumber , String Password , int UserID){
        super(Name , PhoneNumber , UserID);
        this.Password = Password;
    }
    public String getPassword(){

        return Password;
    }
}

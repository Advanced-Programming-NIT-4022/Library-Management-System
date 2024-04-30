class Admin extends User{
    private int Password;
    public Admin(String Name , int PhoneNumber , int Password , int UserID){
        super(Name , PhoneNumber , UserID);
        this.Password = Password;
    }
    public int getPassword(){

        return Password;
    }
}

class Admin extends User{
    private int Password;
    public Admin(String Name , int PhoneNumber , int Password){
        super(Name , PhoneNumber);
        this.Password = Password;
    }
    public int getPassword(){

        return Password;
    }
}

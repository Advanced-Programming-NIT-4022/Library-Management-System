package basic.classes;

class Admin extends User{

    private final String password;

    Admin(String name, String id, String phone_number, String password) {
        super(name, id, phone_number);
        this.password = password;
    }

    protected String getPassword(){
        return password;
    }
}

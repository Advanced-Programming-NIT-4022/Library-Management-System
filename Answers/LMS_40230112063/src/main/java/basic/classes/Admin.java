package basic.classes;

class Admin extends User{

    private final String password;

    Admin(String name, Integer id, Integer phone_number, String password) {
        super(name, id, phone_number);
        this.password = password;
    }

    protected String getPassword(){
        return password;
    }
}

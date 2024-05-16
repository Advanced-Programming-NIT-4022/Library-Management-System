public class NormalUser extends User {

    private int Id;
    private int j = 100;

    public NormalUser(String name, String phoneNumber){
        super(name, phoneNumber);
        this.Id = ++j;
    }

    public String getId(){
        return toString(Id);
    }

}

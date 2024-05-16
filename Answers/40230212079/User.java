public class User {
    private String name;
    private String ID;
    private String phonnumber;

    public User(String name, String ID, String phonnumber) {
        this.setName(name);
        this.ID = ID;
        this.setName(phonnumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getphonNumber() {
        return phonnumber;
    }

    public void setphonNumber(String number) {
        this.phonnumber = phonnumber;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID){
        this.ID=ID;
    }
}

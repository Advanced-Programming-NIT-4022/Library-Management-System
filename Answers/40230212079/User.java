public class User {
    private String name;
    private int ID;
    private String phonnumber;

    public User(String name, int ID, String phonnumber) {
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

    public int getID() {
        return ID;
    }
    public void setID(int ID){
        this.ID=ID;
    }
}

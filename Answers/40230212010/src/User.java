public  class User {
    private String name;
    private final int UniqueID;
    private int phoneNumber;
    public User(String name,int UniqueID,int phoneNumber) {
        this.name = name;
        this.UniqueID = UniqueID;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
        
}

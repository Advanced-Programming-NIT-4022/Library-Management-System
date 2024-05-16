public class User {
    private String Name;
    private long Unique_ID;
    private String Phone_number;

    public User(String Name , long Unique_ID , String Phone_number){
        this.Name = Name;
        this.Unique_ID = Unique_ID;
        this.Phone_number = Phone_number;
    }

    public String getName() {
        return Name;
    }
   /* public void setName(String name) {
        Name = name;
    }*/

    public long getUnique_ID() {
        return Unique_ID;
    }
    public void setUnique_ID(int unique_ID) {
        Unique_ID = unique_ID;
    }

    public String getPhone_number() {
        return Phone_number;
    }
}



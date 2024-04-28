import java.util.Random;

public class User implements IDgenerator{

    private String name;
    private int Unique_UserID;
    private String Phone_Number;
    public User(String name , String Phone_Number){

        this.name = name;
        this.Unique_UserID = Unique_ID_Generator();
        this.Phone_Number = Phone_Number;

    }

    public Integer Unique_ID_Generator() {
        Random rand = new Random();
        Integer newID;
        do {
            newID = rand.nextInt(100, 9999);
        } while (UsedID.contains(newID));
        UsedID.add(newID);
        return newID;
    }

    public String toString(){
        return this.name + " " + this.Phone_Number + " " + this.Unique_UserID;
    }
}

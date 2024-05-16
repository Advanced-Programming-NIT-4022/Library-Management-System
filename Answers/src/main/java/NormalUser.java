import java.time.LocalDate;

public class NormalUser extends User {
    LocalDate date;
    public NormalUser(String Name , long Unique_ID , String Phone_number){
        super(Name, Unique_ID , Phone_number);
        this.date = LocalDate.now();
    }

    @Override
    public long getUnique_ID() {
        return super.getUnique_ID();
    }

    @Override
    public void setUnique_ID(int unique_ID) {
        super.setUnique_ID(unique_ID);
    }
}

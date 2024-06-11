import java.time.LocalDate;
import java.util.HashMap;

public class Rent {
    int rentid=1;
    LocalDate rentdate = LocalDate.now();
    HashMap<String,Integer> bookrent=new HashMap<>();
    HashMap<String,Integer> rentmem=new HashMap<>();
    public void rentsaz(String esmb) {
        bookrent.put(esmb,rentid);
        rentid++;
    }
}
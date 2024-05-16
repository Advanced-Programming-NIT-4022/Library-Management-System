import java.time.LocalDateTime;
import java.util.HashMap;

public class NormalUser {
  static  HashMap<String, LocalDateTime> Normal = new HashMap<String, LocalDateTime >();
    public static void date(String name1){

        LocalDateTime myObj = LocalDateTime.now();

        Normal.put(name1,myObj);





    }
}

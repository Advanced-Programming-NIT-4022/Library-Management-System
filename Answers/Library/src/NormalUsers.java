import java.util.ArrayList;

public class NormalUsers extends User {
    String registeryDate;
    String password;
    String rentBooks = "";
    static ArrayList<NormalUsers> normalUsersArray = new ArrayList<>();
    public NormalUsers(String C_name , String C_pass, String C_registryDate){
        name=C_name;
        password=C_pass;
        registeryDate=C_registryDate;
    }

}

import com.sun.source.tree.NewArrayTree;

import java.time.LocalDate;

public class User {
    NormalUser normalUser = new NormalUser();

    int i = 1;
    public User(){


    }

    public void save(String name , String phone , String ID ) {
        while(true) {
            normalUser.Name[i] = name;
            normalUser.phone_number[i] = phone;
            normalUser.User_ID[i] = ID;
            System.out.format("user %d \nname : %s \nphone number : %s \nid: %s \n", i, normalUser.Name[i], normalUser.phone_number[i], normalUser.User_ID[i]);
            LocalDate time =LocalDate.now();
            System.out.println("you have been signed up at" + " " + time + "\n" );
            i++;
            break;
        }

        normalUser.Check();
    }



}

package Console;

import com.example.lib.Library;

import java.sql.SQLException;
import java.util.Scanner;

public class Ui {
    Library lib=new Library();

    public Ui() throws SQLException {
    }

    public static void main(String[] args) {

    }
    public void mainPage(){
        String username="";
        boolean Admin=false;

        Scanner input=new Scanner(System.in);
        while(true){
            System.out.println("enter your command:");
            String command;
            command=input.next();
            String[] split=command.split(" ");
            switch (split[0]){
                case "sign":

            }
        }
    }
}

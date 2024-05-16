import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {

        Library library=new Library("a",12,"8-18");
        CLI cli=new CLI(library);
        cli.start();
    }
}
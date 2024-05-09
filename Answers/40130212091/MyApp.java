import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        // create library object
        Library library = new Library();

        try {
            File book = new File("book.txt");
            if (book.createNewFile()) {
                System.out.println("File created: " + book.getName());
            }
            File n_user = new File("user.txt");
            if (n_user.createNewFile()){
                System.out.println("File created: " + n_user.getName());
            }
            File rents = new File("rents.txt");
            if (rents.createNewFile()){
                System.out.println("File created: " + rents.getName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] memberList = new String[400];
        String[] rentList = new String[400];


        Scanner command = new Scanner(System.in);
        String input = command.nextLine();
        String[] order = input.split(" ");
        ArrayList<String> books = new ArrayList<>();
        int i = 0;
        while(true){
            if(order[i] == "lib"){
                i++;
                if(order[i] == "add"){
                    i++;
                    if(order[i] == "book"){
                        i++;
                        Book book = new Book(order[i], order[i + 1], order[i + 2]);
                        library.bookRepository = book.add(library.bookRepository);
                    }
                    else if(order[i] == "member"){
                        i++;
                        NormalUser member = new NormalUser(order[i], order[i + 1]);
                        memberList = member.add(memberList);
                    }
                    else {
                        try {
                            throw new Exception("Enter a correct command");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                else if(order[i] == "rent"){
                    i++;
                    Rent r = new Rent(order[i]);
                    i++;
                    if (order[i] == null){
                        r.rentBook();
                    }else{
                        //check password
                        r.rentBook(order[i]);
                    }
                }
                else if(order[i] == "get"){
                    i++;
                    if(order[i] == "hrs"){
                        System.out.println(library.getHours());
                    }
                    else{
                        System.out.println("enter a correct command");
                    }
                } else if (order[i] == "remove") {
                    i++;
                    if (order[i] == "member"){
                        i++;

                    }
                    else{
                        System.out.println("Enter a correct command");
                    }
                } else if (order[i] == "return") {
                    i++;

                } else{
                    try {
                        throw new Exception("Enter a correct command");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            else {
                try {
                    throw new Exception("Enter a correct command");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

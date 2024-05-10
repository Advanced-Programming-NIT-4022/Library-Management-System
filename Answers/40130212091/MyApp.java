
import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        // create library object
        Library library = new Library();


        Scanner command = new Scanner(System.in);
        String input = command.nextLine();
        String[] order = input.split(" ");
        int i = 0;
        while(true){
            if(order[i] == "lib"){
                i++;
                if(order[i] == "add"){
                    i++;
                    if(order[i] == "book"){
                        i++;
                        library.addBook(order[i], order[i + 1], order[i + 2]);
                    }
                    else if(order[i] == "member"){
                        i++;
                        library.addMember(order[i], order[i + 1]);
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
                    library.rentBook(order[i]);
                }
                else if(order[i] == "get"){
                    i++;
                    if(order[i] == "hrs"){
                        System.out.println(library.getHours());
                    }
                    else if(order[i].equals("available")){
                        i++;
                        if (order[i].equals("books")){
                            library.availableBooks();
                        }else {
                            System.out.println("enter a correct command");
                        }
                    }
                    else{
                        System.out.println("enter a correct command");
                    }
                } else if (order[i] == "remove") {
                    i++;
                    if (order[i] == "member"){
                        i++;
                        library.removeMember(order[i]);
                    }
                    else{
                        System.out.println("Enter a correct command");
                    }
                } else if (order[i] == "return") {
                    i++;
                    library.returnBook(order[i]);
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

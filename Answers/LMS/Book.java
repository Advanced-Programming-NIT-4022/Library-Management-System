import java.io.File;
import java.io.IOException;

public class Book{
    File bookIdFile = new File("bookId.txt");
    File titleFile = new File("titleBook.txt");
    File authorFile = new File("authorBook.txt");
    File statusFile = new File("statusBook.txt");
    File descriptionFile = new File("descriptionBook.txt");
    
    public Book(){
        try{
            boolean isId = bookIdFile.createNewFile();
            boolean isTitle = titleFile.createNewFile();
            boolean isAuthor = authorFile.createNewFile();
            boolean isStatus = statusFile.createNewFile();
            boolean isDescription = descriptionFile.createNewFile();
        }catch(IOException e){
            System.out.println("error 404!\npage not found!");
        }
    }
}
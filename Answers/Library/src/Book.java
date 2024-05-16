import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    static ArrayList<Book> booksArray = new ArrayList<>();
    String title,author,subtitle;
    int uniquebookID;
    boolean availabilityStatus;
    public Book(String C_title,String C_author,boolean C_availabilityStatus,String C_subtitle){
        title=C_title;
        author=C_author;
        availabilityStatus=C_availabilityStatus;
        subtitle=C_subtitle;
    }

    public static void  copyFileOnBook() {
        try {
            File books = new File("C:\\Users\\MSI\\OneDrive\\Desktop\\Library\\Library-Management-System\\Answers\\Library\\src\\books.txt");
            books.createNewFile();
            Scanner reader = new Scanner(books);
            while (reader.hasNextLine()) {
                String[] copy = reader.nextLine().split("#");
                boolean status = false;
                if (copy[2].equals("false")){
                    status = false;
                }
                else if (copy[2].equals("true")){
                    status = true;
                }
                Book book =new Book(copy[0],copy[1],status,copy[3]);
                book.uniquebookID = Integer.parseInt(copy[4]);
                Book.booksArray.add(book);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("sorry");
        }
    }
    public static void copyBookOnFile() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\MSI\\OneDrive\\Desktop\\Library\\Library-Management-System\\Answers\\Library\\src\\books.txt");
            for (int i=0 ; i< booksArray.size(); i++){
                writer.write((booksArray.get(i).title)+"#"+(booksArray.get(i).author)+"#");
                if (booksArray.get(i).availabilityStatus){
                    writer.write("true"+"#");
                }
                else {
                    writer.write("false"+"#");
                }
                writer.write(booksArray.get(i).subtitle+"#"+booksArray.get(i).uniquebookID+"\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("sorry");
            throw new RuntimeException(e);
        }


    }

    public  static void getAvailableBooks(){
        System.out.println("Available books are : ");
        for (int i =0 ; i< Book.booksArray.size();i++){
            if(Book.booksArray.get(i).availabilityStatus){
                System.out.println(Book.booksArray.get(i).title);
            }
        }


    }

    public static int  getBookID(String title){
        for(int i=0 ; i< Book.booksArray.size();i++){
            if(Book.booksArray.get(i).title.equals(title)){
                return i ;
            }


        }
        return (-1);
    }

    public static boolean checkBookName(String name){
        for(int i=0; i<booksArray.size();i++){
            if(name.equals(booksArray.get(i).title)){
                return true;
            }
        }
        return false;
    }

}

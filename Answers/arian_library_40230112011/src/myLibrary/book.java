package myLibrary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class book extends library {
    private final String bookId;
    private final String Title;
    private final String Author;
    private final String name;
    private  String Description;

    public book(String x,int y) throws IOException {
        ArrayList<String> myBook = new ArrayList<>();
        String xyz2="";
        ArrayList<String> xyz=new ArrayList<>();
        for (int i=0;i<x.length();i++){
            if (x.charAt(i)=='<'){
                    xyz2="";
                for (int z=i+1;z<x.length();z++){
                    xyz2=xyz2 + x.charAt(z);
                    if (x.charAt(z)=='>'){
                    xyz.add(xyz2.substring(0,xyz2.length()-1));
                        break;
                    }
                }
            }
        }
        this.name = xyz.get(0);
        this.Author = xyz.get(1);
        this.Title = xyz.get(2);
        this.bookId=String.valueOf((int)Math.floor(Math.random()*10000));
        myBook.add(showName());
        myBook.add(showAuthor());
        myBook.add(showBookId());
        myBook.add(showTitle());
            System.out.println("Do you have any kind of opinion about the book that you want to share?");
        while (true){
            System.out.println("1:Yes");
            System.out.println("2:No");
            String Answer=order();
            if (Answer.equals("1")){
                this.Description=order();
                break;
            }
            else if (Answer.equals("2")) {
                Description=" ";
                break;
            }
                System.out.println("I didn't understand");
                System.out.println("would you share your info on the book or not?");
        }
        myBook.add(showDescription());
        myBook.add("true");
        File myBookfile=new File("C:/Users/Dr Techno/Desktop/book.txt");
        if (myBookfile.exists()) {
            FileWriter writer=new FileWriter("C:/Users/Dr Techno/Desktop/book.txt",true);
            PrintWriter pw=new PrintWriter(writer);
            pw.println(myBook);
            pw.close();
            writer.close();
        } else
        {
            FileWriter writer=new FileWriter("C:/Users/Dr Techno/Desktop/book.txt");
            PrintWriter pw=new PrintWriter(writer);
            pw.println(myBook);
            pw.close();
            writer.close();
        }
        System.out.println("your book has been successfully added");
        if (y==1){
            AdminsCommandLine();
        } else if (y==2) {
            UserComendline();
        }
    }
    public String showName(){
        return this.name;
    }
     public String showAuthor(){
        return Author;
     }
    public String showDescription(){
        return Description;
    }
    public String showBookId(){
        return bookId;
    }

    public String showTitle(){
        return Title;
    }

}

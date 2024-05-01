import java.util.List;

public class CLI {
    private Library Library;

    public CLI(Library Library){
        this.Library = Library;
    }
    public void processCommand(String[] args) {
        if (args.length < 2) {
            System.out.println("Invalid command. Please provide a valid command.");
            return;
        }

        String command = args[0];

        switch (command) {
            case "lib":
                LibraryCommand(args);
                break;
            default:
                System.out.println("Invalid command.");
        }
    }
    public void LibraryCommand(String[] args){
        String Command = args[1];

        switch(Command){
            case "add":
                if(args.length < 5){
                    System.out.println("Invalid Command Please Provide Detail of Book. ");
                    return;
                }
                if(args[2].equals("book")){
                    String Title = args[3];
                    String Author = args[4];
                    String Description = args.length > 5 ? args[5] : "";
                    Library.addbook(Title , Author , Description);
                    System.out.println("Book Successfully Added. ");
                }
                else if(args[2].equals("member")){
                    if(args.length < 5){
                        System.out.println("Invalid Command Please Provide Detail of User. ");
                        return;
                    }
                    String Name = args[3];
                    String PhoneNumber = args[4];
                    Library.adduser(Name , PhoneNumber);
                    System.out.println("Member Successfully Created. ");
                }else if(args[2].equals("admin")){
                    if(args.length < 6){
                        System.out.println("Invalid Command Please Provide Detail of Admin. ");
                        return;
                    }
                    String Name = args[3];
                    String PhoneNumber = args[4];
                    String PassWord = args[5];
                    Library.addadmin(Name , PhoneNumber , PassWord);
                    System.out.println("Admin Successfully Created. ");
                }else{
                    System.out.println("Invalid Command!");
                }
                break;
            case "rent":
                if (args.length < 5) {
                    System.out.println("Invalid command. Please provide book, member name, and member ID.");
                    return;
                }
                String bookName = args[2];
                String userName = args[3];
                Library.rentbook(bookName, userName);
                break;
            case "return" :
                if(args.length < 3){
                    System.out.println("Invalid Command Please Provide Detail of Book. ");
                    return;
                }
                String ReturnBook = args[2];
                Library.returnBook(ReturnBook);
                System.out.println(ReturnBook + " Successfully Returned. ");
                break;
            case "get" :
                if(args.length < 3){
                    System.out.println("Invalid Command Please Provide Valid Argument. ");
                }
                if(args[2].equals("available") && args.length <=4 && args[3].equals("books")){
                    List<Book> availablebook = Library.getAvailableBook();
                    for(Book book : availablebook){
                        System.out.println(book.getTitle() + " by " + book.getAuthor() + " Is Available. ");
                    }
                }else if(args[2].equals("hrs")){
                    System.out.println("Operation Hours: 8:00AM - 9:00PM");
                }else{
                    System.out.println("Invalid Command!");
                }
                break;
            case "remove" :
                if(args.length < 3){
                    System.out.println("Invalid Command Please Provide Detail of UserID. ");
                    return;
                }
                String PhoneNumber = args[2];
                Library.removeuser(PhoneNumber);
                break;
            default:
                System.out.println("Invalid Command");
        }
    }
}

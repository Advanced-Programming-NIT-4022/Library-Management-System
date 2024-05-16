import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Cli {
    String massage;
    Random rand = new Random();
    Date date=new Date();
    Scanner scan = new Scanner(System.in);
    public boolean formatCheck(String command,int number ){
        int counter=0;
        String editor="";
        for (int i=0 ; i<command.split("").length ; i++)
            if(command.split("")[i].equals("<") || command.split("")[i].equals(">")){ counter++; }
        if (counter != number){
            return false;
        }
        return true;
    }
    public String editor(String sentens) {
        String[] sen = sentens.split("");
        String edit ="";
        boolean check=false;
        for(int i=0;i<sentens.length();i++){
            if (sen[i].equals("<") || sen[i].equals(">")){
                check = !check;
            }
            if(sen[i].equals(">")){
                edit=edit+"#";
            }
            if(check){
                edit=edit+sen[i];
                continue;
            }
        }
        String res =edit.replace("<","");
        return res;
    }
    public String getMassage (){
        System.out.println("Enter your command : ");
        massage = scan.nextLine();
        return massage;
    }
    public  boolean massageCompile ()
    {
        String[] compile = massage.split(" ");                             // maybe book name have space" "
        if (!(compile[0].equals("lib"))){
            System.out.println("wrong command.");
            return false;
        }
        if((compile[1].equals("rent")) && (compile.length == 3)){
            System.out.println("Sorry, I don't know who to rent the book to \nit's project bug");
            return false;
        }
        switch (compile[1]){
            case "add":
                switch (compile[2]){
                    case "book":
                        if (!formatCheck(massage,6)){
                            System.out.println("wrong command.");
                            return false;
                        }
                        //
                        //
                        //  we most make that defensive
                        //
                        //
                        String[] choose = editor(massage).split("#");
                        if(Book.checkBookName(choose[0])){
                            System.out.println("There is a book with this name.\nPlease choose another name or give it a number");
                            return false;
                        }
                        Book  book = new Book(choose[0],choose[1],true,choose[2]);
                        book.uniquebookID= Math.abs(rand.nextInt()%date.getSeconds());
                        Book.booksArray.add(book);
                        return true;
                    case "member":
                        if (!formatCheck(massage,4)){
                            System.out.println("wrong command.");
                            return false;
                        }
                        //
                        //
                        //  we most make that defensive
                        //
                        //
                        choose = editor(massage).split("#");
                        if(NormalUsers.checkUsers(choose[0])){
                            System.out.println("There is a user with this name.\nPlease choose another name");
                            return false;
                        }
                        Date today = new Date();
                        NormalUsers normalUsers = new NormalUsers(choose[0],choose[1],today.toString());
                        normalUsers.uniqueID = Math.abs(rand.nextInt()%date.getSeconds());
                        NormalUsers.normalUsersArray.add(normalUsers);
                        return true;
                    case "admin":
                        if (!formatCheck(massage,6)){
                            System.out.println("wrong command.");
                            return false;
                        }
                        //
                        //
                        //  we most make that defensive
                        //
                        //
                        choose = editor(massage).split("#");
                        if(Admin.checkAdmins(choose[0])){
                            System.out.println("There is a admin with this name.\nPlease choose another name");
                            return false;
                        }
                        Admin admin =new Admin(choose[0],choose[1]);
                        if (!choose[2].equals(admin.manegerPass)){
                            System.out.println("You do not have access to add admin");
                            return false;
                        }
                        Admin.adminArray.add(admin);
                        return true;


                    default:
                        System.out.println("wrong command.");
                        return false;

                }
            case "get":
                switch (compile[2]){
                    case "hrs":
                        System.out.println("The library is active from 7:00 to 20:00 ");
                        return true;
                    case "available":
                        switch (compile[3]){
                            case "books":
                                Book.getAvailableBooks();
                                return true;
                            default:
                                System.out.println("wrong command.");
                                return false;
                        }
                }
            case "rent":
                String password;
                int userID,bookID ;
                if (!formatCheck(massage,6)){
                    System.out.println("wrong command.");
                    return false;
                }
                //
                //
                //  we most make that defensive
                //
                //
                String[] choose = editor(massage).split("#");
                userID=NormalUsers.getUserID(choose[1]);
                if (userID == (-1)){
                    System.out.println("The desired user was not found");
                    return false;
                }
                bookID = Book.getBookID(choose[0]);
                if (bookID == (-1)){
                    System.out.println("The desired book was not found");
                    return false;
                }
                password = choose[2];
                if(!(NormalUsers.checkPass(userID,password))){
                    System.out.println("The user's password is incorrect");
                    return false;
                }
                if(!(Rent.checkRent(bookID))){
                    System.out.println("The desired book has been rented");
                    return false;
                }
                Rent.rent(bookID,userID);
                return true;

            case "remove" :
                switch (compile[2]){
                    case "member":
                        String name;
                        if (!formatCheck(massage,2)){
                            System.out.println("wrong command.");
                            return false;
                        }
                        //
                        //
                        //  we most make that defensive
                        //
                        //
                        choose = editor(massage).split("#");
                        name = choose[0];
//                        String adminName = editor(compile[4]);
//                        if(Admin.getAdminID(adminName) == (-1)){
//                            System.out.println("The desired admin was not found");
//                            return false;
//                        }                                                                             // :((((((((((
//                        password = editor(compile[5]);
//                        if(!(Admin.checkAdminPass(Admin.getAdminID(adminName),password))){
//                            System.out.println("The admin's password is incorrect");
//                            return false;
//                        }
                        Rent.returnAllBooks(NormalUsers.getUserID(name));
                        NormalUsers.normalUsersArray.remove(NormalUsers.getUserID(name));
                        return true;
                    default:
                        System.out.println("wrong command.");
                        return false;
                }


            case "return" :
                String bookName;
                if (!formatCheck(massage,2) ){
                    System.out.println("wrong command.");
                    return false;
                }
                //
                //
                //  we most make that defensive
                //
                //
                choose = editor(massage).split("#");
                bookName = choose[0];
                if(Rent.returnRent(bookName)){
                    System.out.println("The return of the book was well done");
                    return true;
                }
                return false;
            default:
                System.out.println("wrong command.");
                return false;


        }



    }
}

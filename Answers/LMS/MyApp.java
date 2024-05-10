import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyApp {

    public static final String RESET = "\033[0m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String WHITE_BOLD = "\033[1;37m";
    public static final String GREEN = "\033[1;32m";
    public static void main(String[] args){
        //for saving first setting
        File ownerInfo = new File("ownerInfo");
        try{
            if(ownerInfo.mkdir()){
                Scanner strScanner = new Scanner(System.in);
                System.out.println("Hello;\nYou Are Owner Of This Library.");
                System.out.println(RED_BOLD + "After Filling This Form Out, You Can\'t Change It." + RESET);

                System.out.println(WHITE_BOLD + "Please Answer:" + RESET);

                System.out.print("Library Name: ");
                String libName = strScanner.nextLine();

                System.out.print("Library Capacity: ");
                Integer libCap = 0;
                while(true){
                    String tmpCapacity = strScanner.nextLine();
                    boolean isInt = true;
                    for(int i=0; i<tmpCapacity.length(); i++){
                        if(tmpCapacity.charAt(i)<'0' || tmpCapacity.charAt(i)>'9'){
                            isInt = false;
                            break;
                        }
                    }
                    if (!isInt) {
                        System.out.println(RED_BOLD + "Wrong Input!" + RESET);
                        System.out.print ("Enter Number: ");
                    }else{
                        libCap = Integer.parseInt(tmpCapacity);
                        break;
                    }
                }

                System.out.print("Your Name: ");
                String name = strScanner.nextLine();

                System.out.print("Your ID: ");
                String ID = strScanner.nextLine();

                System.out.print("Your Phone Number: ");
                String phone = "";
                boolean isPhone = true;
                while(true){
                    phone = strScanner.nextLine();
                    if(phone.charAt(0)=='0'){
                        if(phone.length()==11){
                            for(int i=0; i<phone.length(); i++){
                                if(phone.charAt(i)<'0' || phone.charAt(i)>'9'){
                                    isPhone = false;
                                    break;
                                }
                                isPhone = true;
                            }
                        }else{
                            isPhone = false;
                            System.out.print(RED_BOLD + "Wrong Number\n" + RESET + "Try Again: ");
                        }
                    }else if(phone.charAt(0)=='9'){
                        if(phone.length()==10){
                            for(int i=0; i<phone.length(); i++){
                                if(phone.charAt(i)<'0' || phone.charAt(i)>'9'){
                                    isPhone = false;
                                    break;
                                }
                                isPhone = true;
                            }
                        }else{
                            isPhone = false;
                            System.out.print(RED_BOLD + "Wrong Number\n" + RESET + "Try Again: ");
                        }
                    }else{
                        isPhone = false;
                        System.out.print(RED_BOLD + "Wrong Number\n" + RESET + "Try Again: ");
                    }
                    if(isPhone) break;
                }

                System.out.print("Your Password: ");
                String pass = strScanner.nextLine();

                FileWriter libraryName = new FileWriter("ownerInfo\\libName.txt");
                libraryName.append(libName);
                libraryName.close();

                FileWriter libraryCapacity = new FileWriter("ownerInfo\\libCap.txt");
                libraryCapacity.append(libCap.toString());
                libraryCapacity.close();

                FileWriter ownerName = new FileWriter("ownerInfo\\ownerName.txt");
                ownerName.append(name);
                ownerName.close();
                    
                FileWriter ownerId = new FileWriter("ownerInfo\\ownerId.txt");
                ownerId.append(ID);
                ownerId.close();

                FileWriter ownerPhone = new FileWriter("ownerInfo\\ownerPhone.txt");
                if(phone.charAt(0)=='9'){
                    phone = '0' + phone;
                }
                ownerPhone.append(phone);
                ownerPhone.close();

                FileWriter ownerPass = new FileWriter("ownerInfo\\ownerPass.txt");
                ownerPass.append(pass);
                ownerPass.close();    
            }
        }catch(IOException e){
            System.out.println("error 404!\npage not found!" + e);
        }
        //Done (first time)

        //for #cls
        System.out.print("\033[H\033[2J");
        System.out.flush();

        String nameLib = "";
        Integer capLib = 0;
        try{
            File libName = new File("ownerInfo\\libName.txt");
            Scanner libNameScanner = new Scanner(libName);
            nameLib = libNameScanner.nextLine();
            libNameScanner.close();

            File libCap = new File("ownerInfo\\libCap.txt");
            Scanner libCapScanner = new Scanner(libCap);
            capLib = Integer.parseInt(libCapScanner.nextLine());
            libCapScanner.close();
        }catch(IOException e){
            System.out.println("error 404!\npage not found!" + e);
        }
        Library library = new Library(nameLib, capLib);

        boolean check = true;
        Scanner cmdScanner = new Scanner(System.in);
        System.out.println("Welcome to " + nameLib + " !");

        while(check){
            System.out.print("\nEnter Your Operate: ");
            String command = cmdScanner.nextLine();
            if(command.equals(null) || command.length()<3){
                System.out.println(RED_BOLD + "Wrong Input !" + RESET);
                continue;
            }
            command = normalizeCommand(command); 
            if(command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("quit")){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                check = false;
                continue;
            }else if(command.equalsIgnoreCase("cls") || command.equalsIgnoreCase("clear")){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                continue;
            }else if(command.equalsIgnoreCase("help")){
                commandHelp();
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

            String tmpOrder = "";
            for(int i=0; i<command.length();i++){
                if(command.charAt(i)==' ') break;
                tmpOrder += command.charAt(i);
            }
            if(!tmpOrder.equalsIgnoreCase("lib")){
                System.out.println(RED_BOLD + "Wrong Input ! " + RESET);
                commandHelp();
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }else{
                command = command.replace(tmpOrder + ' ', "");
                tmpOrder = "";
                for(int i=0; i<command.length(); i++){
                    if(command.charAt(i)==' ') break;
                    tmpOrder += command.charAt(i);
                }
                if(tmpOrder.equalsIgnoreCase("add")){
                    command = command.replace(tmpOrder + ' ', "");
                    tmpOrder = "";
                    for(int i=0; i<command.length(); i++){
                        if(command.charAt(i)==' ') break;
                        tmpOrder += command.charAt(i);
                    }
                    if(tmpOrder.equalsIgnoreCase("book")){

                        command = command.replace(tmpOrder + ' ', "");

                        int count = 0;
                        for(int i=0; i<command.length();i++){
                            if(command.charAt(i)==',') count++;
                        }
                        if(count==2){
                            String bookName = "";
                            String bookAuthor = "";
                            for(int i=0; i<command.length();i++){
                                if(command.charAt(i)!=','){
                                    bookName += command.charAt(i);
                                }else{
                                    break;
                                }
                            }
                            command = command.replace(bookName + ',', "");
                            for(int i=0; i<command.length();i++){
                                if(command.charAt(i)!=','){
                                    bookAuthor += command.charAt(i);
                                }else{
                                    break;
                                }
                            }
                            command = command.replace(bookAuthor+ ',', "");

                            bookName = normalizeCommand(bookName);
                            bookAuthor = normalizeCommand(bookAuthor);
                            command = normalizeCommand(command);

                            library.addBook(bookName, bookAuthor, command);
                        }else{
                            System.out.println(RED_BOLD + "You Blunder Something!" + RESET);
                            commandHelp();
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                        }
                    
                    }else if(tmpOrder.equalsIgnoreCase("member")){

                        command = command.replace(tmpOrder + ' ', "");
                        int count = 0;
                        for(int i=0; i<command.length();i++){
                            if(command.charAt(i)==',') count++;
                        }
                        if(count==1){
                            String studentName = "";
                            for(int i=0; i<command.length(); i++){
                                if(command.charAt(i)!=','){
                                    studentName += command.charAt(i);
                                }else{
                                    break;
                                }
                            }
                            command = command.replace(studentName + ',', "");

                            studentName = normalizeCommand(studentName);
                            command = normalizeCommand(command);

                            boolean isAdmin = false;
                            File passAdminsFile = new File("passwordAdmin.txt");
                            File passOwnerFile = new File("ownerInfo\\ownerPass.txt");
                            try {
                                Scanner ownerScanner = new Scanner(passOwnerFile);
                                if(ownerScanner.nextLine().equals(command)){
                                    isAdmin = true;
                                }
                                ownerScanner.close();
                                Scanner adminScanner = new Scanner(passAdminsFile);
                                while(adminScanner.hasNextLine()){
                                    if(adminScanner.nextLine().equals(command)){
                                        isAdmin = true;
                                        break;
                                    }
                                }
                                adminScanner.close();
                                if(!isAdmin){
                                    System.out.println("The password is incorrect!\nPress Any Key to Back");
                                    Scanner exit = new Scanner(System.in);
                                    String exitStr = exit.nextLine();
                                    exitStr = "";
                                }else{
                                    Scanner getPhone = new Scanner(System.in);
                                    String phoneNumber = "";
                                    while(true){
                                        System.out.println("Type \'quit\' to back");
                                        System.out.print("Enter User Phone Number:");
                                        phoneNumber = getPhone.nextLine();
                                        if(phoneNumber.equalsIgnoreCase("quit")){
                                            break;
                                        }
                                        else if(checkPhone(phoneNumber)){
                                            if(phoneNumber.charAt(0)=='9'){
                                                phoneNumber = '0' + phoneNumber;
                                            }
                                            library.createAccount(studentName, phoneNumber);
                                            System.out.println("Added Succusfully!");
                                            break;
                                        }else{
                                            System.out.println("Error!");
                                            System.out.println("The Phone Number already exists or wront input!");
                                        }
                                    }
                                    
                                }
                            }catch(Exception e){
                                System.out.println("error 404!\npage not found! " + e);
                            }
                        }else{
                            System.out.println(RED_BOLD + "You Blunder Something!" + RESET);
                            commandHelp();
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                        }
                    }else if(tmpOrder.equalsIgnoreCase("admin")){

                        command = command.replace(tmpOrder + ' ' , "");
                        File ownerPass = new File("ownerInfo\\ownerPass.txt");
                        try{
                            Scanner tmpScanner = new Scanner(ownerInfo);
                            if(tmpScanner.nextLine().equals(command)){
                                Scanner addingAddmin = new Scanner(System.in);

                                System.out.print("Type Admin\'s Name: ");
                                String adminName = addingAddmin.nextLine();

                                System.out.print("Type Admin\'s Password: ");
                                String adminPass = addingAddmin.nextLine();

                                Scanner getPhone = new Scanner(System.in);
                                while(true){
                                    System.out.print("Type Admin\'s Phone Number: ");
                                    String adminPhone = getPhone.nextLine();
                                    if(adminPhone.equalsIgnoreCase("quit")){
                                        break;
                                    }else if(checkPhone(adminPhone)){
                                        System.out.println("Admin Added Succusfully!");
                                        if(adminPhone.charAt(0)=='9'){
                                            adminPhone = '0' + adminPhone;
                                        }
                                        library.addAdmin(adminName, adminPhone, adminPass);
                                        break;
                                    }else{
                                        System.out.println("Error!");
                                        System.out.println("The Phone Number already exists or wront input!");
                                        System.out.println("quit or try again:");
                                    }
                                }
                            }else{
                                System.out.println(RED_BOLD + "The password id not belong to the owner!" + RESET);
                            }
                        }catch(IOException e){
                            System.out.println("error 404!\npage not found! " + e);
                        }

                    }else{
                        System.out.println(RED_BOLD + "Wrong Input ! " + RESET);
                        commandHelp();
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                }else if(tmpOrder.equalsIgnoreCase("set")){
                    command = command.replace(tmpOrder + ' ', "");
                    tmpOrder = "";
                    for(int i=0; i<command.length(); i++){
                        if(command.charAt(i)!=' '){
                            tmpOrder +=command.charAt(i);
                        }else{
                            break;
                        }
                    }
                    command = command.replace(tmpOrder + ' ', "");
                    if(tmpOrder.equalsIgnoreCase("hrs")){
                        command = command.replace(tmpOrder + ' ', "");
                        boolean isAdmin = false;
                        try{
                            File ownerPass = new File("ownerInfo\\ownerPass.txt");
                            File passAdminsFile = new File("passwordAdmin.txt");
                            Scanner passOwScanner = new Scanner(ownerPass);
                            if(passOwScanner.nextLine().equals(command)){
                                isAdmin = true;
                            }
                            passOwScanner.close();
                            Scanner passAdScanner = new Scanner(passAdminsFile);
                            while(passAdScanner.hasNextLine() && (!isAdmin)){
                                if(passAdScanner.nextLine().equals(command)){
                                    isAdmin = true;
                                    break;
                                }
                            }
                            passAdScanner.close();
                            if(isAdmin){
                                Scanner setTime = new Scanner(System.in);
                                System.out.print("Type the opening time: ");
                                String open = setTime.nextLine();
                                System.out.print("Type the closing time: ");
                                String close = setTime.nextLine();
                                library.setTime(open, close);
                                System.out.println("Time Set Succusfuly!");
                            }else{
                                System.out.println("The Password id incorrect!");
                                System.out.println("Press Any key to back");
                                Scanner exit = new Scanner(System.in);
                                String exitStr = exit.nextLine();
                                exitStr = "";
                            }
                        }catch(IOException e){
                            System.out.println("error 404!\npage not found! " + e);
                        }
                    }else{
                        System.out.println(RED_BOLD + "You Blunder Something!" + RESET);
                        commandHelp();
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    }
                }else if(tmpOrder.equalsIgnoreCase("get")){
                    command = command.replace(tmpOrder + ' ', "");
                    
                    if(command.equalsIgnoreCase("hrs")){
                        library.getTime();
                        continue;
                    }else if(command.equalsIgnoreCase("books")){
                        library.bookRepository();
                        continue;
                    }
                    tmpOrder = "";
                    for(int i=0; i<command.length(); i++){
                        if(command.charAt(i)!=' '){
                            tmpOrder += command.charAt(i);
                        }else{
                            break;
                        }
                    }
                    command = command.replace(tmpOrder + ' ', "");
                    if(tmpOrder.equalsIgnoreCase("id")){
                        library.getID(command);
                        continue;
                    }else if(tmpOrder.equalsIgnoreCase("bookid")){
                        library.getBookID(command);
                        continue;
                    }else if(tmpOrder.equalsIgnoreCase("available")){
                        if(command.equalsIgnoreCase("books")){
                            library.avaiableBook();
                            continue;
                        }else{
                            System.out.println(RED_BOLD + "You Blunder Something!" + RESET);
                        }    
                    }else if(tmpOrder.equalsIgnoreCase("capacity")){
                        boolean isAdmin = false;
                        try{
                            File ownerPass = new File("ownerInfo\\ownerPass.txt");
                            File passAdminsFile = new File("passwordAdmin.txt");
                            Scanner passOwScanner = new Scanner(ownerPass);
                            if(passOwScanner.nextLine().equals(command)){
                                isAdmin = true;
                            }
                            passOwScanner.close();
                            Scanner passAdScanner = new Scanner(passAdminsFile);
                            while(passAdScanner.hasNextLine() && (!isAdmin)){
                                if(passAdScanner.nextLine().equals(command)){
                                    isAdmin = true;
                                    break;
                                }
                            }
                            passAdScanner.close();
                            if(isAdmin){
                                library.getCapacity();
                                continue;
                            }else{
                                System.out.println("The Password id incorrect!");
                                System.out.println("Press Any key to back");
                                Scanner exit = new Scanner(System.in);
                                String exitStr = exit.nextLine();
                                exitStr = "";
                            }
                        }catch(IOException e){
                            System.out.println("error 404!\npage not found! " + e);
                        }
                    }
                }else if(tmpOrder.equalsIgnoreCase("remove")){
                    command = command.replace(tmpOrder + ' ', "");
                    tmpOrder = "";
                    for(int i=0; i<command.length(); i++){
                        if(command.charAt(i) != ' '){
                            tmpOrder += command.charAt(i);
                        }else{
                            break;
                        }
                    }
                    command = command.replace(tmpOrder + ' ', "");
                    int count = 0;
                    for(int i=0; i<command.length(); i++){
                        if(command.charAt(i) == ',') count++;
                    }
                    if(count==1){
                        if(tmpOrder.equalsIgnoreCase("book")){
                            String id = "";
                            for(int i=0; i<command.length(); i++){
                                if(command.charAt(i)!=','){
                                    id += command.charAt(i);
                                }else{
                                    break;
                                }
                            }
                            command = command.replace(id + ',', "");
                            command = normalizeCommand(command);
                            id = normalizeCommand(id);
                            boolean isAdmin = false;
                            try{
                                File ownerPass = new File("ownerInfo\\ownerPass.txt");
                                File passAdminsFile = new File("passwordAdmin.txt");
                                Scanner passOwScanner = new Scanner(ownerPass);
                                if(passOwScanner.nextLine().equals(command)){
                                    isAdmin = true;
                                }
                                passOwScanner.close();
                                Scanner passAdScanner = new Scanner(passAdminsFile);
                                while(passAdScanner.hasNextLine() && (!isAdmin)){
                                    if(passAdScanner.nextLine().equals(command)){
                                        isAdmin = true;
                                        break;
                                    }
                                }
                                passAdScanner.close();
                                if(!isAdmin){
                                    System.out.println("The Password id incorrect!");
                                    System.out.println("Press Any key to back");
                                    Scanner exit = new Scanner(System.in);
                                    String exitStr = exit.nextLine();
                                    exitStr = "";
                                }
                            }catch(IOException e){
                                System.out.println("error 404!\npage not found! " + e);
                            }
                            if(isAdmin){
                                boolean isId = false;
                                File bookIdFile = new File("bookId.txt");
                                try{
                                    Scanner idScanner = new Scanner(bookIdFile);
                                    while(idScanner.hasNextLine()){
                                        if(id.equals(idScanner.nextLine())){
                                            isId = true;
                                            break;
                                        }
                                    }
                                    idScanner.close();
                                }catch(Exception e){
                                    System.out.println("error 404!\npage not found! " + e);
                                }
                                if(isId){
                                    library.removeBook(Integer.parseInt(id));
                                    System.out.println("Book Removed Succusfully !");
                                }else{
                                    System.out.println(RED_BOLD + "There\'s No Book With This ID !" + RESET);
                                    System.out.println("Press Any key to back");
                                    Scanner exit = new Scanner(System.in);
                                    String exitStr = exit.nextLine();
                                    exitStr = "";
                                }
                            }
                        }else if(tmpOrder.equalsIgnoreCase("member")){
                            String id = "";
                            for(int i=0; i<command.length(); i++){
                                if(command.charAt(i)!=','){
                                    id += command.charAt(i);
                                }else{
                                    break;
                                }
                            }
                            command = command.replace(id + ',', "");
                            command = normalizeCommand(command);
                            id = normalizeCommand(id);
                            boolean isAdmin = false;
                            try{
                                File ownerPass = new File("ownerInfo\\ownerPass.txt");
                                File passAdminsFile = new File("passwordAdmin.txt");
                                Scanner passOwScanner = new Scanner(ownerPass);
                                if(passOwScanner.nextLine().equals(command)){
                                    isAdmin = true;
                                }
                                passOwScanner.close();
                                Scanner passAdScanner = new Scanner(passAdminsFile);
                                while(passAdScanner.hasNextLine() && (!isAdmin)){
                                    if(passAdScanner.nextLine().equals(command)){
                                        isAdmin = true;
                                        break;
                                    }
                                }
                                passAdScanner.close();
                                if(!isAdmin){
                                    System.out.println("The Password id incorrect!");
                                    System.out.println("Press Any key to back");
                                    Scanner exit = new Scanner(System.in);
                                    String exitStr = exit.nextLine();
                                    exitStr = "";
                                }
                            }catch(IOException e){
                                System.out.println("error 404!\npage not found! " + e);
                            }
                            if(isAdmin){
                                boolean isId = false;
                                File userIDFile = new File("NormalUserID.txt");
                                try{
                                    Scanner idScanner = new Scanner(userIDFile);
                                    while(idScanner.hasNextLine()){
                                        if(id.equals(idScanner.nextLine())){
                                            isId = true;
                                            break;
                                        }
                                    }
                                    idScanner.close();
                                }catch(Exception e){
                                    System.out.println("error 404!\npage not found! " + e);
                                }
                                if(isId){
                                    library.removeAccount(id);
                                    System.out.println("Member Removed Succusfully !");
                                }else{
                                    System.out.println(RED_BOLD + "There\'s No Member With This ID !" + RESET);
                                    System.out.println("Press Any key to back");
                                    Scanner exit = new Scanner(System.in);
                                    String exitStr = exit.nextLine();
                                    exitStr = "";
                                }
                            }
                        }else{
                            System.out.println(RED_BOLD + "You Blunder Something!" + RESET);
                            continue;
                        }
                    }else{
                        System.out.println(RED_BOLD + "You Blunder Something!" + RESET);
                        continue;
                    }
                    
                }else if(tmpOrder.equalsIgnoreCase("rent")){
                    command = command.replace(tmpOrder + ' ', "");
                    int count = 0;
                    for(int i=0; i<command.length(); i++){
                        if(command.charAt(i)==',') count++;
                    }
                    if(count==1){
                        String bookID = "";
                        for(int i=0; i<command.length(); i++){
                            if(command.charAt(i)!=','){
                                bookID += command.charAt(i);
                            }else{
                                break;
                            }   
                        }
                        command = command.replace(bookID + ',', "");

                        bookID = normalizeCommand(bookID);
                        command = normalizeCommand(command);

                        File bookIdFile = new File("bookId.txt");
                        File userIDFile = new File("NormalUserID.txt");
                        boolean isUser = false;
                        try{
                            Scanner userIDScanner = new Scanner(bookIdFile);
                            while(userIDScanner.hasNextLine()){
                                if(userIDScanner.nextLine().equals(command)){
                                    isUser = true;
                                    break;
                                }
                            }
                            userIDScanner.close();
                            if(!isUser){
                                System.out.println(RED_BOLD + "User ID Is Incorrect !" + RESET);
                                continue;
                            }else{
                                boolean isBook = false;
                                Scanner bookIDScanner = new Scanner(bookIdFile);
                                while(bookIDScanner.hasNextLine()){
                                    if(bookIDScanner.nextLine().equals(bookID)){
                                        isBook = true;
                                        break;
                                    }
                                }
                                bookIDScanner.close();
                                if(!isBook){
                                    System.out.println(RED_BOLD + "Book ID Is Incorrect !" + RESET);
                                    continue;
                                }else{
                                    library.addRent(bookID, command);
                                    System.out.println("Rented Succusfully !");
                                }
                            }
                        }catch(IOException e){
                            System.out.println("error 404!\npage not found! " + e);
                        }
                    }else{
                        System.out.println(RED_BOLD + "You Blunder Something!" + RESET);
                        continue;
                    }
                }else if(tmpOrder.equalsIgnoreCase("return")){
                    command = command.replace(tmpOrder + ' ', "");
                    File bookName = new File("rentBookName.txt");
                    try{
                        boolean isRent = false;
                        Scanner nameScanner = new Scanner(bookName);
                        while(nameScanner.hasNextLine()){
                            if(nameScanner.nextLine().equals(command)){
                                isRent = true;
                                break;
                            }
                        }
                        nameScanner.close();
                        if(!isRent){
                            System.out.println("Error! This Book Is Not Rented!");
                            continue;
                        }else{
                            library.returnBook(command);
                            System.out.println("Succusfull !");
                            continue;
                        }
                    }catch(IOException e){
                        System.out.println("error 404!\npage not found! " + e);
                    }
                }else{
                    System.out.println(RED_BOLD + "You Blunder Something!" + RESET);
                    continue;
                }
            }
    
        }
    }

    //for normalizing user operate command
    public static String normalizeCommand(String command){
        command = command.replaceAll("\\s+", " ");
        char[] tmp = command.toCharArray();
        int indexOfBegin = 0;
        int indexOfEnd = command.length();
        command = "";
        for(int i = indexOfBegin;;i++){
            if(tmp[i]>='a' && tmp[i]<='z') break;
            if(tmp[i]>='A' && tmp[i]<='Z') break;
            if(tmp[i]==' ')
                indexOfBegin++;
        }
        for(int i=indexOfEnd-1;;i--){
            if(tmp[i]==' '){
                indexOfEnd--;
            }else{
                break;
            }
        }
        for(int i=indexOfBegin; i<indexOfEnd; i++){
            command += tmp[i];
        }
        return command;
    }

    public static void commandHelp(){
        System.out.println("Type \'Help\' Whenever You Need help!");
        System.out.println();
        System.out.println("Type: " + GREEN + "\'lib add book <title>, <author>, <subtitle>\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib get hrs\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib set hrs <password>\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib rent <bookID>, <userID>\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib get ID <phoneNumber>\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib get bookID <bookName>\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib add member <StudentName>, <password>\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib get avaiable Books\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib get books\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib get Capacity <password>\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib remove book <bookID>, <password>\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib remove member <userID>, <password>\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib return <bookName>\'" + RESET);
        System.out.println("Type: " + GREEN + "\'lib add Admin <ownerPassword>\'" + RESET);
        System.out.println("\nPress Enter key to Back");
        Scanner exit = new Scanner(System.in);
        String exitStr = exit.nextLine();
        exitStr = "";

        //Why can't i use this
        /* 
        try{
            System.in.read();
        }  
        catch(Exception e){
            System.out.println("error 404!\npage not found! " + e);
        }
        */
    }

    public static boolean checkPhone(String phoneNumber){
        File phoneUserFile = new File("NormalPhoneNumber.txt");
        File phoneNumberFile = new File("AdminPhoneNumber.txt");
        File ownerPhone = new File("ownerInfo\\ownerPhone.txt");
        try{
            Scanner tmpNoScanner = new Scanner(phoneUserFile);
            Scanner tmpAdScanner = new Scanner(phoneNumberFile);
            Scanner tmpOwScanner = new Scanner(ownerPhone);
            if(tmpOwScanner.nextLine().equals(phoneNumber)){
                tmpOwScanner.close();
                return false;
            }
            while(tmpNoScanner.hasNextLine()){
                if(tmpNoScanner.nextLine().equals(phoneNumber)){
                    tmpNoScanner.close();
                    return false;
                }
            }
            while(tmpAdScanner.hasNextLine()){
                if(tmpAdScanner.nextLine().equals(phoneNumber)){
                    tmpAdScanner.close();
                    return false;
                }
            }
        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
        phoneNumber = phoneNumber.replace(" ", "");
        if(phoneNumber.charAt(0)=='0'){
            if(phoneNumber.length()==11){
                for(int i=0; i<phoneNumber.length(); i++){
                    if(phoneNumber.charAt(i)>='0' && phoneNumber.charAt(i)<='9'){
                        continue;
                    }
                    return false;
                }
                return true;
            }else{
                return false;
            }
        }else if(phoneNumber.charAt(0)=='9'){
            if(phoneNumber.length()==10){
                for(int i=0; i<phoneNumber.length(); i++){
                    if(phoneNumber.charAt(i)>='0' && phoneNumber.charAt(i)<='9'){
                        continue;
                    }
                    return false;
                }
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

}

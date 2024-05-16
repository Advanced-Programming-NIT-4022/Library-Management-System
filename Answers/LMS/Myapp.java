


import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Myapp {

    public static void firstTime() {
        Scanner strSc = new Scanner(System.in);
        Scanner intSc = new Scanner(System.in);
        File ownerInfo = new File("ownerInfo");
        try {
            if (ownerInfo.mkdir()) {
                System.out.println("Hi!");
                System.out.println("You Are Owner Of This Library And You Should Make Some Choices;Please Pay Attention To Your Choices;");
                System.out.println("Because after You Chose Them,It\'s Impossible To Change;");
                System.out.println("Now,Fill Out. ");
                FileWriter libName = new FileWriter("ownerInfo\\LibName.txt", true);
                System.out.println("Library Name: ");
                String nameLib = strSc.nextLine();
                libName.append(nameLib);
                libName.close();

                FileWriter libCap = new FileWriter("ownerInfo\\LibCap.txt", true);
                System.out.println("Library Capacity: ");
                Integer capLib = intSc.nextInt();
                libCap.append(capLib.toString());
                libCap.close();

                FileWriter ownerName = new FileWriter("ownerInfo\\ownerName.txt", true);
                System.out.println("Owner Name: ");
                String nameOwner = strSc.nextLine();
                ownerName.append(nameOwner);
                ownerName.close();

                FileWriter ownerId = new FileWriter("ownerInfo\\ownerID.txt", true);
                System.out.println("Owner ID: ");
                String IdOwner = strSc.nextLine();
                ownerId.append(IdOwner);
                ownerId.close();

                FileWriter ownerPhone = new FileWriter("ownerInfo\\ownerPhone.txt", true);
                System.out.println("Owner PhoneNumber: ");
                String phoneOwner = strSc.nextLine();
                ownerPhone.append(phoneOwner);
                ownerPhone.close();

                FileWriter ownerPass = new FileWriter("ownerInfo\\ownerPassword.txt", true);
                System.out.println("Owner Password: ");
                String passOwner = strSc.next();
                ownerPass.append(passOwner);
                ownerPass.close();
            }
        } catch (Exception e) {
            System.out.println("error 404!\npage not found!");
        }

    }

    // start
    public static void main(String[] args) {

        firstTime();
        String nameLibrary = "";
        Integer capLibrary = 0;
        try {
            File libNameFile = new File("ownerInfo\\LibName.txt");
            Scanner nameLibScanner = new Scanner(libNameFile);
            nameLibrary = nameLibScanner.nextLine();
            nameLibScanner.close();

            File libCapFile = new File("ownerInfo\\LibCap.txt");
            Scanner capLibScanner = new Scanner(libCapFile);
            capLibrary = capLibScanner.nextInt();
            capLibScanner.close();

        } catch (Exception e) {
            System.out.println("error 404!\npage not found!");
        }

        Library library = new Library(nameLibrary, capLibrary);
        Scanner orderScanner = new Scanner(System.in);
        System.out.println("Choose Your roll:\n1.Admin\n2.Normal User");
        String choice = orderScanner.nextLine();
        //Scanner for admins order
        Scanner adminScanner = new Scanner(System.in);

        while (true) {
            switch (choice) {
                case "1":
                    System.out.println("Wellcome To " + nameLibrary  +"!"+ "\nDear Admin!" + "\n");
                    System.out.println("Note: If You Have No Idea About Using This Library, Just Type \"lib get help\" To Read Guid Book.");
                    System.out.println("What Do You Want? ");
                    String adminOrder = adminScanner.nextLine();
                    String[] adminOrd = adminOrder.split(" ");
                    if (adminOrder.length() < 2 || adminOrder.equals("") || adminOrder.equals(null)) {
                        System.out.println("Wrong Entry!");
                    }

                        String finalOrd = "";
                        String newOrd = adminOrder;

                        for (; ; ) {
                            newOrd = newOrd.trim();
                            String someOrd = "";
                            for (int i = 0; i < newOrd.length(); i++) {
                                if (newOrd.charAt(i) != ' ') {
                                    someOrd += newOrd.charAt(i);
                                } else {
                                    finalOrd += (someOrd + " ");
                                    newOrd = newOrd.replace(someOrd, "");
                                    break;
                                }
                            }
                            if (someOrd.equals(newOrd)) {
                                finalOrd += (someOrd + " ");
                                newOrd = newOrd.replace(someOrd, "");
                                break;
                            }
                            if (newOrd.equals(""))
                                break;
                        }


                    String[] correctOrd = finalOrd.split(" ");
                    if(correctOrd.length < 3 || correctOrd.length > 5 ){
                        System.out.println("Wrong Entry!");
                    }else{
                        if(correctOrd[0].equalsIgnoreCase("lib") && correctOrd.length == 5){
                            if(correctOrd[1].equalsIgnoreCase("add")){
                                if(correctOrd[2].equalsIgnoreCase("user")) {
                                    System.out.println("Enter User PhoneNumber:");
                                    String phUser = orderScanner.next();

                                    try {
                                        File passAdminsFile = new File("passwordAdmin.txt");
                                        Scanner passScan = new Scanner(passAdminsFile);
                                        boolean isOk = false;
                                        while (passScan.hasNextLine()) {
                                            if (correctOrd[4].equals(passScan.nextLine())) {
                                                library.createAccount(correctOrd[3] , phUser);
                                                break;
                                            }
                                        }

                                        if (isOk == false) {
                                            System.out.println("Wrong Entry!");
                                        }
                                        passScan.close();
                                    }catch (IOException e){
                                        System.out.println("Error 404\nPage Not Found!" + e);
                                    }
                                }else if(correctOrd[2].equalsIgnoreCase("book")){
                                    System.out.println("Add A Description For Book: ");
                                    String desBook = orderScanner.nextLine();
                                    library.addBook(correctOrd[3] , correctOrd[4] , desBook);
                                }else {
                                    System.out.println("Wrong Entry!");
                                }
                            }else{
                                System.out.println("Wrong Entry!");
                            }
                        }else if(correctOrd[0].equalsIgnoreCase("lib") && correctOrd.length == 3){
                            if(correctOrd[1].equalsIgnoreCase("set") && correctOrd[2].equalsIgnoreCase("time")){
                                System.out.println("Set OpenTime:");
                                String open = orderScanner.nextLine();
                                System.out.println("Set CloseTime:");
                                String close = orderScanner.nextLine();
                                library.setTime(open , close);
                            }else if(correctOrd[1].equalsIgnoreCase("show") && correctOrd[2].equalsIgnoreCase("members")){
                                library.showMembers();
                            }
                        }else if(correctOrd[0].equalsIgnoreCase("lib") && correctOrd.length == 4){
                            if(correctOrd[1].equalsIgnoreCase("remove")){
                                if(correctOrd[2].equalsIgnoreCase("member")){
                                    try {
                                        File userIDFile = new File("NormalUserID.txt");
                                        Scanner fileScan = new Scanner(userIDFile);
                                        boolean isOK = false;
                                        while (fileScan.hasNextLine()){
                                            if(correctOrd[3].equals(fileScan.nextLine())){
                                                isOK = true;
                                                break;
                                            }
                                        }
                                        if(isOK){
                                            library.removeAccount(correctOrd[3]);
                                        }else {
                                            System.out.println("This ID Not Found.");
                                        }
                                    }catch (IOException e){
                                        System.out.println("Error 404\nPage Not Found!" + e);
                                    }


                                }else if(correctOrd[2].equalsIgnoreCase("book")){
                                    try{
                                        File bookIdFile = new File("bookId.txt");
                                        Scanner fileSc = new Scanner(bookIdFile);
                                        boolean isIT = false;
                                        while (fileSc.hasNextLine()){
                                            if(correctOrd[3].equals(fileSc.nextLine())){
                                                isIT = true;
                                                break;
                                            }
                                        }
                                        if (isIT) {
                                            library.removeBook(Integer.parseInt(correctOrd[3]));
                                        } else {
                                            System.out.println("This ID Not Found.");
                                        }
                                    } catch (IOException e) {
                                        System.out.println("Error 404\nPage Not Found!" + e);
                                    }
                                }
                            }
                        } else if (correctOrd[1].equalsIgnoreCase("get") && correctOrd.length == 3) {
                            if (correctOrd[2].equalsIgnoreCase("books")) {
                                library.bookRepository();
                            }
                        } else if (correctOrd[1].equalsIgnoreCase("get") && correctOrd.length == 3) {
                            if (correctOrd[2].equalsIgnoreCase("help")) {
                                System.out.println("Dear Admin!");
                                System.out.println("To Add A User, Type \"lib add user\" Then UserName.");
                                System.out.println("To Set Pprating Time, Type \"lib set time\" .");
                                System.out.println("To Add A Book, Type \"lib add book\" Then book\'s Name (space) Then book\'Author.");
                                System.out.println("To Remove A Book, Type \"lib remove book\" Then Book\'s ID.");
                                System.out.println("To See Scheduel Of Books, Type \"lib get books\" .");
                                System.out.println("To Remove A Member, Type \"lib remove member\" Then Member\'s ID.");
                                System.out.println("To See Members Information, Type \"lib sho members\" .");
                                System.out.println("Enter 0 To Turn Back.");
                                String order = orderScanner.nextLine();
                                for (; ; ) {
                                    String adminOrder1 = orderScanner.nextLine();
                                    if (adminOrder1.equals("0")) {
                                        break;
                                    } else {
                                        System.out.println("Wrong Entry.\nTry Again.");
                                    }
                                }
                            }
                        }
                    }
                    break;
                    //admin



                case "2":
                    for (; ; ) {
                        System.out.println("Wellcome To " + nameLibrary + "!\n");
                        System.out.println("Note: If You Have No Idea About Using This Library, Just Type \"lib get help\" To Read Guid Book.");
                        System.out.println("What Do You Want? ");
                        String ord = orderScanner.nextLine();
                        if (ord.length() < 2 || ord.equals("") || ord.equals(null)) {
                            System.out.println("Wrong Entry!");
                        }
                        finalOrd = "";
                         newOrd = ord;
                        for (; ; ) {
                            newOrd = newOrd.trim();
                            String someOrd = "";
                            for (int i = 0; i < newOrd.length(); i++) {
                                if (newOrd.charAt(i) != ' ') {
                                    someOrd += newOrd.charAt(i);
                                } else {
                                    finalOrd += (someOrd + " ");
                                    newOrd = newOrd.replace(someOrd, "");
                                    break;
                                }
                            }
                            if (someOrd.equals(newOrd)) {
                                finalOrd += (someOrd + " ");
                                newOrd = newOrd.replace(someOrd, "");
                                break;
                            }
                            if (newOrd.equals(""))
                                break;
                        }

                        //next orders
                        String correctOrd1[] = finalOrd.split(" ");

                        if (correctOrd1[0].equals("lib")) {
                            if (correctOrd1[1].equalsIgnoreCase("join")) {
                                System.out.println("Enter Your Name:");
                                String normalName = orderScanner.nextLine();
                                System.out.println("Enter Your Phone Number:");
                                String normalPhone = orderScanner.nextLine();
                                library.createAccount(normalName, normalPhone);

                            } else if (correctOrd1[1].equalsIgnoreCase("rent")) {
                                if (correctOrd1.length < 4) {
                                    System.out.println("Wrong Entry!");
                                } else {
                                    try {
                                        File bookIdFile = new File("bookId.txt");
                                        Scanner bookScanner = new Scanner(bookIdFile);
                                        boolean isBookID = false;
                                        while (bookScanner.hasNextLine()) {
                                            if (correctOrd1[2].equals(bookScanner.nextLine())) {
                                                isBookID = true;
                                                break;
                                            }
                                        }
                                        File userIDFile = new File("NormalUserID.txt");
                                        Scanner userScanner = new Scanner(userIDFile);
                                        boolean isUserID = false;
                                        while (userScanner.hasNextLine()) {
                                            if (correctOrd1[3].equals(userScanner.nextLine())) {
                                                isUserID = true;
                                                break;
                                            }
                                        }
                                        userScanner.close();

                                        if (isBookID && isUserID) {
                                            Integer bookID = Integer.parseInt(correctOrd1[2]);
                                            Integer userID = Integer.parseInt(correctOrd1[3]);
                                            library.addRent(bookID, userID);

                                        } else {
                                            System.out.println("Wrong Entry!");
                                        }

                                    } catch (IOException e) {
                                        System.out.println("error 404!\npage not found!" + e);
                                    }
                                }
                            } else if (correctOrd1[1].equalsIgnoreCase("return")) {
                                if (correctOrd1.length < 3 || correctOrd1.length > 3) {
                                    System.out.println("Wrong Entry!");
                                } else {
                                    try {
                                        File forReturnNameBook = new File("rentBookName.txt");
                                        Scanner forReturnSc = new Scanner(forReturnNameBook);
                                        boolean isOk = false;
                                        while (forReturnSc.hasNextLine()) {
                                            if (correctOrd1[2].equals(forReturnSc.nextLine())) {
                                                isOk = true;
                                                break;
                                            }
                                        }
                                        if (isOk) {
                                            library.returnBook(correctOrd1[2]);
                                            System.out.println("done!");
                                        } else {
                                            System.out.println("Wrong Entry!");
                                        }
                                    } catch (IOException e) {
                                        System.out.println("error 404!\npage not found!" + e);
                                    }

                                }
                            } else if (correctOrd1[1].equalsIgnoreCase("get")) {
                                if (correctOrd1.length < 3 || correctOrd1.length > 4) {
                                    System.out.println("Wrong Entry!");
                                } else if (correctOrd1.length == 3) {
                                    switch (correctOrd1[2]) {
                                        case "My":
                                        case "my":
                                            if (correctOrd1[3].equals("ID")) {
                                                System.out.println("What Is Your PhoneNumber?");
                                                String phone = orderScanner.nextLine();
                                                library.getID(phone);
//                                                try {
//                                                    File userNameFile = new File("NormalUserName.txt");
//                                                    Scanner nameScan = new Scanner(userNameFile);
//                                                    int indx = 1;
//                                                    int tmpindx = 0;
//                                                    while (nameScan.hasNextLine()) {
//                                                        if (name.equals(nameScan.nextLine())) {
//                                                            tmpindx = indx;
//                                                            break;
//                                                        }
//                                                        indx++;
//                                                    }
//                                                    nameScan.close();
//                                                    File userIDFile = new File("NormalUserID.txt");
//                                                    Scanner IdScan = new Scanner(userIDFile);
//                                                    indx = 1;
//                                                    while (IdScan.hasNextLine()) {
//                                                        if (indx == tmpindx) {
//                                                            System.out.println(IdScan.nextLine());
//                                                            break;
//                                                        }
//                                                        indx++;
//                                                    }
//                                                } catch (IOException e) {
//                                                    System.out.println("error 404!\npage not found!" + e);
//                                                }
                                            } else {
                                                System.out.println("Wrong Entry!");
                                            }
                                            break;

                                        case "hrs":
                                            library.getTime();
                                            break;

                                        case "Help":
                                        case "help":
                                            System.out.println("At First Tou Have To Join And Then Use Library Options. To Join Library, Type \"lib join\" ");
                                            System.out.println("To Rent A book, Type \"lib rent\" And Type Book ID (space) Then Your ID.");
                                            System.out.println("To See Your ID, Type \"lib get My ID\" .");
                                            System.out.println("To Return A Rented Book, Type \"lib return\" And Then Book Name.");
                                            System.out.println("To See Library Operating Hours, type \"lib get hrs\" .");
                                            System.out.println("To See Available Books And Their ID, Type \"lib get available books\" .");
                                            System.out.println("Now Enter 0 To Turn Back.");
                                            for (; ; ) {
                                                String forBack = orderScanner.nextLine();
                                                if (forBack.equals("0")) {
                                                    break;
                                                } else {
                                                    System.out.println("Wrong Entry.\nTry Again.");
                                                }
                                            }
                                            break;

                                        default:
                                            System.out.println("Wrong Entry!");
                                    }
                                }
                            } else {
                                if (correctOrd1[2].equals("available") && correctOrd1[3].equals("books")) {
                                    library.bookRepository();
                                } else {
                                    System.out.println("Wrong Entry!");
                                }
                            }
                        }
                    }
                default:
                    System.out.println("Wrong Entry!");
            }
        }
    }

}



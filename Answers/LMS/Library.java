import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy,MMM,dd HH:mm");
    Book newBooks = new Book();
    User newNormalUsers = new NormalUser("NormalUserName", "NormalUserID", "NormalPhoneNumber");
    User newAdmins = new Admin("AdminUserName", "AdminUserID", "AdminPhoneNumber");
    Rent newRent = new Rent();
    private String libraryName;
    private int libraryCapacity;
    private Integer bookCounter = -1 ;

    private String openTime = "Not Set!";
    private String closeTime = "Not Set!";

    public Library(String libraryName , int libraryCapacity) {
        this.libraryName = libraryName;
        this.libraryCapacity = libraryCapacity;
        setCounter();
    }
    
    private void setCounter(){
        try{
            File myCounter = new File("ownerInfo\\Counter.txt");
            if(myCounter.createNewFile()){
                FileWriter countWriter = new FileWriter("ownerInfo\\Counter.txt");
                countWriter.write("0");
                bookCounter = 0;
                countWriter.close();
            }else{
                Scanner counterScanner = new Scanner(myCounter);
                bookCounter = Integer.parseInt(counterScanner.nextLine());
                counterScanner.close();
            }
        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
    }
    
    public String getLibraryName(){
        return libraryName;
    }
    
    public void getCapacity(){
        System.out.println("Full Capacity: "+(libraryCapacity));
        System.out.println("Free Capacity: "+ (libraryCapacity-bookCounter));
    }

    public void setTime(String openTime , String closeTime){
        this.openTime = openTime;
        this.closeTime = closeTime;
    }
    
    public void getTime(){
        System.out.println("OpenTime: " + openTime);
        System.out.println("CloseTime: " + closeTime);
    }
    
    public void bookRepository(){
        int index = 1;
        File bookIdFile = new File("bookId.txt");
        File titleFile = new File("titleBook.txt");
        File authorFile = new File("authorBook.txt");
        File statusFile = new File("statusBook.txt");
        File descriptionFile = new File("descriptionBook.txt");

        try{
            Scanner titleScanner = new Scanner(titleFile);
            Scanner authorScanner = new Scanner(authorFile);
            Scanner statusScanner = new Scanner(statusFile);
            Scanner descriptionScanner = new Scanner(descriptionFile);
            Scanner idScanner = new Scanner(bookIdFile);

            while(titleScanner.hasNextLine()){
                System.out.print(index + ". ");
                System.out.println(titleScanner.nextLine());
                System.out.print("\tAuthor: ");
                System.out.println(authorScanner.nextLine());
                System.out.print("\tAbout This Book: ");
                System.out.println(descriptionScanner.nextLine());
                System.out.println("\tID: " + idScanner.nextLine());
                System.out.print("\tAvailability Status: ");
                if(statusScanner.nextLine().equals("true")){
                    System.out.println("Avilable");
                }else{
                    System.out.println("Not Avilable");
                }
                System.out.println("__________________________________________\n");
                index++;
            }  
            idScanner.close();
            titleScanner.close();
            authorScanner.close();
            descriptionScanner.close();
            statusScanner.close();
        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
    }

    public void avaiableBook(){
        int index = 1;
        File bookIdFile = new File("bookId.txt");
        File titleFile = new File("titleBook.txt");
        File authorFile = new File("authorBook.txt");
        File statusFile = new File("statusBook.txt");
        File descriptionFile = new File("descriptionBook.txt");

        try{
            Scanner titleScanner = new Scanner(titleFile);
            Scanner authorScanner = new Scanner(authorFile);
            Scanner statusScanner = new Scanner(statusFile);
            Scanner descriptionScanner = new Scanner(descriptionFile);
            Scanner idScanner = new Scanner(bookIdFile);

            while(titleScanner.hasNextLine()){
                String title = titleScanner.nextLine();
                String author = authorScanner.nextLine();
                String description = descriptionScanner.nextLine();
                String id = idScanner.nextLine();
                if(statusScanner.nextLine().equals("true")){
                    System.out.println(". " + title);
                    System.out.println("\tAuthor: " + author);
                    System.out.println("\tAbout This Book: " + description);
                    System.out.println("\tID: " + id);
                    System.out.println();
                }
            }  
            idScanner.close();
            titleScanner.close();
            authorScanner.close();
            descriptionScanner.close();
            statusScanner.close();
        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
    }
    
    public void addBook(String bookName , String bookAuthor , String description){
        if(bookCounter<libraryCapacity){
            File bookIdFile = new File("bookId.txt");
            File titleFile = new File("titleBook.txt");
            File authorFile = new File("authorBook.txt");
            File statusFile = new File("statusBook.txt");
            File descriptionFile = new File("descriptionBook.txt");
            try{
                FileWriter titleWriter = new FileWriter("titleBook.txt", true);
                titleWriter.append(bookName + "\n");
                titleWriter.close();
    
                FileWriter authorWriter = new FileWriter("authorBook.txt", true);
                authorWriter.append(bookAuthor + "\n");
                authorWriter.close();
    
                FileWriter descriptionWriter = new FileWriter("descriptionBook.txt", true);
                descriptionWriter.append(description + "\n");
                descriptionWriter.close();
    
                FileWriter statusWriter = new FileWriter("statusBook.txt", true);
                statusWriter.append("true");
                statusWriter.close();
    
                boolean isId = true;
                for(;;){
                    Scanner idScanner = new Scanner(bookIdFile);
                    Integer id = (int)(Math.random()*1000001);
                    while (idScanner.hasNextLine()){
                        if(idScanner.nextLine().equals(id.toString())){
                            isId = false;
                            break;
                        }
                    }
                    idScanner.close();
                    if(isId){
                        FileWriter idWriter = new FileWriter("bookId.txt" , true);
                        idWriter.append(id.toString());
                        idWriter.close();
                        break;
                    }
                }  
            }catch(IOException e){
                System.out.println("error 404!\npage not found! " + e);
            }

            bookCounter++;
            try{
                File myCounter = new File("ownerInfo\\Counter.txt");
                FileWriter countWriter = new FileWriter("ownerInfo\\Counter.txt");
                countWriter.write(bookCounter.toString());
                countWriter.close();
            }catch(IOException e){
                System.out.println("error 404!\npage not found! " + e);
            }

            System.out.println("Book Added Succusfully! ");
        }else{
            System.out.println("The Library Is Full! ");
        }
    }

    public void getID(String phoneNumber){
        int index = 1;
        boolean isShow = false;
        File userPhone = new File("NormalPhoneNumber.txt");
        File userID = new File("NormalUserID.txt");

        File passAdminsFile = new File("AdminPhoneNumber.txt");
        File userIDFile = new File("AdminUserID.txt");
        phoneNumber = phoneNumber.replace(" ","");
        try{
            Scanner phoneScanner = new Scanner(userPhone);
            int tmpIndex = 1;
            while(phoneScanner.hasNextLine()){
                if(phoneScanner.nextLine().equals(phoneNumber)){
                    index = tmpIndex;
                    isShow = true;
                    break;
                }
                tmpIndex++;
            }
            phoneScanner.close();
            
            tmpIndex = 1;
            Scanner idScanner = new Scanner(userID);
            while(idScanner.hasNextLine()){
                if(tmpIndex == index){
                    System.out.println(idScanner.nextLine());
                    break;
                }
                tmpIndex++;
            }
            idScanner.close();

            Scanner adminPhone = new Scanner(userPhone);
            tmpIndex = 1;
            while(adminPhone.hasNextLine()){
                if(adminPhone.nextLine().equals(phoneNumber)){
                    index = tmpIndex;
                    isShow = true;
                    break;
                }
                tmpIndex++;
            }
            adminPhone.close();
            
            tmpIndex = 1;
            Scanner adminID = new Scanner(userID);
            while(adminID.hasNextLine()){
                if(tmpIndex == index){
                    System.out.println(adminID.nextLine());
                    break;
                }
                tmpIndex++;
            }
            adminID.close();
            if(!isShow){
                System.out.println("There\'s No ID With This Phone Number! ");
            }
        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
    }

    public void addRent(String idBook , String idUser){
        File bookIdFile = new File("bookId.txt");
        File titleFile = new File("titleBook.txt");
        File userIDFile = new File("NormalUserID.txt");
        File userNameFile = new File("NormalUserName.txt");
        File rentDate = new File("rentDate.txt");

        File statusFile = new File("statusBook.txt");

        int index = 1;
        try{
            Scanner scIdBook = new Scanner(bookIdFile);
            while(scIdBook.hasNextLine()){
                if(idBook.equals(scIdBook.nextLine())){
                    FileWriter writeIdBook = new FileWriter("rentBookID.txt" , true);
                    writeIdBook.append(idBook.toString()+"\n");
                    writeIdBook.close();
                    break;
                }
                index++;
            }
            scIdBook.close();

            //edit statusFile
            ArrayList<String> tmp = new ArrayList<>();
            Scanner scStatus = new Scanner(statusFile);
            int indexTmp = 1;
            while ((scStatus.hasNextLine())) {
                if(indexTmp != index){
                    tmp.add(scStatus.nextLine());
                }else{
                    String tmpStr = scStatus.nextLine();
                    tmpStr = "";
                    tmp.add("false");
                }
                indexTmp++;
            }
            scStatus.close();
            FileWriter editStatus = new FileWriter("statusBook.txt");
            for(int i=0 ; i<tmp.size() ; i++){
                editStatus.append(tmp.get(i) + "\n");
            }
            editStatus.close();
            tmp.clear();
            //done 

            Scanner scNameBook = new Scanner(titleFile);
            indexTmp = 1;
            while(scNameBook.hasNextLine()){
                if(indexTmp == index){
                    FileWriter writeNameBook = new FileWriter("rentBookName.txt" , true);
                    writeNameBook.append(scNameBook.nextLine() + "\n");
                    writeNameBook.close();
                    break;
                }else{
                    String tmpStr = scNameBook.nextLine();
                    tmpStr = "";
                }
                indexTmp++;
            }
            scNameBook.close();

            Scanner scIdUser = new Scanner(userIDFile);
            index = 1;
            while(scIdUser.hasNextLine()){
                if(scIdUser.nextLine().equals(idUser)){
                    FileWriter writeIdUser = new FileWriter("rentUserID.txt" , true);
                    writeIdUser.append(idUser + "\n");
                    writeIdUser.close();
                    break;
                }
                index++;
            }
            scIdUser.close();

            Scanner scUserName = new Scanner(userNameFile);
            indexTmp = 1;
            while (scUserName.hasNextLine()) {
                if(indexTmp == index){
                    FileWriter writeUserName = new FileWriter("rentUserName.txt" , true);
                    writeUserName.append(scUserName.nextLine() + "\n");
                    writeUserName.close();
                    break;
                }else{
                    String tmpStr = scUserName.nextLine();
                    tmpStr = "";
                }
                indexTmp++;
            }
            scUserName.close();
            
            FileWriter writeDate = new FileWriter("rentDate.txt", true);
            LocalDateTime rentalDate = LocalDateTime.now();
            writeDate.append(rentalDate.format(formater) + "\n");
            writeDate.close();

        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
        System.out.println("Succusfull !");
    }

    public void removeBook(Integer id){
        File bookIdFile = new File("bookId.txt");
        File titleFile = new File("titleBook.txt");
        File authorFile = new File("authorBook.txt");
        File statusFile = new File("statusBook.txt");
        File descriptionFile = new File("descriptionBook.txt");

        File trashTitleFile = new File("trashTitleBook.txt");
        File trashAuthorFile = new File("trashAuthorBook.txt");
        File trashStatusFile = new File("trashStatusBook.txt");
        File trashDescriptionFile = new File("trashDescriptionBook.txt");

        try{
            boolean isTrashTitle = trashTitleFile.createNewFile();
            boolean isTrashAuthor = trashAuthorFile.createNewFile();
            boolean isTrashStatus = trashStatusFile.createNewFile();
            boolean isTrashDescription = trashDescriptionFile.createNewFile();
            
            int tmpIndex = 1;
            int index = 0;
            ArrayList<String> tmp = new ArrayList<>();
            
            //edit id
            Scanner idScanner = new Scanner(bookIdFile);
            while(idScanner.hasNextLine()){
                String tmpStr = idScanner.nextLine();
                if(!id.toString().equals(tmpStr)){
                    tmp.add(tmpStr);
                }else{
                    FileWriter trashFileWriter = new FileWriter("trashBookID.txt" , true);
                    trashFileWriter.append(tmpStr + "\n");
                    trashFileWriter.close();
                    index = tmpIndex;
                }
                tmpStr = "";
                tmpIndex++;
            }
            idScanner.close();
            FileWriter editID = new FileWriter("bookId.txt");
            for(int i=0; i<tmp.size(); i++){
                editID.append(tmp.get(i) + "\n");
            }
            tmp.clear();
            editID.close();
            //done

            tmpIndex = 1;
            //edit title
            Scanner titleScanner = new Scanner(titleFile);
            while(titleScanner.hasNextLine()){
                if(tmpIndex != index){
                    tmp.add(titleScanner.nextLine());
                }else{
                    FileWriter trashFileWriter = new FileWriter("trashTitleBook.txt" , true);
                    trashFileWriter.append(titleScanner.nextLine() + "\n");
                    trashFileWriter.close();
                }
                tmpIndex++;
            }
            titleScanner.close();
            FileWriter editTitle = new FileWriter("titleBook.txt");
            for(int i=0 ; i<tmp.size() ; i++){
                editTitle.append(tmp.get(i) + "\n");
            }
            editTitle.close();
            tmp.clear();
            //done

            tmpIndex = 1;
            //edit author
            Scanner authorScanner = new Scanner(authorFile);
            while (authorScanner.hasNextLine()) {
                if(tmpIndex!=index){
                    tmp.add(authorScanner.nextLine());
                }else{
                    FileWriter trashFileWriter = new FileWriter("trashAuthorBook.txt" , true);
                    trashFileWriter.append(authorScanner.nextLine() + "\n");
                    trashFileWriter.close();
                }
                tmpIndex++;
            }
            authorScanner.close();
            FileWriter editAuthor = new FileWriter("authorBook.txt");
            for(int i=0; i<tmp.size();i++){
                editAuthor.append(tmp.get(i) + "\n");
            }
            editAuthor.close();
            tmp.clear();
            //done

            tmpIndex = 1;
            //edit description
            Scanner descriptionScanner = new Scanner(descriptionFile); 

            while(descriptionScanner.hasNextLine()){
                if(tmpIndex != index){
                    tmp.add(descriptionScanner.nextLine());
                }else{
                    FileWriter trashFileWriter = new FileWriter("trashDescriptionBook.txt" , true);
                    trashFileWriter.append(descriptionScanner.nextLine() + "\n");
                    trashFileWriter.close();
                }
                tmpIndex++;
            }
            descriptionScanner.close();
            FileWriter editDescription = new FileWriter("descriptionBook.txt");
            for(int i=0 ; i<tmp.size() ; i++){
                editDescription.append(tmp.get(i) + "\n");
            }
            editDescription.close();
            tmp.clear();
            //done

            tmpIndex = 1;
            //edit status
            Scanner statusScanner = new Scanner(statusFile);
            while(statusScanner.hasNextLine()){
                if(tmpIndex != index){
                    tmp.add(statusScanner.nextLine());
                }else{
                    FileWriter trashFileWriter = new FileWriter("trashStatusBook.txt" , true);
                    trashFileWriter.append(statusScanner.nextLine() + "\n");
                    trashFileWriter.close();
                }
                tmpIndex++;
            }
            statusScanner.close();
            FileWriter editStatus = new FileWriter("statusBook.txt");
            for(int i=0 ; i<tmp.size() ; i++){
                editStatus.append(tmp.get(i) + "\n");   
            }
            editStatus.close();
            tmp.clear();
            //done

            File bookID = new File("rentBookID.txt");
            Scanner rentIDScanner = new Scanner(bookID);
            tmpIndex = 1;
            while(rentIDScanner.hasNextLine()){
                String tmpStr = rentIDScanner.nextLine();
                if(tmpStr.equals(id.toString())){
                    index = tmpIndex;
                }else{
                    tmp.add(tmpStr);
                }
                tmpIndex++;
            }
            rentIDScanner.close();
            FileWriter editRentId = new FileWriter("rentBookID.txt");
            for(int i=0; i<tmp.size(); i++){
                editRentId.append(tmp.get(i) + "\n");
            }
            editRentId.close();
            tmp.clear();

            File bookName = new File("rentBookName.txt");
            Scanner rentName = new Scanner(bookName);
            tmpIndex = 1;
            while(rentName.hasNextLine()){
                String tmpStr = rentName.nextLine();
                if(tmpIndex != index){
                    tmp.add(tmpStr);
                }
                tmpIndex++;
            }
            rentName.close();
            FileWriter editRentName = new FileWriter("rentBookName.txt");
            for(int i=0; i<tmp.size(); i++){
                editRentName.append(tmp.get(i) + "\n");
            }
            editRentName.close();
            tmp.clear();

            File userName = new File("rentUserName.txt");
            Scanner rentUserName = new Scanner(userName);
            tmpIndex = 1;
            while(rentUserName.hasNextLine()){
                String tmpStr = rentUserName.nextLine();
                if(tmpIndex != index){
                    tmp.add(tmpStr);
                }
                tmpIndex++;
            }
            rentUserName.close();
            FileWriter editUserName = new FileWriter("rentUserName.txt");
            for(int i=0; i<tmp.size(); i++){
                editUserName.append(tmp.get(i) + "\n");
            }
            editUserName.close();
            tmp.clear();

            File userID = new File("rentUserID.txt");
            Scanner rentUserID = new Scanner(userID);
            tmpIndex = 1;
            while(rentUserID.hasNextLine()){
                String tmpStr = rentUserID.nextLine();
                if(tmpIndex != index){
                    tmp.add(tmpStr);
                }
                tmpIndex++;
            }
            rentUserID.close();
            FileWriter editUserID = new FileWriter("rentUserID.txt");
            for(int i=0; i<tmp.size(); i++){
                editUserID.append(tmp.get(i) + "\n");
            }
            editUserID.close();
            tmp.clear();

            File rentDate = new File("rentDate.txt");
            Scanner rentDateScanner = new Scanner(rentDate);
            tmpIndex = 1;
            while(rentDateScanner.hasNextLine()){
                String tmpStr = rentDateScanner.nextLine();
                if(tmpIndex != index){
                    tmp.add(tmpStr);
                }
                tmpIndex++;
            }
            rentDateScanner.close();
            FileWriter editRentDate = new FileWriter("rentDate.txt");
            for(int i=0; i<tmp.size(); i++){
                editRentDate.append(tmp.get(i) + "\n");
            }
            editRentDate.close();
            tmp.clear();


            bookCounter--;
            try{
                File myCounter = new File("ownerInfo\\Counter.txt");
                FileWriter countWriter = new FileWriter("ownerInfo\\Counter.txt");
                countWriter.write(bookCounter.toString());
                countWriter.close();
            }catch(IOException e){
                System.out.println("error 404!\npage not found! " + e);
            }
        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
        
    }

    public void createAccount(String name, String phoneNumber){
        File userNameFile = new File("NormalUserName.txt");
        File userIDFile = new File("NormalUserID.txt");
        File userPhoneFile = new File("NormalPhoneNumber.txt");
        File userDateFile = new File("dateUser.txt");
        phoneNumber = phoneNumber.replace(" ", "");
        try{
            boolean isName = userNameFile.createNewFile();
            boolean isID = userIDFile.createNewFile();
            boolean isPhone = userPhoneFile.createNewFile();
            boolean isDate = userDateFile.createNewFile();
            
            FileWriter userNameWriter = new FileWriter("NormalUserName.txt", true);
            userNameWriter.append(name + "\n");
            userNameWriter.close();

            FileWriter userPhoneWriter = new FileWriter("NormalPhoneNumber.txt", true);
            userPhoneWriter.append(phoneNumber + "\n");
            userPhoneWriter.close();

           
            for(;;){
                Scanner idScanner = new Scanner(userIDFile);
                boolean isId = true;
                Integer id = (int)(Math.random()*1000001);
                while(idScanner.hasNextLine()){
                    if(id.toString().equals(idScanner.nextLine())){
                        isId = false;
                    }
                }
                idScanner.close();
                if(isId){
                    FileWriter writeID = new FileWriter("NormalUserID.txt" , true); 
                    writeID.append(id.toString() + "\n");
                    writeID.close();
                    break;
                }
            }

            LocalDateTime date = LocalDateTime.now();
            FileWriter writeDate = new FileWriter("dateUser.txt" , true);
            writeDate.append(date.format(formater) +"\n");
            writeDate.close();
            
            
        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
    }

    public void removeAccount(String ID){
        File userNameFile = new File("NormalUserName.txt");
        File userIDFile = new File("NormalUserID.txt");
        File phoneNumberFile = new File("NormalPhoneNumber.txt");
        File dateUserFile = new File("dateUser.txt");

        boolean isRemove = false;
        
        try{
            ArrayList<String> tmp = new ArrayList<>();
            int index = 0;
            int tmpIndex = 1;

            //ID
            tmpIndex = 1;
            Scanner IDScanner = new Scanner(userIDFile);
            while (IDScanner.hasNextLine()) {
                if(!ID.equals(IDScanner.nextLine())){
                    tmp.add(IDScanner.nextLine());
                }else{
                    isRemove = true;
                    index = tmpIndex;
                }
                tmpIndex++;
            }
            IDScanner.close();
            FileWriter editID = new FileWriter("NormalUserID.txt");
            for(int i=0; i<tmp.size(); i++){
                editID.append(tmp.get(i) + "\n");
            }
            editID.close();
            tmp.clear();
            //Done (ID)

            //Name
            tmpIndex = 1;
            Scanner nameScanner = new Scanner(userNameFile);
            while(nameScanner.hasNextLine()){
                if(tmpIndex !=index){
                    tmp.add(nameScanner.nextLine());
                }else{
                    String tmpStr = nameScanner.nextLine();
                    tmpStr = "";
                }
                tmpIndex++;
            }
            nameScanner.close();
            FileWriter editName = new FileWriter("NormalUserName.txt");
            for(int i=0; i<tmp.size();i++){
                editName.append(tmp.get(i) + "\n");
            }
            editName.close();
            tmp.clear();
            //Done (Name)

            //Phone Number
            tmpIndex = 1;
            Scanner phoneScanner = new Scanner(phoneNumberFile);
            while(phoneScanner.hasNextLine()){
                if(tmpIndex != index){
                    tmp.add(phoneScanner.nextLine());
                }else{
                    String tmpStr = phoneScanner.nextLine();
                    tmpStr = "";
                }
                tmpIndex++;
            }
            phoneScanner.close();
            FileWriter editPhone = new FileWriter("NormalPhoneNumber.txt");
            for(int i=0; i<tmp.size(); i++){
                editPhone.append(tmp.get(i) + "\n");
            }
            editPhone.close();
            tmp.clear();
            //Done (Phone Number)

            //Date 
            tmpIndex = 1;
            Scanner dateScanner = new Scanner(dateUserFile);
            while(dateScanner.hasNextLine()){
                if(tmpIndex != index){
                    tmp.add(dateScanner.nextLine());
                }else{
                    String tmpStr = dateScanner.nextLine();
                    tmpStr = "";
                }
                tmpIndex++;
            }
            dateScanner.close();
            FileWriter editDate = new FileWriter("dateUser.txt");
            for(int i=0; i<tmp.size(); i++){
                editDate.append(tmp.get(i) + "\n");
            }
            editDate.close();
            tmp.clear();
            //Done (Date)
        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
        
        if(isRemove){
            System.out.println("Removed Succussfully!");
        }else{
            System.out.println("There\'s No User With This ID!");
        }

    }

    public void returnBook(String bookName){
        File bookNameFile = new File("rentBookName.txt");
        File bookIDFile = new File("rentBookID.txt");
        File userIDFile = new File("rentUserID.txt");

        int index = 1;
        int tmpIndex = 1;
        ArrayList<String> tmp = new ArrayList<>();

        try{
            //edit rentBookName
            Scanner nameScanner = new Scanner(bookNameFile);
            while(nameScanner.hasNextLine()){
                String tmpStr = nameScanner.nextLine();
                if(tmpStr.equals(bookName)){
                    index = tmpIndex;
                }else{
                    tmp.add(tmpStr);
                }
                tmpStr = "";
                tmpIndex++;
            }
            nameScanner.close();
            FileWriter editBookName = new FileWriter("rentBookName.txt");
            for(int i=0 ; i<tmp.size() ; i++){
                editBookName.append(tmp.get(i) + "\n");
            }
            editBookName.close();
            tmp.clear();
            //Done (Name)

            tmpIndex = 1;
            //edit rentBookID 
            Scanner idScanner = new Scanner(bookIDFile);
            while (idScanner.hasNextLine()) {
                if(tmpIndex != index){
                    tmp.add(idScanner.nextLine());
                }else{
                    String tmpStr = idScanner.nextLine();
                    tmpStr = "";
                }
                tmpIndex++;
            }
            idScanner.close();
            FileWriter idWriter = new FileWriter("rentBookID.txt");
            for(int i=0; i<tmp.size(); i++){
                idWriter.append(tmp.get(i) + "\n");
            }
            idWriter.close();
            tmp.clear();
            //Done (ID)

            tmpIndex = 1;
            //edit rentUserID
            Scanner userIDScanner = new Scanner(userIDFile);
            while(userIDScanner.hasNextLine()){
                if(tmpIndex != index){
                    tmp.add(userIDScanner.nextLine());
                }else{
                    String tmpStr = userIDScanner.nextLine();
                    tmpStr = "";
                }
                tmpIndex++;
            }
            userIDScanner.close();
            FileWriter userIDWriter = new FileWriter("rentUserID.txt");
            for(int i=0; i<tmp.size(); i++){
                userIDWriter.append(tmp.get(i) + "\n");
            }
            userIDWriter.close();
            tmp.clear();
            //Done (User ID)

            
            
        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
    }

    public void getBookID(String bookName){
        File bookIdFile = new File("bookId.txt");
        File titleFile = new File("titleBook.txt");
        File authorFile = new File("authorBook.txt");

        try{
            Scanner nameScanner = new Scanner(titleFile);
            Scanner idScanner = new Scanner(bookIdFile);
            Scanner authorScanner = new Scanner(authorFile);

            int index = 1;
            boolean isShow = false;
            while(nameScanner.hasNextLine()){
                String tpmID = idScanner.nextLine();
                String tmpAuthor = authorScanner.nextLine();
                if(nameScanner.nextLine().equals(bookName)){
                    System.out.println(index + ". " + bookName);
                    System.out.println("\tID: " + tpmID);
                    System.out.println("\tAuthor: " + tmpAuthor);
                    System.out.println();
                    index++;
                    isShow = true;
                }
            }
            if(!isShow){
                System.out.println("The Book Is Not In Library Repository!");
            }
            nameScanner.close();
            idScanner.close();
            authorScanner.close();
        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }
    }

    public void addAdmin(String name , String phoneNumber , String passWord ){
        File userNameFile = new File("AdminUserName.txt");
        File userIDFile = new File("AdminUserID.txt");
        File phoneNumberFile = new File("AdminPhoneNumber.txt");
        File passAdminsFile = new File("passwordAdmin.txt");
        phoneNumber = phoneNumber.replace(" ", "");
        try{
            FileWriter nameWriter = new FileWriter("AdminUserName.txt" , true);
            nameWriter.append(name + "\n");
            nameWriter.close();

            FileWriter phoneWriter = new FileWriter("AdminPhoneNumber.txt" , true);
            phoneWriter.append(phoneNumber + "\n");
            phoneWriter.close();

            FileWriter passWriter = new FileWriter("passwordAdmin.txt" , true);
            passWriter.append(passWord + "\n");
            passWriter.close();

            for(;;){
                Scanner idScanner = new Scanner(userIDFile);
                boolean isId = true;
                Integer id = (int)(Math.random()*1000001);
                while(idScanner.hasNextLine()){
                    if(id.toString().equals(idScanner.nextLine())){
                        isId = false;
                    }
                }
                idScanner.close();
                if(isId){
                    FileWriter writeID = new FileWriter("AdminUserID.txt" , true); 
                    writeID.append(id.toString() + "\n");
                    writeID.close();
                    break;
                }
            }

        }catch(IOException e){
            System.out.println("error 404!\npage not found! " + e);
        }

    }

}

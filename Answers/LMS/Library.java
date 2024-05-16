import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    Book newBooks = new Book();
    User newNormalUsers = new NormalUser("NormalUserName", "NormalUserID", "NormalPhoneNumber");
    User newAdmins = new Admin("AdminUserName", "AdminUserID", "AdminPhoneNumber");
    Rent newRent = new Rent();
    private String libraryName;
    private int libraryCapacity;
    private int bookCounter = 0 ;
    private String openTime;
    private String closeTime;
    public Library(String libraryName , int libraryCapacity) {
        this.libraryName = libraryName;
        this.libraryCapacity = libraryCapacity;
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
                System.out.print("\n__________________________________________\n");
                index++;
            }  
            idScanner.close();
            titleScanner.close();
            authorScanner.close();
            descriptionScanner.close();
            statusScanner.close();
        }catch(IOException e){
            System.out.println("error 404!\npage not found!");
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
    
                FileWriter statusWriter = new FileWriter("descriptionBook.txt", true);
                statusWriter.append("true");
                statusWriter.close();
    
                boolean isId = true;
                for(;;){
                    Scanner idScanner = new Scanner(bookIdFile);
                    Integer id = (int)(Math.random()*1000001);
                    while (idScanner.hasNextLine()){
                        if(idScanner.nextLine().equals(id.toString())){
                            isId = false;
                        }
                    }
                    if(isId){
                        FileWriter idWriter = new FileWriter("bookId.txt" , true);
                        idWriter.append(id.toString());
                        idWriter.close();
                        break;
                    }
                    idScanner.close();
                }    
            }catch(IOException e){
                System.out.println("error 404!\npage not found!");
            }
            bookCounter++;
        }else{
            System.out.println("The Library Is Full! ");
        }
    }

    public void getID(String phoneNumber){
        int index = 1;
        File userPhone = new File("NormalPhoneNumber.txt");
        File userID = new File("NormalUserID.txt");
        try{
            Scanner phoneScanner = new Scanner(userPhone);
            int tmpIndex = 1;
            boolean isIt = false;
            while(phoneScanner.hasNextLine()){
                if(phoneScanner.nextLine().equals(phoneNumber)){
                    isIt = true;
                    index = tmpIndex;
                    break;
                }
                tmpIndex++;
            }
            phoneScanner.close();

            if(isIt) {
                tmpIndex = 1;
                Scanner idScanner = new Scanner(userID);
                while (idScanner.hasNextLine()) {
                    if (tmpIndex == index) {
                        System.out.println(idScanner.nextLine());
                        break;
                    }
                    tmpIndex++;
                }
                idScanner.close();
            }else {
                System.out.println("This PhoneNymber Not Found.");
            }

        }catch(IOException e){
            System.out.println("error 404!\npage not found!");
        }
    }

    public void addRent(Integer idBook , Integer idUser){
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
                if(idBook.toString().equals(scIdBook.nextLine())){
                    FileWriter writeIdBook = new FileWriter("rentBookID.txt" , true);
                    writeIdBook.append(idBook.toString()+"\n");
                    writeIdBook.close();
                    break;
                }
                index++;
            }
            scIdBook.close();

            //edit statusFile
            ArrayList<String> tmpStatus = new ArrayList<>();
            Scanner scStatus = new Scanner(statusFile);
            int indexTmp = 1;
            while ((scStatus.hasNextLine())) {
                if(indexTmp != index){
                    tmpStatus.add(scStatus.nextLine());
                }else{
                    String str = scStatus.nextLine();
                    tmpStatus.add("false");
                }
                indexTmp++;
            }
            scStatus.close();
            FileWriter editStatus = new FileWriter("statusBook.txt");
            for(int i=0 ; i<tmpStatus.size() ; i++){
                editStatus.append(tmpStatus.get(i) + "\n");
            }
            editStatus.close();
            tmpStatus.clear();
            //done 

            Scanner scNameBook = new Scanner(titleFile);
            indexTmp = 1;
            while(scNameBook.hasNextLine()){
                if(indexTmp == index){
                    FileWriter writeNameBook = new FileWriter("rentBookName.txt" , true);
                    writeNameBook.append(scNameBook.nextLine() + "\n");
                    writeNameBook.close();
                    break;
                }
                indexTmp++;
            }
            Scanner scIdUser = new Scanner(userIDFile);
            index = 1;
            while(scIdUser.hasNextLine()){
                if(scIdUser.nextLine().equals(idUser.toString())){
                    FileWriter writeIdUser = new FileWriter("rentUserID.txt" , true);
                    writeIdUser.append(idUser.toString() + "\n");
                    writeIdUser.close();
                }
                index++;
            }
            Scanner scUserName = new Scanner(userNameFile);
            indexTmp = 1;
            while (scUserName.hasNextLine()) {
                if(indexTmp == index){
                    FileWriter writeUserName = new FileWriter("rentUserName.txt" , true);
                    writeUserName.append(scUserName.nextLine() + "\n");
                    writeUserName.close();
                    break;
                }
                indexTmp++;
            }
            
            FileWriter writeDate = new FileWriter("rentDate.txt", true);
            LocalDate rentalDate = LocalDate.now();
            writeDate.append(rentalDate.toString());
            writeDate.close();

        }catch(IOException e){
            System.out.println("error 404!\npage not found!");
        }

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
                if(!id.toString().equals(idScanner.nextLine())){
                    tmp.add(idScanner.nextLine());
                }else{
                    FileWriter trashFileWriter = new FileWriter("trashBookID.txt" , true);
                    trashFileWriter.append(idScanner.nextLine() + "\n");
                    trashFileWriter.close();
                    index = tmpIndex;
                }
                tmpIndex++;
            }
        
            FileWriter editID = new FileWriter("bookId.txt");
            for(int i=0; i<tmp.size(); i++){
                editID.append(tmp.get(i) + "\n");
            }
            tmp.clear();
            idScanner.close();
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
            bookCounter--;
        }catch(IOException e){
            System.out.println("error 404!\npage not found!");
        }
        
    }

    public void createAccount(String name, String phoneNumber){
        File userNameFile = new File("NormalUserName.txt");
        File userIDFile = new File("NormalUserID.txt");
        File userPhoneFile = new File("NormalPhoneName.txt");
        File userDateFile = new File("dateUser.txt");
        try{
            boolean isName = userNameFile.createNewFile();
            boolean isID = userIDFile.createNewFile();
            boolean isPhone = userPhoneFile.createNewFile();
            boolean isDate = userDateFile.createNewFile();
            
            FileWriter userNameWriter = new FileWriter("NormalUserName.txt", true);
            userNameWriter.append(name + "\n");
            userNameWriter.close();

            FileWriter userPhoneWriter = new FileWriter("NormalPhoneName.txt", true);
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
                if(isId){
                    FileWriter writeID = new FileWriter("NormalUserID.txt" , true); 
                    writeID.append(id.toString() + "\n");
                    writeID.close();
                    break;
                }   
                idScanner.close();
            }

            LocalDate date = LocalDate.now();
            String strDate = date.toString();
            FileWriter writeDate = new FileWriter("dateUser.txt" , true);
            writeDate.append(strDate +"\n");
            writeDate.close();
            
            
        }catch(IOException e){
            System.out.println("error 404!\npage not found!");
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
            System.out.println("error 404!\npage not found!");
        }
        
        if(isRemove){
            System.out.println("Removed Succussfully!");
        }else{
            System.out.println("There\'s No User With This ID!");
        }

    }

    public void returnBook(String bookName){
        int tmpIndx=0;
        try{
            File rentTitle= new File("rentBookName.txt");
            Scanner titleScanner = new Scanner(rentTitle);
            int indx = 1;
            boolean isRent = false;
            while(titleScanner.hasNextLine()){
                if(bookName.equals(titleScanner.nextLine())){
                    isRent = true;
                    tmpIndx = indx;
                    break;
                }
                indx++;
            }
            titleScanner.close();
            if(isRent){
                ArrayList<String> returnBook = new ArrayList<>();
                indx=1;
                Scanner returnSc = new Scanner(rentTitle);
                while(returnSc.hasNextLine()){
                    if(indx != tmpIndx){
                       returnBook.add(returnSc.nextLine());
                    }else{
                        String tmpStr = returnSc.nextLine();
                        tmpStr = "";
                    }
                    indx++;
                }
                returnSc.close();
                FileWriter writeNameBook = new FileWriter("rentBookName.txt");
                for(int i=0 ; i< returnBook.size() ; i++){
                    writeNameBook.append(returnBook.get(i) + "\n");
                }
                returnBook.clear();
                writeNameBook.close();
                //done

                File returnIdBook = new File("rentBookID.txt");
                Scanner returnIdBookSc = new Scanner(returnIdBook);
                indx=1;

                while(returnIdBookSc.hasNextLine()){
                    if(indx != tmpIndx){
                        returnBook.add(returnIdBookSc.nextLine());
                    }else {
                        String tmpStr = returnIdBookSc.nextLine();
                    }
                    indx++;
                }
                returnIdBookSc.close();
                FileWriter writeIdBook = new FileWriter("rentBookID.txt" , true);
                for(int i=0 ; i<returnBook.size() ; i++){
                    writeIdBook.append(returnBook.get(i) + "\n");
                }
                returnBook.clear();
                writeIdBook.close();
                returnIdBookSc.close();
                //done
                File editStatus = new File("statusBook.txt");
                Scanner returnStatus = new Scanner(editStatus);
                indx = 1;
                while (returnStatus.hasNextLine()){
                    if(indx != tmpIndx){
                        returnBook.add(returnStatus.nextLine());
                    }else{
                        String tmpStr = returnStatus.nextLine();
                        returnBook.add("true");
                    }
                    indx++;
                }
                returnStatus.close();
                FileWriter writeEditStatus = new FileWriter("statusBook.txt");
                for(int i=0 ; i<returnBook.size() ; i++){
                    writeEditStatus.append(returnBook.get(i) + "\n");
                }
                writeEditStatus.close();
                returnBook.clear();
                //done

                File returnIdUser = new File("rentUserID.txt");
                Scanner returnUserSc = new Scanner(returnIdUser);
                indx=1;
                while (returnUserSc.hasNextLine()){
                    if(indx != tmpIndx){
                        returnBook.add(returnUserSc.nextLine());
                    }else{
                        String tmpStr = returnUserSc.nextLine();
                    }
                    indx++;
                }
                returnUserSc.close();
                FileWriter writeIdUser = new FileWriter("rentUserID.txt");
                for(int i=0 ; i<returnBook.size() ; i++){
                    writeIdUser.append(returnBook.get(i) + "\n");
                }
                returnBook.clear();
                writeIdUser.close();
                //done

                File returnUserName = new File("rentUserName.txt");
                Scanner returnUserNameSc = new Scanner(returnUserName);
                indx=1;
                while(returnUserNameSc.hasNextLine()){
                    if(indx != tmpIndx){
                        returnBook.add(returnUserNameSc.nextLine());
                    }else{
                        String tmpStr = returnUserNameSc.nextLine();
                    }
                    indx++;
                }
                returnUserNameSc.close();
                FileWriter writeUserName = new FileWriter("rentUserName.txt");
                for(int i=0 ; i<returnBook.size() ; i++){
                    writeUserName.append(returnBook.get(i) + "\n");
                }
                returnBook.clear();
                writeUserName.close();
                //done


            }else{
                System.out.println("Wrong Entry!");
            }
        }catch(IOException e){
            System.out.println("error 404!\npage not found!" + e);
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
            while(nameScanner.hasNextLine()){
                String tpmID = idScanner.nextLine();
                String tmpAuthor = authorScanner.nextLine();
                if(nameScanner.nextLine().equals(bookName)){
                    System.out.println(index + ". " + bookName);
                    System.out.println("\tID: " + tpmID);
                    System.out.println("\tAuthor: " + tmpAuthor);
                    System.out.println();
                    index++;
                }
            }
            nameScanner.close();
            idScanner.close();
            authorScanner.close();
        }catch(IOException e){
            System.out.println("error 404!\npage not found!");
        }
    }

    public void addAdmin(String name , String phoneNumber , String passWord , String ID){
        File userNameFile = new File("AdminUserName.txt");
        File userIDFile = new File("AdminUserID.txt");
        File phoneNumberFile = new File("AdminPhoneNumber.txt");
        File passAdminsFile = new File("passwordAdmin.txt");
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

            FileWriter IdWriter = new FileWriter("AdminUserID.txt" , true);
            IdWriter.append(ID + "\n");
            IdWriter.close();

        }catch(IOException e){
            System.out.println("error 404!\npage not found!");
        }

    }

    public void showMembers(){
        try {
            File userIDFile = new File("NormalUserID.txt");
            File userNameFile = new File("NormalUserName.txt");
            Scanner IdScan = new Scanner(userIDFile);
            Scanner nameScan = new Scanner(userNameFile);
            while (IdScan.hasNextLine()) {
                System.out.println("Name: ");
                System.out.println(IdScan.nextLine());
                System.out.println("ID: ");
                System.out.println(nameScan.nextLine());
                System.out.println("------------------------------------------------------------------");
            }
        }catch (IOException e){
            System.out.println("Error 404\nPage Not Found!" + e);
        }
    }
}

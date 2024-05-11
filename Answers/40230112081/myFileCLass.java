import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class myFileCLass {
    public File f;
    public String dir;
    public void add_to_file(String query){
        f = new File(dir);
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(f, true);
            fos.write(query.getBytes(StandardCharsets.UTF_8));
            fos.write("\n".getBytes(StandardCharsets.UTF_8));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try{
                if(fos != null)
                    fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> lines_of_file()
    {
        f = new File(dir);
        String line;
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader br = null;
        FileReader fr = null;
        try{
            fr = new FileReader(f);
            br = new BufferedReader(fr); // use buffer reader to read more efficient
            while((line = br.readLine()) != null){
                lines.add(line);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(fr != null)
                    fr.close();
                if(br != null)
                    br.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return lines;
    }

    public void show_myUsername(){
        System.out.println("Enter your phonenumber :");
        String phone;
        Scanner scn = new Scanner(System.in);
        phone = scn.nextLine();
        int i = getPhoneNumbersInFile().indexOf(phone);
        if(i != -1) {
            System.out.println(getUsernameInFile().get(i));
            return;
        }
        else{
            System.out.println("Your phonenumber is not found, try phonenumber you were signed up");
        }

    }
    public void show_myPassword(){
        System.out.println("Enter your phonenumber :");
        String phone;
        Scanner scn = new Scanner(System.in);
        phone = scn.nextLine();
        int i = getPhoneNumbersInFile().indexOf(phone);
        if(i != -1) {
            System.out.println(getUserPassword().get(i));
            return;
        }
        else{
            System.out.println("Your phonenumber is not found, try phonenumber you were signed up");
        }
    }
    public void editLineInFile(String lineToEdit, String newLine) {
        try {
            // Read the file
            f = new File(dir);
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            StringBuilder fileContent = new StringBuilder();

            // Read each line and replace if it matches
            while ((line = reader.readLine()) != null) {
                if (line.equals(lineToEdit)) {
                    fileContent.append(newLine).append("\n");
                } else {
                    fileContent.append(line).append("\n");
                }
            }
            reader.close();

            // Write back to the file
            FileWriter writer = new FileWriter(dir);
            writer.write(fileContent.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public int set_id(){
        return lines_of_file().size();
    }

    public void addUser(User u){
        String username = u.getUser_name();
        String id = u.getUserID();
        String phone = u.getPhonenumber();
        String role = u.getRole();
        String pass = u.getPassword();
        String query =id+","+username + "," +phone+","+role+","+pass;
        add_to_file(query);
    }

    public ArrayList<String> getIDInFile(){
        int flag;
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> lines = lines_of_file();
        for(String l : lines){
            if(Objects.equals(l, ""))
                continue;
            flag = l.indexOf(",");
            ids.add(l.substring(0, flag));
        }
        return ids;
    }
    public ArrayList<String> getUsernameInFile(){
        int f1, f2;
        ArrayList<String> usernames = new ArrayList<>();
        ArrayList<String> lines = lines_of_file();
        for(String l : lines){
            if(Objects.equals(l, ""))
                continue;
            f1 = l.indexOf(",");
            f2 = l.indexOf(",", f1+1);
            usernames.add(l.substring(f1+1,f2));
        }
        return usernames;
    }
    public ArrayList<String> getPhoneNumbersInFile(){
        int f1,f2,f3;
        ArrayList<String> phones = new ArrayList<>();
        ArrayList<String> lines = lines_of_file();
        for(String l : lines){
            if(Objects.equals(l, ""))
                continue;
            f1 = l.indexOf(",");
            f2 = l.indexOf(",", f1+1);
            f3 = l.indexOf(",",f2+1);
            phones.add(l.substring(f2+1, f3));
        }
        return phones;
    }
    public ArrayList<String> getUserRolesInFile(){
        int f1,f2,f3,f4;
        ArrayList<String> roles = new ArrayList<>();
        ArrayList<String> lines = lines_of_file();
        for(String l : lines){
            if(Objects.equals(l, ""))
                continue;
            f1 = l.indexOf(",");
            f2 = l.indexOf(",", f1+1);
            f3 = l.indexOf(",",f2+1);
            f4 = l.indexOf(",", f3+1);
            roles.add(l.substring(f3+1,f4));
        }
        return roles;
    }

    public ArrayList<String> getUserPassword(){
        int f1,f2,f3,f4;
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<String> lines = lines_of_file();
        for(String l : lines){
            if(Objects.equals(l, ""))
                continue;
            f1 = l.indexOf(",");
            f2 = l.indexOf(",", f1+1);
            f3 = l.indexOf(",",f2+1);
            f4 = l.indexOf(",", f3+1);
            passwords.add(l.substring(f4+1));
        }
        return passwords;
    }

    public void addBook(Book b){
        String query;
        String id, title, author, desc, status;
        id = b.getId();
        title = b.getTitle();
        author = b.getAuthor();
        desc = b.getDescription();
        status = b.getStatus();
        int exst = b.getExistence();
        query = id + "," + title + "," + author + "," + desc + "," + status + "," + String.valueOf(exst);
        add_to_file(query);
    }

    public ArrayList<String> getIdFromFileBook(){
        int f1;
        ArrayList<String> lines = lines_of_file();
        ArrayList<String> ids = new ArrayList<>();
        for(String str : lines){
            if(Objects.equals(str, ""))
                continue;
            f1 = str.indexOf(",");
            ids.add(str.substring(0, f1));
        }
        return ids;
    }

    public ArrayList<String> getTitlesFromFileBook(){
        int f1,f2;
        ArrayList<String> lines = lines_of_file();
        ArrayList<String> titles = new ArrayList<>();
        for(String str : lines){
            if(Objects.equals(str, ""))
                continue;
            f1 = str.indexOf(",");
            f2 = str.indexOf(",", f1+1);
            titles.add(str.substring(f1+1, f2));
        }
        return titles;
    }
    public ArrayList<String> getAuthorsFromFileBook(){
        int f1,f2, f3;
        ArrayList<String> lines = lines_of_file();
        ArrayList<String> authors = new ArrayList<>();
        for(String str : lines){
            if(Objects.equals(str, ""))
                continue;
            f1 = str.indexOf(",");
            f2 = str.indexOf(",", f1+1);
            f3 = str.indexOf(",", f2+1);
            authors.add(str.substring(f2+1, f3));}
        return authors;
    }
    public ArrayList<String> getDescriptionsFromFileBook(){
        int f1,f2, f3, f4;
        ArrayList<String> lines = lines_of_file();
        ArrayList<String> descrips = new ArrayList<>();
        for(String str : lines){
            if(Objects.equals(str, ""))
                continue;
            f1 = str.indexOf(",");
            f2 = str.indexOf(",", f1+1);
            f3 = str.indexOf(",", f2+1);
            f4 = str.indexOf(",", f3+1);
            descrips.add(str.substring(f3+1, f4));
        }
        return descrips;
    }
    public ArrayList<String> getStatsFromFileBook(){
        int f1,f2, f3, f4, f5;
        ArrayList<String> lines = lines_of_file();
        ArrayList<String> stats = new ArrayList<>();
        for(String str : lines){
            if(Objects.equals(str, ""))
                continue;
            f1 = str.indexOf(",");
            f2 = str.indexOf(",", f1+1);
            f3 = str.indexOf(",", f2+1);
            f4 = str.indexOf(",", f3+1);
            f5 = str.indexOf(",", f4+1);
            stats.add(str.substring(f4+1,f5));
        }
        return stats;
    }

    public ArrayList<String> getExistsFromFileBook(){
        int f1,f2, f3, f4, f5;
        ArrayList<String> lines = lines_of_file();
        ArrayList<String> exists = new ArrayList<>();
        for(String str : lines){
            if(Objects.equals(str, ""))
                continue;
            f1 = str.indexOf(",");
            f2 = str.indexOf(",", f1+1);
            f3 = str.indexOf(",", f2+1);
            f4 = str.indexOf(",", f3+1);
            f5 = str.indexOf(",", f4+1);
            exists.add(str.substring(f5+1));
        }
        return exists;
    }


    public void addRental(Rent r){
        String query;
        String date = r.getDate();
        String userID = r.getUserID();
        String bookID = r.getBookID();

        query = date+","+userID+","+bookID;
        add_to_file(query);
    }

    public ArrayList<String> getRentalsDate(){
        ArrayList<String> lines = lines_of_file();
        ArrayList<String> dates = new ArrayList<>();
        int f1;
        for(String str: lines){
            if(Objects.equals(str, ""))
                continue;
            f1 = str.indexOf(",", 0);
            dates.add(str.substring(0, f1));
        }
        return dates;
    }

    public ArrayList<String> getRentalsUserID(){
        ArrayList<String> lines = lines_of_file();
        ArrayList<String> userIds = new ArrayList<>();
        int f1, f2;
        for(String str: lines){
            if(Objects.equals(str, ""))
                continue;
            f1 = str.indexOf(",", 0);
            f2 = str.indexOf(",", f1+1);
            userIds.add(str.substring(f1+1, f2));
        }
        return userIds;
    }

    public ArrayList<String> getRentalsBookID(){
        ArrayList<String> lines = lines_of_file();
        ArrayList<String> bookIds = new ArrayList<>();
        int f1, f2;
        for(String str: lines){
            if(Objects.equals(str, ""))
                continue;
            f1 = str.indexOf(",", 0);
            f2 = str.indexOf(",", f1+1);
            bookIds.add(str.substring(f2+1));
        }
        return bookIds;
    }

    public void change_status_inFileRent(String _id){ // just for book & reduce existence for rent
        int f = getIdFromFileBook().indexOf(_id);
        String new_query;
        String new_status;
        if(Objects.equals(getStatsFromFileBook().get(f), "available")){
            new_status = "in-rent";
        }
        else{
            System.out.println("Actually book is in rent, Access denied.");
            return;
        }
        String t,a,d,e;
        t = getTitlesFromFileBook().get(f);
        a = getAuthorsFromFileBook().get(f);
        d = getDescriptionsFromFileBook().get(f);
        e = String.valueOf(Integer.valueOf(getExistsFromFileBook().get(f)) - 1);
        new_query = _id + "," + t + "," + a + "," + d + "," + new_status + "," + e;
        editLineInFile(lines_of_file().get(f), new_query);
    }


}



// user : id,username,phonenumber,role,password
// book : id,title,author,description,status,existence
// rent : date,userID,bookID
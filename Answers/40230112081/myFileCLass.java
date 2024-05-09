import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

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

    public int set_id(){
        return lines_of_file().size();
    }

    public void addUser(User u){
        String username = u.getUser_name();
        String id = u.getUserID();
        String phone = u.getPhonenumber();
        String role = u.getRole();
        String query =id+","+username + "," +phone+","+role;
        add_to_file(query);
    }

    public ArrayList<String> getIDInFile(){
        int flag;
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> lines = lines_of_file();
        for(String l : lines){
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
            f1 = l.indexOf(",");
            f2 = l.indexOf(",", f1+1);
            f3 = l.indexOf(",",f2+1);
            roles.add(l.substring(f3+1));
        }
        return roles;
    }

}



// user : id,username,phonenumber,role
// book : id,title,author,description,status
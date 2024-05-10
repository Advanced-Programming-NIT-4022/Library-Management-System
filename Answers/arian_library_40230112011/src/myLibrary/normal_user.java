package myLibrary;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class normal_user extends user implements Interface {
    Date date=new Date();
    private final String dateOfRegistration= String.valueOf(date);

    public normal_user(String x,ArrayList<String> y) throws IOException {
        super(y);
        savingFile(x,y);
        System.out.println("Registration was successful");
    }
    public String givingDate(){
        return this.dateOfRegistration;
    }

    @Override
    public void savingFile(String x,ArrayList<String> y) throws IOException {
        y.add(givingDate());
        setter(y);
        File myUserfile=new File(x);
        if (myUserfile.exists()) {
            FileWriter writer=new FileWriter(x,true);
            PrintWriter pw=new PrintWriter(writer);
            pw.println(y);
            pw.close();
            writer.close();
        } else
        {
            FileWriter writer=new FileWriter(x);
            PrintWriter pw=new PrintWriter(writer);
            pw.println(y);
            pw.close();
            writer.close();
        }
    }


}
interface Interface{
 void savingFile(String x,ArrayList<String> y) throws IOException;
}

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
            fos = new FileOutputStream(f);
            fos.write(query.getBytes(StandardCharsets.UTF_8));
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

}

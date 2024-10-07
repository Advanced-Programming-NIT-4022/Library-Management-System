import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Verifications {

    public int ascii(char ch){
        return (int)ch;
    }
    public boolean userIdValidator(String _id_){
        // User ID must be numerical with length between 10 and 15
        // ASCII Approach
        if(_id_.length() < 10 || _id_.length() > 15)
            return false;
        else{
            for(char ch : _id_.toCharArray()){
                if(ascii(ch) < 48 || ascii(ch) > 57)
                    return false;
            }
        }
        return true;
    }

    public boolean userUsernameValidator(String _username_){
        // Username must include 0->9 and  a->z and A->Z , just underline '_' not dash '-'
        ArrayList<Character> valid_chars = new ArrayList<>();
        String upperAlph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Alph = upperAlph.toLowerCase();
        String numbers = "0123456789";

        for(Character ch : upperAlph.toCharArray()){
            valid_chars.add(ch);
        }
        for(Character ch : Alph.toCharArray()){
            valid_chars.add(ch);
        }
        for(Character ch : numbers.toCharArray()){
            valid_chars.add(ch);
        }
        valid_chars.add('_');
        for(Character ch : _username_.toCharArray()){
            if(!valid_chars.contains(ch))
                return false;
        }

        return true;
    }

    public boolean userPasswordValidator(String _password_){
        // Password must include 0->9 and  a->z and A->Z , just underline '_' not dash '-'
        ArrayList<Character> valid_chars = new ArrayList<>();
        String upperAlph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Alph = upperAlph.toLowerCase();
        String numbers = "0123456789";

        for(Character ch : upperAlph.toCharArray()){
            valid_chars.add(ch);
        }
        for(Character ch : Alph.toCharArray()){
            valid_chars.add(ch);
        }
        for(Character ch : numbers.toCharArray()){
            valid_chars.add(ch);
        }
        valid_chars.add('_');
        for(Character ch : _password_.toCharArray()){
            if(!valid_chars.contains(ch))
                return false;
        }

        return true;
    }

    public boolean userPhonenumberValidator(String _phonenumber_){
        // User phonenumber must start with any number instead of 0
        // length must be 10
        // ASCII approach
        if(_phonenumber_.length() < 10 || _phonenumber_.length() > 10)
            return false;
        else
        {
            for(char ch : _phonenumber_.toCharArray()){
                if(ascii(ch) < 48 || ascii(ch) > 57)
                    return false;
            }
        }
        return true;
    }

    public ArrayList<String> get_SectionsPanelQuery(String query){
        ArrayList<String> str = new ArrayList<>();
        for(String word : query.split(" +")){
            str.add(word);
        }
        return str;
    }

    public boolean dateValidation(String date){
        if(!date.contains("/")){
            return false;
        }
        int f1, f2;
        f1 = date.indexOf("/", 0);
        f2 = date.indexOf("/", f1+1);
        if(date.substring(f1+1,f2).matches("[0-9]")){
            return false;
        }
        return true;
    }
}

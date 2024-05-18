package myLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gettingUserInput  {
    ArrayList<String> myArray=new ArrayList<>();
    void giveData(ArrayList<String> x){
        this.myArray=x;
    }
    ArrayList showConfig(){
        return this.myArray;
    }
    void catchingFileEror(String x) throws IOException {
        try {
            File myfile=new File("C:/Users/Dr Techno/Desktop/"+x+".txt");
            Scanner scan=new Scanner(myfile);
            scan.close();
        }catch (FileNotFoundException e){
            System.out.println("User have not been found!!");
            FileWriter MyFile=new FileWriter("C:/Users/Dr Techno/Desktop/"+x+".txt");
            MyFile.close();
            library mine=new library(showConfig());
           mine.validation();
        }
    }
    public gettingUserInput(String x,String y) throws IOException {
        validation(x,y);
    }
    public void validation(String x,String y) throws IOException {
        if (x.equals("admin")){
            ArrayList myUser=new ArrayList<>();
            myUser.add(x);
            admin newOne=new admin(x,myUser);
            catchingFileEror("user");
            catchingFileEror("admin");
            File myfile=new File("C:/Users/Dr Techno/Desktop/"+x+".txt");
            Scanner scan=new Scanner(myfile);
            if (myfile.exists()){
                while (scan.hasNextLine()){
                    String momental=scan.nextLine();
                    ArrayList<String> myArray=new ArrayList<>(List.of(momental.substring(1, momental.length() - 1).split(", ")));
                    if (newOne.showName().equals(myArray.get(1))&&
                            newOne.showStudentId().equals(myArray.get(2))&&
                            newOne.showPhoneNumber().equals(myArray.get(3))&&
                            newOne.showPassword().equals(myArray.get(4))){
                        giveData(myUser);
                        menuPage arian=new menuPage(y,showConfig());

                    }else {
                        System.out.println("No such "+x+" have been found!!");
                        library mine=new library(showConfig());
                        mine.accessLvl();
                        return;
                    }
                }
            }
            scan.close();
        } else if (x.equals("user")){
        ArrayList myUser=new ArrayList<>();
        myUser.add(x);
        user newOne=new user(myUser);
       catchingFileEror("user");
        File myfile=new File("C:/Users/Dr Techno/Desktop/"+x+".txt");
        Scanner scan=new Scanner(myfile);
        if (myfile.exists()){
            while (scan.hasNextLine()){
                String momental=scan.nextLine();
                ArrayList<String> myArray=new ArrayList<>(List.of(momental.substring(1, momental.length() - 1).split(", ")));
                if (newOne.showName().equals(myArray.get(1))&&
                        newOne.showStudentId().equals(myArray.get(2))&&
                        newOne.showPhoneNumber().equals(myArray.get(3))){
                    giveData(myUser);
                    menuPage arian=new menuPage(y,showConfig());
                }else {
                    System.out.println("No such "+x+" have been found!!");
                    library mine=new library(showConfig());
                    mine.accessLvl();
                    return;
                }
            }
        }
        scan.close();
        }
    }

}


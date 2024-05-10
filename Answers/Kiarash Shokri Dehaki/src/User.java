 import java.time.LocalDateTime;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Scanner;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;


 public class User {
     static ArrayList<String> uphone = new ArrayList<String>();
      static Scanner phone = new Scanner(System.in);
      static Scanner name = new Scanner(System.in);
      static String username = name.nextLine();
      static HashMap<String, Integer> User = new HashMap<String, Integer>();
     static HashMap<String, String> User_ph_name = new HashMap<String, String>();
      static HashMap<Integer, String> informbook = new HashMap<Integer,String >();
    static  LocalDateTime user = LocalDateTime.now();
     static HashMap<String,  LocalDateTime> userdate = new HashMap<String, LocalDateTime >();
     static String usphone;





    public static void userInform()

    {


        int userId = 50;
        System.out.println("name :");
String name1 = name.nextLine();
        User.put(username , userId);

        userId++;


        NormalUser.date(username);

        System.out.println("phone :");

        String userphone = name.nextLine();
        User_ph_name.put(name1,userphone );
        Pattern pattern = Pattern.compile("09(1[0-9]|3[1-9]|2[1-9])-?[0-9]{3}-?[0-9]{4}");
        Matcher matcher = pattern.matcher(userphone);

        boolean matchFound = matcher.matches();



        if (matchFound) {
            //send in array list phone and send hash map

            usphone = phone.nextLine().toLowerCase();
            uphone.add(usphone);
            informbook.put(userId,usphone );




        } else {
            System.out.println("phon is false try again");

            for(int i=0 ; i<1000; i++)
            {

                String userrphone = name.nextLine();
                Pattern patteern = Pattern.compile("09(1[0-9]|3[1-9]|2[1-9])-?[0-9]{3}-?[0-9]{4}");
                Matcher matcheer = pattern.matcher(userrphone);

                boolean matchFoundw = matcher.matches();

                if(matchFoundw)

                  {


                      usphone = phone.nextLine().toLowerCase();
                      uphone.add(usphone);
                      informbook.put(userId,usphone );
break;



                  }

                else

                    {
i++;
                }




            }
        }

        userdate.put(usphone,user);


Library.addmember(username);
        //enter date sabtnam with hash map

     }

   }

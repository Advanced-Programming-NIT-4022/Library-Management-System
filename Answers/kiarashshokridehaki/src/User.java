 import java.time.LocalDateTime;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Scanner;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;


 public class User {
     static ArrayList<String> uname = new ArrayList<String>();

     static ArrayList<String> uphone = new ArrayList<String>();
      static Scanner phone = new Scanner(System.in);
      static Scanner name = new Scanner(System.in);

      static HashMap<String, Long> User = new HashMap<String, Long>();
     static HashMap<String, String> User_ph_name = new HashMap<String, String>();
      static HashMap<Long, String> informbook = new HashMap<Long,String >();
    static  LocalDateTime user = LocalDateTime.now();
     static HashMap<String,  LocalDateTime> userdate = new HashMap<String, LocalDateTime >();
     static HashMap<String, Long> User_name_id = new HashMap<String, Long>();

     static String usphone;
     static String name1;




    public static void userInform()

    {

        long userId = 10000;
        System.out.println("name :");
      name1 = name.nextLine();
        User.put(name1 , userId);
        uname.add(name1);
        User_name_id.put(name1,userId);

        userId++;


        NormalUser.date(name1);

        System.out.println("phone :");

        String userphone = name.nextLine();



        Pattern pattern = Pattern.compile("09(1[0-9]|3[1-9]|2[1-9])-?[0-9]{3}-?[0-9]{4}");
        Matcher matcher = pattern.matcher(userphone);

        boolean matchFound = matcher.matches();



        if (matchFound) {
            //send in array list phone and send hash map

            User_ph_name.put(name1,userphone );
            uphone.add(usphone);
            informbook.put(userId,usphone );

            userdate.put(usphone,user);
            Library.addmember(name1);



        } else {
            System.out.println("phon is false try again");

            for(int i=0 ; i<1000; i++)
            {

                String userrphone = name.nextLine();
                Pattern patteern = Pattern.compile("09(1[0-9]|3[1-9]|2[1-9])-?[0-9]{3}-?[0-9]{4}");
                Matcher matcheer = pattern.matcher(userrphone);

                boolean matchFoundw = matcheer.matches();

                if(matchFoundw)

                  {



                      uphone.add(usphone);
                      informbook.put(userId,usphone );
                      Library.addmember(name1);
                            break;



                  }

                else

                    {
                        System.out.println("phon is false try again");

                        i++;
                }




            }
        }


        userdate.put(usphone,user);
        Library.addmember(name1);


        //enter date sabtnam with hash map

     }

   }

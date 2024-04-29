import java.util.*;

public class Rent {

    static NormalUser UserObject;
    static Book BookObject;
    static int RentalID;
    static Date RentalDate;
    static int Unique_LogID = 0;


    //private String[] RentalDetail = new String[3];
    static String[] RentalDetail = {Integer.toString(UserObject.getUnique_UserID()) , Integer.toString(BookObject.getUnique_BookID()) , RentalDate.toString() };
    private static HashMap<Integer , String[]> RentalRegistery;

    public static void RentBookLOG(){
        generateUniqueLogID();
        RentalRegistery.put(RentalID , RentalDetail);
    }
    private static int generateUniqueLogID() {
        return ++Unique_LogID;
    }
}

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

public class Library {
    private String libraryName;
    private int capacity;
    private HashMap<String,String> operatingHours = new HashMap<>();
    static HashMap<Integer,Integer> rentalID_bookID = new HashMap<>();
    static HashMap<Integer, Integer> rentalID_userID = new HashMap<>();
    static HashMap<Integer, LocalDateTime> rentalID_date = new HashMap<>();
    HashMap<Integer,Integer> permanentRentalID_bookID = new HashMap<>();
    HashMap<Integer, Integer> permanentRentalID_userID = new HashMap<>();
    HashMap<Integer, LocalDateTime> permanentRentalID_date = new HashMap<>();
    public int getKey(int value , HashMap<Integer,Integer> map) {
        int ID = 0;
        for (int i : map.keySet()) {
            if (value == map.get(i)) {
                ID = i;
            }
        }
        return ID;
    }
    public String getHours() {
        Scanner sc = new Scanner(System.in);
        String hours = "";
        do {
            try {
                hours = sc.nextLine();
            }catch (Exception e) {
                System.out.println("Error illegal enrty.");
            }
        }while (hours.isEmpty());
        return hours;
    }
    public void setLibraryName() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        System.out.println("Please enter the name of the library :");
        do{
            try {
                name = sc.nextLine();
            }catch (Exception e) {
                System.out.println("Please enter the name of the library :");
            }
        }while (name.isEmpty());
        libraryName = name;
    }
    public void showLibraryName() {
        System.out.println("Library name : " + libraryName);
    }
    public void setCapacity() {
        Scanner sc = new Scanner(System.in);
        int capacty = -1;
        System.out.println("Please enter the capacity of the library :");
        do{
            try {
                capacty = sc.nextInt();
            }catch (Exception e) {
                System.out.println("Please enter the capacity of the library :");
            }
        }while (capacty == -1);
        this.capacity = capacty;
    }
    public void showCapacity() {
        System.out.println("Capacity : " + capacity);
    }
    public void setOperatingHours() {
        System.out.println("Saturday :");
        operatingHours.put("Saturday",getHours());
        System.out.println("Sunday :");
        operatingHours.put("Sunday",getHours());
        System.out.println("Monday :");
        operatingHours.put("Monday",getHours());
        System.out.println("Tuesday :");
        operatingHours.put("Tuesday",getHours());
        System.out.println("Wednesday :");
        operatingHours.put("Wednesday",getHours());
        System.out.println("Thursday :");
        operatingHours.put("Thursday",getHours());
        System.out.println("Friday :");
        operatingHours.put("Friday",getHours());
    }
    public void showHours() {
        System.out.println("Operating hours :");
        System.out.println("-----------------");
        for (String s : operatingHours.keySet()) {
            System.out.println(s + " | " + operatingHours.get(s));
            System.out.println("-----------------");
        }
    }
    public void show_rental_history() {
        System.out.println("Rent ID | User ID | book ID | Date");
        System.out.println("----------------------------------");
        for (int rid : rentalID_userID.keySet()) {
            System.out.println(rid + " | " + permanentRentalID_userID.get(rid) + " | " + permanentRentalID_bookID.get(rid) + " | " + permanentRentalID_date.get(rid));
            System.out.println("----------------------------------");
        }
    }
}

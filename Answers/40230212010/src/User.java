import java.util.*;

public  class User {
    private static int count = 0;
    private String name;
    private final int UniqueID;
    private String phoneNumber;
    private List<Admin> adminsList;
    private List<NormalUser> normalUsersList;


    public User(String name,String phoneNumber) {
        this.name = name;
        this.UniqueID = ++count;
        this.phoneNumber = phoneNumber;
        List<User> normalUsersList = new ArrayList<User>();
        List<Admin> admins = new ArrayList<Admin>();
    }


    private void removeUser(int userID){
        for(NormalUser user : normalUsersList ){
            if (UniqueID==userID){
                normalUsersList.remove(UniqueID);
            }
            
        for(Admin admin : adminsList ){
            if (UniqueID==userID){
                adminsList.remove(UniqueID);
            }
        }
        }
    }
    public void addAdmin(String name, String phoneNumber, String password){
        Admin newAdmin = new Admin(name, phoneNumber, password);
        adminsList.add(newAdmin);
    }
    public void addNormalUser(String name,String phoneNumber,String registrationDate){
        NormalUser newNormalUser = new NormalUser(name, phoneNumber, registrationDate);
        normalUsersList.add(newNormalUser);
    }
    public NormalUser getNormalUser(int UniqueID){
        for(NormalUser user : normalUsersList){
            if (user.getUniqueID()==UniqueID){
                return user;
            }
        }
        return null;
    }
    public Admin geAdmin(String password){
        for(Admin admin : adminsList){
            if (admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }


   
    public int getUniqueID() {
        return UniqueID;
    }


 
}

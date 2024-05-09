public class User {
    int userId;
    String UserName;
    String password;
    String registerDate;
    String phoneNumber;
    public User(String userName,String phoneNumber,int userId,String registerDate,String password){
        this.password = password;
        this.userId =userId;
        this.UserName = userName;
        this.phoneNumber = phoneNumber;
        this.registerDate = registerDate;

    }
}

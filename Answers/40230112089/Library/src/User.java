import java.io.Serializable;
public class User implements Serializable{
    // اینترفیس Serializable را implements کردیم تا یتوان اشیا این کلاس را Serialized کرد یعنی تبدیل به داده قابل ذخیره کردن در فایل کرد
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

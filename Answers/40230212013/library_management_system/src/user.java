import java.util.UUID;

public class user {
  private String name;
  private double id;
  private String phoneNumber;
  public user(String name, String phoneNumber)
  {
    this.name = name;
    this.id = UUID.randomUUID().hashCode();
    this.phoneNumber = phoneNumber;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getId() {
    return id;
  }
  public void setId(double id) {
    this.id = id;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}

public class user {
  private String name;
  private int id;
  private String phoneNumber;
  public user(String name,int id, String phoneNumber)
  {
    this.name = name;
    this.id = id;
    this.phoneNumber = phoneNumber;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}

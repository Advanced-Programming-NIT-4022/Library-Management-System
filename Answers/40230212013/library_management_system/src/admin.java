public class admin extends user{
  private int password;
  public admin(String name,int id, String phoneNumber, int password)
  {
    super(name, id, phoneNumber);
    this.password = password;
  }
  public int getPassword() {
    return password;
  }
  public void setPassword(int password) {
    this.password = password;
  }
  
}
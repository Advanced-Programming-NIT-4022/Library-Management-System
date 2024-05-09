public class admin extends user{
  private double password;
  public admin(String name, String phoneNumber)
  {
    super("Navid", "09204201533");
    this.password = 12345;
  }
  public double getPassword() {
    return password;
  }
  public void setPassword(double password) {
    this.password = password;
  }
  
}

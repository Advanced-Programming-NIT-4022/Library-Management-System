public class normalUser extends user {
  private String signUpDate;

  public normalUser(String name, int id, String phoneNumber, String signUpDate)
  {
    super(name, phoneNumber);
    this.signUpDate = signUpDate;
  }

  public String getSignUpDate() {
    return signUpDate;
  }

  public void setSignUpDate(String signUpDate) {
    this.signUpDate = signUpDate;
  }
  
}

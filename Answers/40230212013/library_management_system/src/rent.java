public class rent {
  private book book;
  private user user;
  private int rentalId;
  private String rentalDate;
  public rent(book book, user user)
  {
    this.book = book;
    this.user = user;
    this.rentalId = rentalId;
    this.rentalDate = rentalDate;
  }
  public book getBook() {
    return book;
  }
  public void setBook(book book) {
    this.book = book;
  }
  public user getUser() {
    return user;
  }
  public void setUser(user user) {
    this.user = user;
  }
  public int getRentId() {
    return rentalId;
  }
  public void setRentId(int rentId) {
    this.rentalId = rentalId;
  }
  public String getRentDate() {
    return rentalDate;
  }
  public void setRentDate(String rentDate) {
    this.rentalDate = rentalDate;
  }
  
}

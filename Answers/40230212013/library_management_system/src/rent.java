public class rent {
  private book book;
  private user user;
  private int rentId;
  private String rentDate;
  public rent(book book, user user)
  {
    this.book = book;
    this.user = user;
    this.rentId = rentId;
    this.rentDate = rentDate;
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
    return rentId;
  }
  public void setRentId(int rentId) {
    this.rentId = rentId;
  }
  public String getRentDate() {
    return rentDate;
  }
  public void setRentDate(String rentDate) {
    this.rentDate = rentDate;
  }
  
}

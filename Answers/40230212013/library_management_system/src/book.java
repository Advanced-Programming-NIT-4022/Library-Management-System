import java.util.UUID;

public class book {
  private int bookId;
  private String title;
  private String author;
  private boolean availabilityStatus;
  private String description;
  public book(String title, String author, String description)
  {
    this.bookId = UUID.randomUUID().hashCode();
    this.title = title;
    this.author = author;
    this.availabilityStatus = true;
    this.description = description;
  }
  @Override
  public String toString() {
      return "Book{" +
              "bookID=" + bookId +
              ", title='" + title + '\'' +
              ", author='" + author + '\'' +
              ", available=" + availabilityStatus +
              ", description='" + description + '\'' +
              '}';
  }
  public int getBookId() {
    return bookId;
  }
  public void setBookId(int bookId) {
    this.bookId = bookId;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public boolean isAvailabilityStatus() {
    return availabilityStatus;
  }
  public void setAvailabilityStatus(boolean availabilityStatus) {
    this.availabilityStatus = availabilityStatus;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  
}

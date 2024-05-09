public class Rent {
    int rentId;
    Book book;
    User user;
    Library libName;
    String rentDate;
    public Rent(int rentId , String rentDate , User user , Book book , Library libName){
        this.book = book;
        this.rentDate = rentDate;
        this.rentId = rentId;
        this.libName = libName;
        this.user = user;
    }
}

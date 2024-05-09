public class Rent {
    private Book rentalBook;
    private User userToRentBook;
    private String date;

    // constructor
    public Rent(Book book, User nrmUser, String date){
        this.rentalBook = book;
        this.userToRentBook = nrmUser;
        this.date = date;
    }

    // getters

    public String getDate(){
        return this.date;
    }

    public String getUserID(){
        return this.userToRentBook.getUserID();
    }

    public String getBookID(){
        return this.rentalBook.getId();
    }


}

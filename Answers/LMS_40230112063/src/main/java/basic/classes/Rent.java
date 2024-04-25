package basic.classes;

import java.time.LocalDate;

class Rent {

    protected Book reserved_book;
    protected NormalUser reserver_user;
    protected String rental_id ;
    protected LocalDate rental_date ;


    Rent(Integer book_id, boolean availability_status , Integer rental_id){
        this.reserved_book = new Book(book_id, availability_status);
        this.reserver_user = new NormalUser();
        this.rental_id = rental_id.toString();
        this.rental_date = java.time.LocalDate.now();
    }

}

package basic.classes;

import java.time.LocalDate;

class Rent {

    protected Integer reserved_book_id,reserver_user_id,rental_id;
    protected LocalDate rental_date ;


    Rent(Integer reserved_book_id, Integer reserver_user_id , Integer rental_id) {
        this.reserved_book_id = reserved_book_id;
        this.reserver_user_id = reserver_user_id;
        this.rental_id = rental_id;
        this.rental_date = LocalDate.ofEpochDay(LocalDate.now().toEpochDay());
    }

}

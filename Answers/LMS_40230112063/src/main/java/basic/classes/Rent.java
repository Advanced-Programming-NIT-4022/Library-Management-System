package basic.classes;

import java.time.LocalDate;

class Rent {

    protected String reserved_book_id,reserver_user_id,rental_id,rental_date;


    Rent(String reserved_book_id, String reserver_user_id , String rental_id) {
        this.reserved_book_id = reserved_book_id;
        this.reserver_user_id = reserver_user_id;
        this.rental_id = rental_id;
        this.rental_date = LocalDate.now().toString();
    }

}

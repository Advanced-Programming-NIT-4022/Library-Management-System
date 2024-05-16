import java.time.LocalDate;

public class Rent {
    Book bookie;
    NormalUser NormUser;
   int Rental_ID;
   LocalDate Rental_date;
public Rent (Book bookie , NormalUser NormUser , int Rental_ID , LocalDate Rental_date){
    this.bookie = bookie;
    this.NormUser = NormUser;
    this.Rental_ID = Rental_ID;
    this.Rental_date = Rental_date;
}

    public NormalUser getNormUser() {
        return NormUser;
    }

    public Book getBookie() {
        return bookie;
    }

    public int getRental_ID() {
        return Rental_ID;
    }
}

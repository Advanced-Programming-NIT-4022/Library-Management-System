package basic.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

class NormalUser extends User{
    protected LocalDate registration_date;

    NormalUser(String name, Integer id, Integer phone_number) {
        super(name, id, phone_number);
        registration_date = LocalDate.ofEpochDay(LocalDate.now().toEpochDay());
    }

}

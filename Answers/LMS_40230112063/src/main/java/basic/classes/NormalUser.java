package basic.classes;

import java.time.LocalDate;


class NormalUser extends User{
    protected String registration_date;

    NormalUser(String name, String id, String phone_number) {
        super(name, id, phone_number);
        registration_date = LocalDate.now().toString();
    }

}

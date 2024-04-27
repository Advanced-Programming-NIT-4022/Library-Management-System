package basic.classes;

class User {

    protected String name;
    protected Integer id, phone_number;

    User(String name , Integer id , Integer phone_number){
        this.id = id ;
        this.name = name;
        this.phone_number = phone_number;
    }

}

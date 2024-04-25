package basic.classes;

class User {

    protected String name, id, phone_number;

    public void castingId(Integer id){
        this.id = id.toString();
    }

    public void castingPhoneNumber(Integer phone_number) {
        this.id = phone_number.toString();
    }
}

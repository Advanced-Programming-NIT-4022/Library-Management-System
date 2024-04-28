public class Main {
    public static void main(String[] args) {
        Book book = new Book("Death" , "Sadra"  , "Death is a great book about the meaning of life");
        book.generateUniqueId();
        System.out.println(book.toString());
        System.out.println("___________________________");
        Book book1 = new Book("heelp" , "sipr" , "Nothing to say");
        book1.setAvailability_status(false);
        System.out.println(book1.toString());

//        NormalUser user = new NormalUser("Sadra" , )
    }
}

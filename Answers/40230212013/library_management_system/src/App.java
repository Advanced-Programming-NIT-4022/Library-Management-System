public class App {
    public static void main(String[] args) {
        library library = new library("My Library", 100, "9:00 AM - 5:00 PM");
        cli cli = new cli(library);
        cli.start();
    }
}

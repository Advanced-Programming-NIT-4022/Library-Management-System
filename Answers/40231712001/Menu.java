import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Menu {

    private ArrayList<String> splitString(String input) {
        ArrayList<String> result = new ArrayList<>();
        Matcher matcher = Pattern.compile("\"[^\"]*\"").matcher(input);

        int start = 0;

        while (matcher.find()) {
            String match = matcher.group();
            int matchStart = matcher.start();
            int matchEnd = matcher.end();
            if (matchStart > start) {
                String substring = input.substring(start, matchStart).trim();
                if (!substring.isEmpty()) {
                    String[] words = substring.split("\\s+");
                    for (String word : words) {
                    result.add(word);
                    }
                }
            }
            result.add(match.replaceAll("^\"|\"$", ""));
            start = matchEnd;
        }

        if (start < input.length()) {
            String substring = input.substring(start).trim();
            if (!substring.isEmpty()) {
                String[] words = substring.split("\\s+");
                for (String word : words) {
                    result.add(word);
                }
            }
        }
        return result;
    }

    private void help() {
        System.out.println("\u001B[36m -'add book <name> <author> <description>' : Add a new book to the library");
        System.out.println(" -'get hrs' : Retrieve library operating hours");
        System.out.println(" -'rent <bookName> <memberID> <memberPassword>' : Rent a book from the library");
        System.out.println(" -'add member <studentID> <password>' : Add a new member to the library (admin privilege required)");
        System.out.println(" -'get available books' : View available books for rental");
        System.out.println(" -'remove member <memberID>' : Remove a member from the library (admin privilege required)");
        System.out.println(" -'return <bookName>' : Return a rented book to the library");
        System.out.println(" -'exit' : Exit the System\u001B[37m");
    }

    private void exit() {
        System.out.println("\u001B[34m##\u001B[31mThanks for Choosing Us\u001B[34m##\u001B[37m");
        System.exit(0);
    }

    public void run() {
        Lib lib = new Lib("7:00AM-7:00PM");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\u001B[32m>> \u001B[33m");
            ArrayList<String> input = splitString(scanner.nextLine());
            System.out.print("\u001B[37m");

            try {
                if (input.get(0).toLowerCase().equals("exit") && input.size() == 1) {
                    exit();
                }
                else if (input.get(0).toLowerCase().equals("help") && input.size() == 1) {
                    help();
                }
                else if (input.get(0).toLowerCase().equals("get") && input.get(1).toLowerCase().equals("hrs") && input.size() == 2) {
                    System.out.println("Library working Hours:");
                    System.out.println(lib.getOperatingHrs());
                }
                else if (input.get(0).toLowerCase().equals("add") && input.get(1).toLowerCase().equals("book")) {
                    if (input.size() == 5) {
                        Random rand = new Random();
                        Book b = new Book(rand.nextInt() % 9999, input.get(2), input.get(3), input.get(4));
                        lib.addBook(b);
                        System.out.println("Thanks for your Contribution!");
                    }
                    else
                        System.out.println(" -'add book <name> <author> <description>'");
                }
                else
                    System.out.println("\u001B[31mInvalid Prompt");
            } catch (java.lang.ArrayIndexOutOfBoundsException e) {}
        }
    }
}

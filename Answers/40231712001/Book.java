import java.util.ArrayList;
import java.util.List;

class Book {
    // Class level constants
    private static final int PRINT_WIDTH = 40;

    // Attributes
    private final long bookID;
    private String title;
    private String author;
    private String description;
    private boolean isAvailable;

    // Constructor
    public Book(long bookID_a, String title_a, String author_a, String description_a) {
        bookID = bookID_a;
        title = title_a;
        author = author_a;
        description = description_a;
        isAvailable = true;
    }

    // Getter/Setter(s)
    public long getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void toggleAvailablity() {
        isAvailable = !isAvailable;
    }

    // Print info for the book
    public void showBook() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";

        if (isAvailable)
            System.out.print(ANSI_GREEN);
        else
            System.out.print(ANSI_RED);

        String strID = Util.toHex((int) bookID);
        System.out.print("+");
        for (int i = 0; i < PRINT_WIDTH / 2 - 1 - strID.length() / 2; i++) System.out.print("-");
        System.out.print("~" + strID + "~");
        for (int i = 0; i < PRINT_WIDTH / 2 - 1 - strID.length() / 2; i++) System.out.print("-");
        System.out.println("+");

        System.out.print("| ~Title: ");
        for (int i = 0; i < PRINT_WIDTH - 9; i++) System.out.print(" ");
        System.out.println("|");

        List<String> formattedTitle = Util.stringWrap(title, PRINT_WIDTH - 8);
        for (String s : formattedTitle) {
            System.out.print("|    " + s);
            for (int i = 0; i < PRINT_WIDTH - s.length() - 4; i++) System.out.print(" ");
            System.out.println("|");
        }

        System.out.print("| ~Description: ");
        for (int i = 0; i < PRINT_WIDTH - 15; i++) System.out.print(" ");
        System.out.println("|");

        List<String> formattedDescription = Util.stringWrap(description, PRINT_WIDTH - 8);
        for (String s : formattedDescription) {
            System.out.print("|    " + s);
            for (int i = 0; i < PRINT_WIDTH - s.length() - 4; i++) System.out.print(" ");
            System.out.println("|");
        }

        System.out.print("| ~By: ");
        for (int i = 0; i < PRINT_WIDTH - 6; i++) System.out.print(" ");
        System.out.println("|");

        List<String> formattedAuthor = Util.stringWrap(author, PRINT_WIDTH - 8);
        for (String s : formattedAuthor) {
            System.out.print("|    " + s);
            for (int i = 0; i < PRINT_WIDTH - s.length() - 4; i++) System.out.print(" ");
            System.out.println("|");
        }

        System.out.print("+");
        for (int i = 0; i < PRINT_WIDTH; i++) System.out.print("-");
        System.out.println("+");

        System.out.print(ANSI_RESET);
    }
}

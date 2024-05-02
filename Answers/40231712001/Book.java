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
    public Book(long bookID_a, String title_a, String author_a, String description_a, boolean isAvailable_a) {
        bookID = bookID_a;
        title = title_a;
        author = author_a;
        description = description_a;
        isAvailable = isAvailable_a;
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

    // Private Utilities
    private List<String> stringWrap(String string, int maxChar) {
        List<String> subLines = new ArrayList<String>();
        int length = string.length();
        int start = 0;
        int end = maxChar;
        if (length > maxChar) {
            int noOfLines = (length / maxChar) + 1;
            int endOfStr[] = new int[noOfLines];
            for (int f = 0; f < noOfLines - 1; f++) {
                int end1 = maxChar;
                endOfStr[f] = end;
                if (string.charAt(end - 1) != ' ') {
                    if (string.charAt(end - 2) == ' ') {
                        subLines.add(string.substring(start, end - 1));
                        start = end - 1;
                        end = end - 1 + end1;
                    } else if (string.charAt(end - 2) != ' '
                            && string.charAt(end) == ' ') {
                        subLines.add(string.substring(start, end));
                        start = end;
                        end = end + end1;
                    } else if (string.charAt(end - 2) != ' ') {
                        subLines.add(string.substring(start, end) + "-");
                        start = end;
                        end = end + end1;
                    } else if (string.charAt(end + 2) == ' ') {
                        int lastSpaceIndex = string.substring(start, end)
                                .lastIndexOf("");
                        subLines.add(string.substring(start, lastSpaceIndex));

                        start = lastSpaceIndex;
                        end = lastSpaceIndex + end1;
                    }
                } else {
                    subLines.add(string.substring(start, end));
                    start = end;
                    end = end + end1;
                }
            }
            subLines.add(string.substring(endOfStr[noOfLines - 2], length));
        }
        if (subLines.size() == 0) subLines.add(string);
        return subLines;
    }

    private static String toHex(int decimal){
        int rem;  
        String hex="";   
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
        while(decimal>0)  
        {  
            rem=decimal%16;   
            hex=hexchars[rem]+hex;   
            decimal=decimal/16;  
        }  
        return hex;  
    }
    
    // Public Utilities
    public void showBook() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";

        if (isAvailable)
            System.out.print(ANSI_GREEN);
        else
            System.out.print(ANSI_RED);

        String strID = toHex((int) bookID);
        System.out.print("+");
        for (int i = 0; i < PRINT_WIDTH / 2 - 1 - strID.length() / 2; i++) System.out.print("-");
        System.out.print("~" + strID + "~");
        for (int i = 0; i < PRINT_WIDTH / 2 - 1 - strID.length() / 2; i++) System.out.print("-");
        System.out.println("+");

        System.out.print("| ~Title: ");
        for (int i = 0; i < PRINT_WIDTH - 9; i++) System.out.print(" ");
        System.out.println("|");

        List<String> formattedTitle = stringWrap(title, PRINT_WIDTH - 8);
        for (String s : formattedTitle) {
            System.out.print("|    " + s);
            for (int i = 0; i < PRINT_WIDTH - s.length() - 4; i++) System.out.print(" ");
            System.out.println("|");
        }

        System.out.print("| ~Description: ");
        for (int i = 0; i < PRINT_WIDTH - 15; i++) System.out.print(" ");
        System.out.println("|");

        List<String> formattedDescription = stringWrap(description, PRINT_WIDTH - 8);
        for (String s : formattedDescription) {
            System.out.print("|    " + s);
            for (int i = 0; i < PRINT_WIDTH - s.length() - 4; i++) System.out.print(" ");
            System.out.println("|");
        }

        System.out.print("| ~By: ");
        for (int i = 0; i < PRINT_WIDTH - 6; i++) System.out.print(" ");
        System.out.println("|");

        List<String> formattedAuthor = stringWrap(author, PRINT_WIDTH - 8);
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

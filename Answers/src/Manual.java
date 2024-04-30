public class Manual {
    public static void print() {
        System.out.println("All of commands are :\n");
        // command add
        System.out.println("lib add book <name> <author> <subtitle> : Add a new book to the library.");

        // command hrs
        System.out.println("lib get hrs : Retrieve library operating hours.");

        // command rent from library
        System.out.println("lib rent <bookName> : Rent a book from the library.");

        // command add member
        System.out.println("lib add member <studentID> <password>" +
                " : Add a new member to the library (admin privilege required).");

        // command rent for member
        System.out.println("lib rent <bookName> <memberName> <memberID>" +
                " : Rent a book for a specific member.");

        // command view book
        System.out.println("lib get available books : View available books for rental.");

        // command remove member
        System.out.println("lib remove member <memberID>" +
                ": Remove a member from the library (admin privilege required).");

        // command return book
        System.out.println("lib return <bookName> : Return a rented book to the library.");

        // command exit
        System.out.println("lib exit : exit the program");
    }
}

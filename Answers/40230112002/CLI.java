public class CLI {
    private static Library library;

    public CLI(Library library) {
        CLI.library = library;
    }

    public void CommandLineArgument(String[] args) {

            try {
                if (args[0].equalsIgnoreCase("lib")) {
                    if (args[1].equalsIgnoreCase("add")) {
                        if (args[2].equalsIgnoreCase("book")) {
                            LibAddBook(args);
                        } else if (args[2].equalsIgnoreCase("Member")) {
                            LibAddUser(args);
                        } else if (args[2].equalsIgnoreCase("admin")) {
                            LibAddAdmin(args);
                        }
                    }

                    if (args[1].equalsIgnoreCase("get")) {
                        if (args[2].equalsIgnoreCase("hrs")) {
                            System.out.println(library.getHrs());

                        } else if (args[2].equalsIgnoreCase("available") && args[3].equalsIgnoreCase("books")) {
                            library.ShowAvailableBooks();
                        }

                    }

                    if (args[1].equalsIgnoreCase("rent")) {
                        if (args.length == 4) {
                            LibRentBook(args);
                        }
                        if (args.length == 5) {
                            LibRentBookforUser(args);
                        }

                    }
                    if (args[1].equalsIgnoreCase("return")) {
                        LibReturnBook(args);
                    }

                    if (args[1].equalsIgnoreCase("remove") && args[2].equalsIgnoreCase("member")) {
                        LibRemoveUser(args);
                    }
                } else {
                    System.out.println("[!] # Invalid Command #\n [+] Enter A Method to work with");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
        public void LibAddBook (String[]args){
            if (args.length == 6) {
                String BookTitle = args[3];
                String BookAuthor = args[4];
                String Description = args[5];
                library.addBook(BookTitle, BookAuthor, Description);
                System.out.println("[+] Book: " + BookTitle + " Added to The Library");
            } else {
                System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (Title , Author , Description) ");
            }
        }

        public void LibAddUser (String[]args){
            if (args.length == 5) {
                String userName = args[3];
                String userPhone = args[4];
                library.addUser(userName, userPhone);
                System.out.println("[+] User: " + userName + " Add to the Library");
            } else {
                System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (userName , userPhone) ");
            }
        }


        public void LibAddAdmin (String[]args){
            if (args.length == 5) {
                String name = args[3];
                String phoneNumber = args[4];
                System.out.println("[+] Enter a password: ");
                // reads password without showing it on the console (just like setting pass in linux os)
                //it cannot be run in IDE because it is for console like cmd or powershell
                //you'll get a nullpointer error if you run it because there is no console to read from
                String Password = String.valueOf(System.console().readPassword());
                System.out.println("[+] Confirm your password: ");
                String confirmPassword = String.valueOf(System.console().readPassword());

                if (Password.equals(confirmPassword)) {
                    System.out.println("[+] Password set successfully!");
                } else {
                    System.out.println("[!] # Passwords do not match. Please try again #");
                }
                library.addAdmin(name, phoneNumber, Password);
                System.out.println("[+] Admin: " + name + " Added to the Library");
            }
        }

        public void LibRentBook (String[]args){
            if (args.length == 4) {
                String BookName = args[3];
                String UserName = args[2];
                //I don't know how to automatically get the Username without getting the argument from console
                library.BookRental(BookName, UserName);
            } else {
                System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (BookName , UserName) ");
            }
        }

        public void LibRentBookforUser (String[]args){
            if (args.length == 6) {
                String BookName = args[3];
                String UserName = args[4];
                int UserID = Integer.parseInt(args[5]);
                //String Exception Handling Needed Here
                library.BookRentalForUser(BookName, UserName, UserID);
            } else {
                System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (BookName , UserName , UserID) ");
            }
        }

        public void LibReturnBook(String[] args){
        if(args.length == 4){
           String BookName = args[3];
           library.ReturnBook(BookName);
        }
        else{
            System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (BookName) ");
        }
        }

        public void LibRemoveUser(String[] args){
        if(args.length == 4){
            //String Exception Handling Needed Here
            Integer UserID = Integer.valueOf(args[3]);
            library.RemoveUser(UserID);
        }
        else {
            System.out.println("[!] # Unacceptable Arguments #\n [+] Enter (UserID) ");
        }
        }
}
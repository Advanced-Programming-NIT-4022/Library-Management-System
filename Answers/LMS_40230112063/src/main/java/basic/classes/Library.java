package basic.classes;

import java.util.*;

public class Library {

    Random random = new Random();

    private final String library_name;
    private final int capacity;

    public String getLibraryName() {
        return library_name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Library(String library_name, int capacity) {
        this.library_name = library_name;
        this.capacity = capacity;
    }

//-----------------------------------------------------------------------------------------------

    ArrayList<NormalUser> normalUsers = new ArrayList<>();
    protected NormalUser normalUser;

    public void addMember(String name, Integer phone_number) {
        random.setSeed(System.currentTimeMillis());
        this.normalUser = new NormalUser(name, random.nextInt(), phone_number);
        normalUsers.add(normalUser);
    }

    public void rmMember(String name, Integer phone_number) {
        for (NormalUser iterator : normalUsers) {
            if (Objects.equals(iterator.name, name) && Objects.equals(iterator.phone_number, phone_number)) {
                normalUsers.remove(iterator);
                System.out.println("The user with name : " + iterator.name + ", phone number : " + iterator.phone_number +
                        "and Id : " + iterator.id + "successfully deleted from the registered users");
                return;
            }
            System.out.println("There is no user with the given information in registered user list .");
            return;
        }
    }

    ArrayList<Book> book_repository = new ArrayList<>();
    protected Book book;

    public void addBook(String title, String author, String description) {
        random.setSeed(System.currentTimeMillis());
        book = new Book(random.nextInt(), true);
        book.author = author;
        book.title = title;
        book.description = description;
        book_repository.add(book);
        System.out.println("The Book with " + book.title + "title ," + book.author + "author , and " +
                book.book_id + "ID , successfully was added to the book depository .");
    }

    public void rmBook(String title, String author) {
        for (Book iterator : book_repository) {
            if (Objects.equals(iterator.title, title) && Objects.equals(iterator.author, author)) {
                book_repository.remove(iterator);
                System.out.println("The Book with " + iterator.title + "title ," + iterator.author + "author , and " +
                        iterator.book_id + "ID , successfully deleted from the book depository .");
                return;
            }
        }
        System.out.println("There are no books with the given information. Make sure you have entered the book info correctly.");
    }


    ArrayList<Rent> rented_book_repo = new ArrayList<>();
    protected Rent rent;

    public void rentBook(String title, String author, String user_name, Integer user_phone_number) {
        random.setSeed(System.currentTimeMillis());
        Integer book_id, user_id;
        book_id = Book.idFinder(title, author, book_repository);

        if (book_id != -1) {
            user_id = NormalUser.idFinder(user_name, user_phone_number, normalUsers);
            if (user_id != -1) {
                rent = new Rent(book_id, user_id, random.nextInt());
            } else {
                System.out.println("The entered phone number or name is not registered in the system." +
                        " (Such a user does not exist in the list of registered users)");
                return;
            }
        } else {
            System.out.println("The entered book name or author name is not registered in the system." +
                    " (Such a book does not exist in the list of registered books)");
            return;
        }

        rented_book_repo.add(rent);

        for (Book iterator : book_repository) {
            if (Objects.equals(iterator.book_id, book_id)) {
                iterator.availability_status = false;
            }
        }

    }


    public void returnBook(String title, String author, String user_name, Integer user_phone_number) {
        Integer book_id, user_id;
        book_id = Book.idFinder(title, author, book_repository);

        if (book_id != -1) {
            user_id = NormalUser.idFinder(user_name, user_phone_number, normalUsers);
            if (user_id == -1) {
                System.out.println("The entered phone number or name is not registered in the system." +
                        " (Such a user does not exist in the list of registered users)");
                return;
            }
        } else {
            System.out.println("The entered book name or author name is not registered in the system." +
                    " (Such a book does not exist in the list of registered books)");
            return;
        }

        for (Rent iterator : rented_book_repo) {
            if (Objects.equals(iterator.reserved_book_id, book_id) && Objects.equals(iterator.reserver_user_id, user_id))
                rented_book_repo.remove(iterator);

        }

        for (Book iterator : book_repository) {
            if (Objects.equals(iterator.book_id, book_id))
                iterator.availability_status = true;
        }


    }

}

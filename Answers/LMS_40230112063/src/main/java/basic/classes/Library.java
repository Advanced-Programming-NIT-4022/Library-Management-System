package basic.classes;

import java.util.*;

public class Library {

    private Long initial_value_of_id = 1598713L;

    private String idGenerator() {
        initial_value_of_id++;
        return initial_value_of_id.toString();
    }

    private final String library_name;
    private final int capacity;
    private final String operating_hours;

    public String getLibraryName() {
        return library_name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getOperating_hours() {
        return operating_hours;
    }

    public Library(String library_name, int capacity, String operating_hours) {
        this.library_name = library_name;
        this.capacity = capacity;
        this.operating_hours = operating_hours;
        admins.add(new Admin("AmirHossein Zakeri", "40520", "09114430698", "zakeri_1383@@"));
        DataBaseMethods.adminDataInsert(admins);
    }


    ArrayList<NormalUser> normalUsers = new ArrayList<>();
    protected NormalUser normalUser;

    public NormalUser memberExistenceChecker(String name, String phone_number) {
        for (NormalUser iterator : normalUsers) {
            if (Objects.equals(iterator.name, name) && Objects.equals(iterator.phone_number, phone_number))
                return iterator;
        }
        return null;
    }

    public void addMember(String name, String phone_number) {
        this.normalUser = new NormalUser(name, idGenerator(), phone_number);
        normalUsers.add(normalUser);
        DataBaseMethods.normalUserDataInsert(normalUsers);
    }

    public void rmMember(String name, String phone_number) {
        for (NormalUser iterator : normalUsers) {
            if (Objects.equals(iterator.name, name) && Objects.equals(iterator.phone_number, phone_number)) {
                normalUsers.remove(iterator);
                System.out.println("The user with name : " + iterator.name + ", phone number : " + iterator.phone_number +
                        "and Id : " + iterator.id + "successfully deleted from the registered users");
                DataBaseMethods.normalUserDataInsert(normalUsers);
                return;
            }
            System.out.println("There is no user with the given information in registered user list .");
            return;
        }
    }

    public void printAllMembers() {
        if (normalUsers.isEmpty()) {
            System.out.println("There is no registered normal user in the library");
        } else {
            for (NormalUser iterator : normalUsers) {
                System.out.println("********");
                System.out.println("name : " + iterator.name);
                System.out.println("id : " + iterator.id);
                System.out.println("phone number : " + iterator.phone_number);
                System.out.println("registration date : " + iterator.registration_date);
            }
        }
    }


    ArrayList<Admin> admins = new ArrayList<>();
    protected Admin admin;


    public Admin adminExistenceChecker(String name, String phone_number, String password) {
        for (Admin iterator : admins) {
            if (Objects.equals(iterator.name, name) && Objects.equals(iterator.phone_number, phone_number) && Objects.equals(iterator.getPassword(), password))
                return iterator;
        }
        return null;
    }

    public void addAmin(String name, String phone_number, String password) {
        this.admin = new Admin(name, idGenerator(), phone_number, password);
        admins.add(admin);
        DataBaseMethods.adminDataInsert(admins);
    }

    public void printAllAdmins() {
        if (admins.isEmpty()) {
            System.out.println("There is no registered admin in the library");
        } else {
            for (Admin iterator : admins) {
                System.out.println("********");
                System.out.println("name : " + iterator.name);
                System.out.println("id : " + iterator.id);
                System.out.println("phone number : " + iterator.phone_number);
            }
        }
    }


    ArrayList<Book> book_repository = new ArrayList<>();
    protected Book book;

    public void addBook(String title, String author, String description) {
        book = new Book(title, author, description, idGenerator(), true);
        book_repository.add(book);
        System.out.println("The Book " + book.title + " with author " + book.author + " and Id " +
                book.book_id + ", successfully was added to the book depository .");
        DataBaseMethods.bookDataInsert(book_repository);
    }

    public void rmBook(String title, String author) {
        for (Book iterator : book_repository) {
            if (Objects.equals(iterator.title, title) && Objects.equals(iterator.author, author)) {
                book_repository.remove(iterator);
                System.out.println("The Book " + iterator.title + " with author " + iterator.author + " and Id " +
                        iterator.book_id + ", successfully deleted from the book depository .");
                DataBaseMethods.bookDataInsert(book_repository);
                return;
            }
        }
        System.out.println("There are no books with the given information. Make sure you have entered the book info correctly.");
    }

    public Book bookExistenceChecker(String title, String author) {
        for (Book iterator : book_repository) {
            if (Objects.equals(iterator.title, title) && Objects.equals(iterator.author, author)) {
                return iterator;
            }
        }
        return null;
    }

    public void printAvailableBooks() {
        if (book_repository.isEmpty()) {
            System.out.println("there is no book in the book repository");
        } else {
            for (Book iterator : book_repository) {
                if (iterator.availability_status) {
                    System.out.println("********");
                    System.out.println("Name : " + iterator.title);
                    System.out.println("Author : " + iterator.author);
                    System.out.println("Description : " + iterator.description);
                    System.out.println("BookID : " + iterator.book_id);
                }
            }
        }

    }


    ArrayList<Rent> rented_book_repo = new ArrayList<>();
    protected Rent rent;

    public void rentBook(String title, String author, String user_name, String user_phone_number) {
        Book book_intended_to_rent = bookExistenceChecker(title, author);
        NormalUser renter = memberExistenceChecker(user_name, user_phone_number);
        if (book_intended_to_rent != null) {
            if (renter != null) {
                rent = new Rent(book_intended_to_rent.book_id, renter.id, idGenerator());
                rented_book_repo.add(rent);
                book_repository.get(book_repository.indexOf(book_intended_to_rent)).availability_status = false;
                System.out.println("The Book with " + title + "title ," + author + "author , and " +
                        book_intended_to_rent.book_id + "ID , successfully rented by " + user_name + " with ID "
                        + renter.id);
                DataBaseMethods.rentedBookDataInsert(rented_book_repo);
            } else {
                System.out.println("The entered phone number or name is not registered in the system." +
                        " (Such a user does not exist in the list of registered users)");
            }
        } else {
            System.out.println("The entered book name or author name is not registered in the system." +
                    " (Such a book does not exist in the list of registered books)");
        }


    }


    public void returnBook(String title, String author, String user_name, String user_phone_number) {
        Book book_intended_to_return = bookExistenceChecker(title, author);
        NormalUser returner = memberExistenceChecker(user_name, user_phone_number);
        if (book_intended_to_return != null) {
            if (returner != null) {
                for (Rent iterator : rented_book_repo) {
                    if (Objects.equals(iterator.reserved_book_id, book_intended_to_return.book_id) && Objects.equals(iterator.reserver_user_id, returner.id)) {
                        rented_book_repo.remove(iterator);
                        book_repository.get(book_repository.indexOf(book_intended_to_return)).availability_status = true;
                        DataBaseMethods.rentedBookDataInsert(rented_book_repo);
                        return;
                    }

                }
                System.out.println("The book with the given information is not rented or the user name you entered is not the real renter !!");

            } else {
                System.out.println("The entered phone number or name is not registered in the system." +
                        " (Such a user does not exist in the list of registered users)");
            }
        } else {
            System.out.println("The entered book name or author name is not registered in the system." +
                    " (Such a book does not exist in the list of registered books)");
        }
    }

    public void dataRetriever() {
        DataBaseMethods.bookDataRetrieve(book_repository);
        DataBaseMethods.adminDataRetrieve(admins);
        DataBaseMethods.normalUserDataRetrieve(normalUsers);
    }
}

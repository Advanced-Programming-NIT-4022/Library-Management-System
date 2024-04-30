# Library Management System

Welcome to our Library Management System (LMS) project! In this endeavor, we aim to implement a comprehensive library program with a user-friendly command-line interface (CLI). Our system caters to two distinct roles:

1. Normal Users
2. Admins

## Features

- New users can seamlessly sign up using their student ID and their information.
- Our system boasts a robust admin panel, with the ability to add new admins, books, and perform book removals.
- Normal users enjoy the convenience of borrowing and returning books hassle-free.
- Each user, whether normal or admin, can conveniently delete their account whenever necessary.

## Implementation Guidelines

Our project is grounded in Object-Oriented Programming (OOP) principles, leveraging the following key classes:

### Book

Each book is characterized by the following attributes:
- Unique bookID
- Title
- Author
- Availability status
- Description

Attributes are encapsulated within the Book class to maintain data integrity. Upon instantiation, a book's availability status is automatically status to true, and a unique bookID is generated.

### User

Users possess the following attributes:
- Name
- Unique ID
- Phone number

User information is essential for system operations, and each user is uniquely identified by an ID. 

### Normal User

In addition to the standard user attributes, normal users are also timestamped with their date of registration.

### Admin

Admins share user attributes but possess additional privileges and authentication through a password.

### Rent

The Rent class acts as a bridge between users and books, facilitating book rental transactions. Key attributes include:
- Book object
- Normal user object
- Rental ID
- Rental date

### Library

The central hub of our system, the Library class encapsulates core library functionalities:
- Library name
- Capacity
- Operating hours
- Book repository
- User and rental registries

Methodologies like book rental, return, addition, and removal of members and books are seamlessly handled within the Library class.

## Command-Line Interface (CLI)

Our CLI class facilitates user interaction through intuitive commands:

- `lib add book <name> <author> <subtitle>`: Add a new book to the library.
- `lib get hrs`: Retrieve library operating hours.
- `lib rent <bookName>`: Rent a book from the library.
- `lib add member <studentID> <password>`: Add a new member to the library (admin privilege required).
- `lib rent <bookName> <memberName> <memberID>`: Rent a book for a specific member.
- `lib get available books`: View available books for rental.
- `lib remove member <memberID>`: Remove a member from the library (admin privilege required).
- `lib return <bookName>`: Return a rented book to the library.

## Getting Started

To start using our system, simply run the main class `MyApp` and follow the prompts.

## Conclusion

Thank you for choosing our Library Management System. We're excited to provide you with an efficient and user-friendly platform for all your library needs. Happy reading!
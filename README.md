# Library Management System

This is a simple Java application for managing a library system. It allows librarians to perform various tasks including adding new books, updating book details, checking out books to users, and managing user accounts.

## Classes

### Book Class
- Represents a book with attributes such as book ID, title, author, genre, and availability status.

### User Class
- Represents a user with attributes such as user ID, name, contact information, and borrowed books.

### Library Class
- Contains methods for managing books and users.
- Allows adding new books and users, checking out and returning books, and searching for books by title or author.

### Main Class (LibraryManagementSystem)
- Entry point for the program.
- Provides a menu-driven interface for librarians to perform tasks such as adding books, adding users, displaying books, borrowing or checking out books, returning books, and searching for books.

## Additional Features
- File Handling: Implements simple file-based data persistence to store book and user information between application runs.
- Error Handling: Handles invalid user inputs and edge cases gracefully.
- Validation: Implements validation checks to ensure that book and user information is entered correctly.
- Documentation: Provides adequate comments to explain the purpose of each class and method in the code.

## How to Run
1. Ensure you have Java installed on your system.
2. Compile the Java files using `javac *.java`.
3. Run the program using `java LibraryManagementSystem`.

## Usage
- Follow the menu prompts to perform various tasks such as adding books, adding users, borrowing or returning books, etc.
- Input data as prompted, ensuring correctness and validity.
- View the console output for feedback on the actions performed.

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.
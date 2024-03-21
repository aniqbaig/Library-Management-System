import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    /*Function that uses user arguments to create a new instance 
    of the book class, store it in the arrayList and display a message on completion*/
    public void AddBook(int bookId, String title, String author, String genre) {
        try {
            validateBookId(bookId);
            validateTitle(title);
            validateAuthor(author);
            validateGenre(genre);

            Book newBook = new Book(bookId, title, author, genre, true);
            books.add(newBook);
            System.out.println("New Book has been added Successfully.");
            writeBookToFile(newBook);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input format. Please enter a valid integer for Book ID.");
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void validateBookId(int bookId) throws InputMismatchException {
        if (bookId <= 0) {
            throw new InputMismatchException("Book ID must be a positive integer.");
        }
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
    }

    private void validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
    }

    private void validateGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be empty.");
        }
    }

    private void writeBookToFile(Book book) throws IOException {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("LibraryBooks.txt", true))) {
            fileWriter.write(book.toString());
            fileWriter.newLine();
        }
    }


    // method to add a user
    public void addUser(User user) {
        try {
            // Check if the provided user object is null
            if (user == null) {
                throw new IllegalArgumentException("User object is null. Cannot add null user.");
            }

            // Check if the user ID is negative
            if (user.getUserID() < 0) {
                throw new IllegalArgumentException("User ID cannot be negative.");
            }

            // Check if the user ID is not a number
            if (!isNumeric(String.valueOf(user.getUserID()))) {
                throw new IllegalArgumentException("User ID must be a number.");
            }

            // Check if the user already exists in the library
            if (users.contains(user)) {
                throw new IllegalArgumentException("User already exists in the library.");
            }

            // Add the user to the library
            users.add(user);
            System.out.println("New user added successfully!");
            } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

// Helper method to check if a string is numeric
private boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");
}

    // Method to check out a book to a user
    public void checkOutBook(int bookID, int userID) {
    // Find the book and user
    Book book = findBookByID(bookID);
    User user = findUserByID(userID);

    // Check if the book and user exist
    if (book == null) {
        System.out.println("Error: Book not found.");
        return;
    }
    if (user == null) {
        System.out.println("Error: User not found.");
        return;
    }

    // Check if the book is available
    if (!book.isAvailable()) {
        System.out.println("Error: Book is not available for checkout.");
        return;
    }

    // Add the book to the user's borrowed books and mark it as unavailable
    user.getBorrowedBooks().add(book);
    book.setAvailable(false);
    System.out.println("Book successfully checked out.");
    }

    // Method to return a book to the library
    public void returnBook(int bookID, int userID) {
        Book book = findBookByID(bookID);
        User user = findUserByID(userID);

        if (book != null && user != null && !book.isAvailable() && user.getBorrowedBooks().contains(book)) {
            user.getBorrowedBooks().remove(book);
            book.setAvailable(true);
            System.out.println("Book successfully returned.");
        } else {
            System.out.println("Book not borrowed by the user or user not found.");
        }
    }

    // Method to search for books by title or author
    public void searchBooks(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("Error: Search keyword cannot be empty.");
            return;
        }

        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(keyword) || book.getAuthor().equalsIgnoreCase(keyword)) {
                System.out.println(book);
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("No books found matching the search keyword: " + keyword);
        }
    }

    // Getter for the books list
    public ArrayList<Book> getBooks() {
        return books;
    }

    // Helper method to find a book by ID
    private Book findBookByID(int bookID) {
        for (Book book : books) {
            if (book.getBookID() == bookID) {
                return book;
            }
        }
        return null;
    }

    // Helper method to find a user by ID
    private User findUserByID(int userID) {
        for (User user : users) {
            if (user.getUserID() == userID) {
                return user;
            }
        }
        return null;
    }
}

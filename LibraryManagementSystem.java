import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Display Books");
            System.out.println("4. Borrow/Check Out Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Add Book
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    //Book book = new Book();
                    library.AddBook(bookID, title, author, genre);
                    break;
                case 2:
                    // Add User
                    System.out.print("Enter User ID: ");
                    int userID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Contact Info: ");
                    String contactInfo = scanner.nextLine();
                    User user = new User(userID, name, contactInfo);
                    library.addUser(user);
                    break;
                case 3:
                    // Display Books
                    System.out.println("Books in the library:");
                    for (Book b : library.getBooks()) {
                        System.out.println(b);
                    }
                    break;
                case 4:
                    // Borrow/Check Out Book
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowBookID = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int borrowUserID = scanner.nextInt();
                    library.checkOutBook(borrowBookID, borrowUserID);
                    break;
                case 5:
                    // Return Book
                    System.out.print("Enter Book ID to return: ");
                    int returnBookID = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int returnUserID = scanner.nextInt();
                    library.returnBook(returnBookID, returnUserID);
                    break;
                case 6:
                    // Search Books
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.next();
                    library.searchBooks(keyword);
                    break;
                case 7:
                    // Exit
                    
                    // Exit
                    System.out.println("Exiting Library Management System...");
                    scanner.close();
                    java.lang.System.exit(0);
                    break;
                default:
                    java.lang.System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}

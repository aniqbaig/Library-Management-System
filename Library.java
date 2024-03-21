import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

     /*Function that uses user arguments to create a new instance 
    of the book class, store it in the arrayList and display a message on completion*/
    public void AddBook(int BookId,String title,String author,String genre){
        Book NewBook=new Book(BookId,title,author,genre,true);
        books.add(NewBook);
        System.out.println("New Book has been added Sucessfully.");
        BufferedWriter filewriter=null;
        try{
          filewriter=new BufferedWriter(new FileWriter("Library Books.txt",true));
         filewriter.write(NewBook.toString());
         filewriter.write("\n");}
         catch(IOException  e){
            System.out.println("Error writing to file."+e.getMessage());
         }finally{
            if(filewriter!=null){
                try{filewriter.close();}
                catch(IOException e){
                    System.err.println("Error in file handling"+e.getMessage());
                }
            }
         }
    }

    // Method to add a new user to the library
    public void addUser(User user) {
        users.add(user);
        System.out.println("New user added succesfully!");
    }

    // Method to check out a book to a user
    public void checkOutBook(int bookID, int userID) {
        Book book = findBookByID(bookID);
        User user = findUserByID(userID);

        if (book != null && user != null && book.isAvailable()) {
            user.getBorrowedBooks().add(book);
            book.setAvailable(false);
            System.out.println("Book successfully checked out.");
        } else {
            System.out.println("Book not available or user not found.");
        }
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
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(keyword) || book.getAuthor().equalsIgnoreCase(keyword)) {
                System.out.println(book);
            }
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
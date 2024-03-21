public class Book {
    private int bookID;
    private String title;
    private String author;
    private String genre;
    private boolean available;

    public Book(int bookID, String title, String author, String genre, boolean available) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
    }

    // Getters and Setters
    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Override toString method for better printing
    @Override
    public String toString() {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Available: " + available;
    }
}
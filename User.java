import java.util.ArrayList;
class User {
    private int userID;
    private String name;
    private String contactInfo;
    private ArrayList<Book> borrowedBooks;

public User(int userID, String name, String contactInfo) {
    this.userID = userID;
    this.name = name;
    this.contactInfo = contactInfo;
    this.borrowedBooks = new ArrayList<>();
}

// Getters and Setters
public int getUserID() {
    return userID;
}

public String getName() {
    return name;
}

public String getContactInfo() {
    return contactInfo;
}

public ArrayList<Book> getBorrowedBooks() {
    return borrowedBooks;
}

// Override toString method for better printing
@Override
public String toString() {
    return "User ID: " + userID + ", Name: " + name + ", Contact Info: " + contactInfo;
}
}
import java.util.ArrayList;

/**
 * Library class manages a collection of books
 * Provides functionality to add, remove, search, and display books
 */
public class Library {
    // ArrayList to store Book objects
    private ArrayList<Book> books;
    
    /**
     * Constructor to initialize the library with an empty collection
     */
    public Library() {
        books = null;
    }
    
    /**
     * Adds a book to the library
     * Ignores null books
     * @param book The book to add to the library
     */
    public void addBook(Book book) {
        if (book != null) {
            //add book into list using add(book) method
            System.out.println("Book added successfully: " + book.getTitle());
        } else {
            System.out.println("Cannot add null book to library.");
        }
    }
    
    /**
     * Removes a book from the library by its ISBN
     * @param isbn The ISBN of the book to remove
     * @return true if book was removed, false if not found or invalid input
     */
    public boolean removeBookByIsbn(String isbn) {
        // Handle null or empty ISBN
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("Invalid ISBN provided. Cannot remove book.");
            return false;
        }
        
        // Search for book with matching ISBN
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                Book removedBook = books.remove(i);
                System.out.println("Book removed successfully: " + removedBook.getTitle());
                return true;
            }
        }
        
        System.out.println("No book found with ISBN: " + isbn);
        return false;
    }
    
    /**
     * Finds a book by its title (case-insensitive search)
     * @param title The title to search for
     * @return The first book with matching title, or null if not found
     */
    public Book findBookByTitle(String title) {
        // Handle null or empty title
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Invalid title provided for search.");
            return null;
        }
        
        // Search for book with matching title (case-insensitive)
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        
        return null; // Book not found
    }
    
    /**
     * Displays all books in the library
     * Shows "The library is empty." if no books are present
     */
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("\n=== Library Books ===");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
            System.out.println("Total books: " + books.size());
        }
    }
    
    /**
     * Gets the total number of books in the library
     * @return The number of books
     */
    public int getTotalBooks() {
        return null; //return list using size() method
    }
}
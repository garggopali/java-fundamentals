/**
 * Book class represents a book in the library system
 * Each book has a title, author, and unique ISBN
 */
public class Book {
    // Private instance variables
    private String title;
    private String author;
    private String isbn;
    
    /**
     * Constructor to initialize a Book object
     * @param title The title of the book
     * @param author The author of the book
     * @param isbn The unique ISBN identifier
     */
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    /**
     * Getter method for title
     * @return The title of the book
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Getter method for author
     * @return The author of the book
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Getter method for ISBN
     * @return The ISBN of the book
     */
    public String getIsbn() {
        return isbn;
    }
    
    /**
     * Override toString method to display book information
     * @return Formatted string with book details
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
    
    /**
     * Override equals method to compare books by ISBN
     * Two books are equal if their ISBNs match
     * @param obj The object to compare with
     * @return true if ISBNs match, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Book book = (Book) obj;
        return isbn != null ? isbn.equals(book.isbn) : book.isbn == null;
    }
    
    /**
     * Override hashCode method to generate hash based on ISBN
     * @return Hash code based on ISBN
     */
    @Override
    public int hashCode() {
        return isbn != null ? isbn.hashCode() : 0;
    }
}
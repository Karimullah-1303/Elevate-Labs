import java.util.*;

class Book {
    private int id;
    private String title;
    private boolean isIssued;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }

    public void issueBook() { this.isIssued = true; }
    public void returnBook() { this.isIssued = false; }

    @Override
    public String toString() {
        return id + " - " + title + (isIssued ? " (Issued)" : " (Available)");
    }
}


class User {
    private int userId;
    private String name;
    private List<Book> issuedBooks;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public List<Book> getIssuedBooks() { return issuedBooks; }

    public void issueBook(Book book) {
        issuedBooks.add(book);
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void issueBook(int bookId, User user) {
        for (Book b : books) {
            if (b.getId() == bookId && !b.isIssued()) {
                b.issueBook();
                user.issueBook(b);
                System.out.println(user.getName() + " issued " + b.getTitle());
                return;
            }
        }
        System.out.println("Book not available!");
    }

    public void returnBook(int bookId, User user) {
        for (Book b : books) {
            if (b.getId() == bookId && b.isIssued()) {
                b.returnBook();
                user.returnBook(b);
                System.out.println(user.getName() + " returned " + b.getTitle());
                return;
            }
        }
        System.out.println("Book not found in issued list!");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();


        library.addBook(new Book(1, "Java Programming"));
        library.addBook(new Book(2, "Data Structures"));
        library.addBook(new Book(3, "Operating Systems"));


        User user1 = new User(101, "Alice");


        System.out.println("Available books:");
        library.showBooks();


        library.issueBook(2, user1);
        library.issueBook(3, user1);


        System.out.println("\nAfter issuing:");
        library.showBooks();


        library.returnBook(2, user1);

        
        System.out.println("\nAfter returning:");
        library.showBooks();
    }
}
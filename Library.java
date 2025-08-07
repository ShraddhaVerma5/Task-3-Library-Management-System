import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user);
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null || user == null) {
            System.out.println("Invalid Book or User ID.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book already issued.");
        } else {
            book.issue();
            System.out.println("Book issued to " + user.getName());
        }
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);

        if (book == null) {
            System.out.println("Invalid Book ID.");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("Book is not issued.");
        } else {
            book.returnBook();
            System.out.println("Book returned.");
        }
    }

    public void showBooks() {
        System.out.println("\nBooks in Library:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private Book findBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    private User findUserById(int id) {
        for (User u : users) {
            if (u.getUserId() == id) return u;
        }
        return null;
    }
}

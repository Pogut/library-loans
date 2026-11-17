package loans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {
    private final Map<String, Book> books = new HashMap<>();
    private final List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) { books.put(book.getIsbn(), book); }
    public Book findBook(String isbn) { return books.get(isbn); }
    public void saveLoan(Loan loan) { loans.add(loan); }
    public void deleteLoan(Loan loan) { loans.remove(loan); }
    public List<Loan> allLoans() { return new ArrayList<>(loans); }
}

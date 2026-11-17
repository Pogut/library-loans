package loans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanService {
    private static final int LOAN_DAYS = 14;
    private static final int MAX_LOANS = 5;

    private final Catalog catalog;

    public LoanService(Catalog catalog) {
        this.catalog = catalog;
    }

    public Loan borrow(String isbn, String memberId, LocalDate today) {
        Book book = catalog.findBook(isbn);
        if (book == null) {
            throw new IllegalArgumentException("No book " + isbn);
        }
        if (book.getCopies() == 0) {
            throw new IllegalStateException("No copy of " + isbn + " is available");
        }
        if (loansOf(memberId) >= MAX_LOANS) {
            throw new IllegalStateException("A member can borrow at most " + MAX_LOANS + " books");
        }
        book.setCopies(book.getCopies() - 1);
        Loan loan = new Loan(isbn, memberId, today.plusDays(LOAN_DAYS));
        catalog.saveLoan(loan);
        return loan;
    }

    public void giveBack(Loan loan) {
        Book book = catalog.findBook(loan.getIsbn());
        book.setCopies(book.getCopies() + 1);
        catalog.deleteLoan(loan);
    }

    public List<Loan> overdueLoans(LocalDate today) {
        List<Loan> overdue = new ArrayList<>();
        for (Loan loan : catalog.allLoans()) {
            if (loan.getDueDate().isBefore(today)) {
                overdue.add(loan);
            }
        }
        return overdue;
    }

    private int loansOf(String memberId) {
        int count = 0;
        for (Loan loan : catalog.allLoans()) {
            if (loan.getMemberId().equals(memberId)) {
                count++;
            }
        }
        return count;
    }
}

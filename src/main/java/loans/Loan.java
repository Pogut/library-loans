package loans;

import java.time.LocalDate;

public class Loan {
    private final String isbn;
    private final String memberId;
    private final LocalDate dueDate;

    public Loan(String isbn, String memberId, LocalDate dueDate) {
        this.isbn = isbn;
        this.memberId = memberId;
        this.dueDate = dueDate;
    }

    public String getIsbn() { return isbn; }
    public String getMemberId() { return memberId; }
    public LocalDate getDueDate() { return dueDate; }
}

package loans;

public class Book {
    private final String isbn;
    private final String title;
    private int copies;

    public Book(String isbn, String title, int copies) {
        this.isbn = isbn;
        this.title = title;
        this.copies = copies;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }
}

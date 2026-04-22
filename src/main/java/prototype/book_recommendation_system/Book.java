package prototype.book_recommendation_system;

public class Book implements Prototype {
    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)%n%s, %s", title, publicationYear, author, genre);
    }

    @Override
    public Book clone() {
        // shallow copy
        return new Book(this.author, this.title, this.genre, this.publicationYear);
    }
}

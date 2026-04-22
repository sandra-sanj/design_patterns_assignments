package prototype.book_recommendation_system;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> bookList;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.bookList = new ArrayList<>();
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void addItem(Book book) {
        this.bookList.add(book);
    }

    public void removeItem(Book book) {
        this.bookList.remove(book);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public Recommendation clone() {
        // deep copy
        try {
            Recommendation clonedRecommendation = (Recommendation) super.clone();
            clonedRecommendation.bookList = new ArrayList<>();
            clonedRecommendation.setTargetAudience(this.targetAudience);

            // clone booklist
            for (Book book : this.bookList) {
                clonedRecommendation.addItem(book.clone());
            }
            return clonedRecommendation;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return targetAudience;
    }
}

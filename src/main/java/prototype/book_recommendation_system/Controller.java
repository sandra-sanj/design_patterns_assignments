package prototype.book_recommendation_system;

public class Controller {

    private Gui gui;

    public Controller(Gui gui) {
        this.gui = gui;
        initBooks();
    }

    private void initBooks() {
        this.gui.getAvailableBooks().addAll(
            new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "Fantasy", 1997),
            new Book("George R.R. Martin", "A Game of Thrones", "Fantasy", 1996),
            new Book("J.R.R. Tolkien", "The Lord of the Rings", "Fantasy", 1954),
            new Book("Stephen King", "The Shining", "Horror", 1977),
            new Book("Agatha Christie", "Murder on the Orient Express", "Mystery", 1934),
            new Book("Dan Brown", "The Da Vinci Code", "Thriller", 2003),
            new Book("Harper Lee", "To Kill a Mockingbird", "Fiction", 1960),
            new Book("F. Scott Fitzgerald", "The Great Gatsby", "Fiction", 1925)
        );
    }

    public void addRecommendation() {
        String audience = gui.getNewRecField().getText();

        if (!audience.isEmpty()) {
            gui.getRecList().add(new Recommendation(audience));
            gui.getNewRecField().clear();
        }
    }

    public void cloneRecommendation() {
        Recommendation selected = gui.getRecListView().getSelectionModel().getSelectedItem();

        if (selected != null) {
            Recommendation clone = selected.clone();
            clone.setTargetAudience(selected.getTargetAudience() + "-1");
            gui.getRecList().add(clone);
        }
    }

    // show selected rec list books in gui
    public void updateBookList() {
        Recommendation selected = gui.getRecListView().getSelectionModel().getSelectedItem();
        gui.getBookList().clear();

        if (selected != null) {
            gui.getBookList().addAll(selected.getBookList());
        }
    }

    // add to rec list
    public void addBook() {
        Recommendation selected = gui.getRecListView().getSelectionModel().getSelectedItem();
        Book selectedBook = gui.getAvailableBooksComboBox().getSelectionModel().getSelectedItem();

        if (selected != null && selectedBook != null) {
            selected.addItem(selectedBook);
            updateBookList();
            gui.getAvailableBooksComboBox().getSelectionModel().clearSelection();
        }
    }

    // remove from rec list
    public void removeBook() {
        Recommendation selectedRec = gui.getRecListView().getSelectionModel().getSelectedItem();
        Book selectedBook = gui.getBookListView().getSelectionModel().getSelectedItem();

        if (selectedRec != null && selectedBook != null) {
            selectedRec.removeItem(selectedBook);
            updateBookList();
        }
    }

    // update rec name field to current
    public void onRecommendationSelected() {
        Recommendation selected = gui.getRecListView().getSelectionModel().getSelectedItem();

        if (selected != null) {
            gui.getNewRecField().setText(selected.getTargetAudience());
        } else {
            gui.getNewRecField().clear();
        }
    }

    public void renameRecommendation() {
        Recommendation selected = gui.getRecListView().getSelectionModel().getSelectedItem();
        String newName = gui.getNewRecField().getText();

        if (selected != null && !newName.isEmpty()) {
            selected.setTargetAudience(newName);
            gui.getRecList().set(gui.getRecList().indexOf(selected), selected);
        }
    }

    public void deleteRecommendation() {
        Recommendation selected = gui.getRecListView().getSelectionModel().getSelectedItem();

        if (selected != null) {
            gui.getRecList().remove(selected);
            gui.getNewRecField().clear();
            updateBookList();
        }
    }
}

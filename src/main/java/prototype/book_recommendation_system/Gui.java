package prototype.book_recommendation_system;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Gui extends Application {

    private Controller controller;

    private ListView<Recommendation> recListView;
    private ObservableList<Recommendation> recList;

    private ListView<Book> bookListView;
    private ObservableList<Book> bookList;

    private ComboBox<Book> availableBooksComboBox;
    private ObservableList<Book> availableBooks;

    private TextField newRecField;

    @Override
    public void start(Stage primaryStage) {

        recList = FXCollections.observableArrayList();
        recListView = new ListView<>(recList);
        recListView.setPrefWidth(300);

        bookList = FXCollections.observableArrayList();
        bookListView = new ListView<>(bookList);
        bookListView.setPrefWidth(300);

        availableBooks = FXCollections.observableArrayList();
        availableBooksComboBox = new ComboBox<>(availableBooks);

        controller = new Controller(this);

        // recommendation controls
        Label newRecLabel = new Label("New recommendation list");
        newRecField = new TextField();
        VBox newRecVBox = new VBox(2, newRecLabel, newRecField);

        Button addRecBtn = new Button("Create");
        addRecBtn.setOnAction(e -> controller.addRecommendation());

        Button cloneRecBtn = new Button("Clone");
        cloneRecBtn.setOnAction(e -> controller.cloneRecommendation());

        Button renameRecBtn = new Button("Rename");
        renameRecBtn.setOnAction(e -> controller.renameRecommendation());

        Button deleteRecBtn = new Button("Delete");
        deleteRecBtn.setOnAction(e -> controller.deleteRecommendation());

        HBox recActions = new HBox(5, addRecBtn, cloneRecBtn, renameRecBtn, deleteRecBtn);
        VBox recControls = new VBox(5, newRecVBox, recActions);

        // book controls
        Label availableBooksLabel = new Label("Add book to list");
        VBox availableBooksVBox = new VBox(2, availableBooksLabel, availableBooksComboBox);

        Button addBookBtn = new Button("Add");
        addBookBtn.setOnAction(e -> controller.addBook());

        Button removeBookBtn = new Button("Remove");
        removeBookBtn.setOnAction(e -> controller.removeBook());

        HBox bookActions = new HBox(5, addBookBtn, removeBookBtn);
        VBox bookControls = new VBox(5, availableBooksVBox, bookActions);

        // layout
        VBox left = new VBox(10, new Label("Recommendations lists"), recListView, recControls);
        VBox right = new VBox(10, new Label("Books in selected recommendation list"), bookListView, bookControls);

        left.setPadding(new Insets(10));
        right.setPadding(new Insets(10));

        HBox root = new HBox(20, left, right);

        recListView.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
            controller.updateBookList();
            controller.onRecommendationSelected();
        });

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Recommendations");
        primaryStage.show();
    }

    public ListView<Recommendation> getRecListView() {
        return recListView;
    }

    public ObservableList<Recommendation> getRecList() {
        return recList;
    }

    public ListView<Book> getBookListView() {
        return bookListView;
    }

    public ObservableList<Book> getBookList() {
        return bookList;
    }

    public ComboBox<Book> getAvailableBooksComboBox() {
        return availableBooksComboBox;
    }

    public ObservableList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public TextField getNewRecField() {
        return newRecField;
    }
}

package mediator.chat_app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class Gui extends Application {

    private ChatManager manager;

    private ObservableList<User> users;

    @Override
    public void start(Stage primaryStage) throws Exception {
        manager = new ChatManager();

        users = FXCollections.observableArrayList(
                new User("user1"),
                new User("user2"),
                new User("user3")
        );

        for (User user : users) {
            new UserClient(user, manager, this);
        }
    }

    public ObservableList<User> getUsers() {
        return users;
    }
}

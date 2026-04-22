package mediator.chat_app;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class UserClient {
    private User user;
    private Gui gui;
    private UserClientController controller;

    private TextArea chatBoxArea;

    public UserClient(User user, Mediator chatManager, Gui gui) {
        this.user = user;
        this.gui = gui;

        this.controller = new UserClientController(this, chatManager);
        this.createUI();
    }

    public void createUI() {
        Stage stage = new Stage();

        ComboBox<User> usersComboBox = new ComboBox<>();
        for (User user2 : this.gui.getUsers()) {
            if (!user2.equals(this.user)) {
                usersComboBox.getItems().add(user2);
            }
        }

        chatBoxArea = new TextArea();
        chatBoxArea.setEditable(false);

        TextField msgTextField = new TextField();
        Button sendMsgBtn = new Button("Send");

        VBox layout = new VBox(2, usersComboBox, chatBoxArea, msgTextField, sendMsgBtn);
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);

        Scene newScene = new Scene(layout, 500, 300);

        stage.setScene(newScene);
        stage.setTitle(user.getUsername());
        stage.show();

        // select chat
        usersComboBox.getSelectionModel().selectedItemProperty().addListener(obs -> {
            User otherUser = usersComboBox.getSelectionModel().getSelectedItem();
            if (otherUser != null) {
                controller.openChat(otherUser);
            }
        });

        // send message
        sendMsgBtn.setOnAction(event -> {
            User recipient = usersComboBox.getSelectionModel().getSelectedItem();
            controller.sendMessage(msgTextField.getText(), recipient);
            msgTextField.clear();
        });
    }

    public void displayMessage(Message message) {
        chatBoxArea.appendText(String.format("%s: %s\n", message.getUser().getUsername(), message.getMessage()));
    }

    public void displayChatHistory(List<Message> history) {
        chatBoxArea.clear();
        for (Message message : history) {
            displayMessage(message);
        }
    }

    public User getUser() {
        return user;
    }
}

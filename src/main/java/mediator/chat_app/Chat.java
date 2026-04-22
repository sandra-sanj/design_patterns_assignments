package mediator.chat_app;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private static int nextId = 1;

    private int chatId;
    private List<Message> messages = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public Chat(User user1, User user2) {
        this.chatId = nextId++;
        this.users.add(user1);
        this.users.add(user2);
    }

    public int getChatId() {
        return chatId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<User> getUsers() {
        return users;
    }
}

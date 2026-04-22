package mediator.chat_app;

import java.util.ArrayList;
import java.util.List;

public class UserClientController {
    private UserClient client;
    private Mediator chatManager;
    private Chat activeChat;

    public UserClientController(UserClient client, Mediator chatManager) {
        this.client = client;
        this.chatManager = chatManager;
        this.chatManager.registerController(this);
    }

    public void openChat(User otherUser) {
        Chat chat = this.chatManager.getOrCreateChat(this.client.getUser(), otherUser);
        this.setActiveChat(chat);

        List<Message> history = getChatHistory();
        this.client.displayChatHistory(history);
    }

    public void sendMessage(String message, User recipient) {
        if (recipient != null) {
            this.chatManager.sendChatMessage(this.client.getUser(), recipient, message);
        }
    }

    public void receiveMessage(Message message, int chatId) {
        if (activeChat != null && activeChat.getChatId() == chatId) {
            client.displayMessage(message);
        }
    }

    public UserClient getClient() {
        return client;
    }

    private void setActiveChat(Chat activeChat) {
        this.activeChat = activeChat;
    }

    private List<Message> getChatHistory() {
        if (activeChat == null) {
            return new ArrayList<>();
        }
        return this.chatManager.requestChatHistory(this.activeChat.getChatId());
    }
}

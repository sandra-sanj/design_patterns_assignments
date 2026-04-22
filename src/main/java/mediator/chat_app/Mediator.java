package mediator.chat_app;

import java.util.List;

public interface Mediator {
    void registerController(UserClientController controller);
    Chat getOrCreateChat(User user1, User user2);
    void sendChatMessage(User sender, User recipient, String message);
    List<Message> requestChatHistory(int chatId);
}

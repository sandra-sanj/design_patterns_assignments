package mediator.chat_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatManager implements Mediator {
    private Map<Integer, Chat> chats;
    private List<UserClientController> controllers;

    public ChatManager() {
        this.chats = new HashMap<>();
        this.controllers = new ArrayList<>();
    }

    @Override
    public void registerController(UserClientController controller) {
        this.controllers.add(controller);
    }

    @Override
    public Chat getOrCreateChat(User user1, User user2) {
        for (Chat chat : this.chats.values()) {
            if (chat.getUsers().contains(user1) && chat.getUsers().contains(user2)) {
                return chat;
            }
        }

        Chat newChat = new Chat(user1, user2);
        this.chats.put(newChat.getChatId(), newChat);
        return newChat;
    }

    @Override
    public void sendChatMessage(User sender, User recipient, String messageStr) {
        Chat chat = getOrCreateChat(sender, recipient);
        Message message = new Message(sender, messageStr);
        chat.getMessages().add(message);

        for (UserClientController controller : this.controllers) {
            User controllerUser = controller.getClient().getUser();
            if (controllerUser.equals(sender) || controllerUser.equals(recipient)) {
                controller.receiveMessage(message, chat.getChatId());
            }
        }
    }

    @Override
    public List<Message> requestChatHistory(int chatId) {
        Chat chat = this.chats.get(chatId);
        return chat != null ? chat.getMessages() : new ArrayList<>();
    }
}

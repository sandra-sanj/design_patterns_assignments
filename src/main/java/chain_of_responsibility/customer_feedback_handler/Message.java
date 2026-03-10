package chain_of_responsibility.customer_feedback_handler;

public class Message {
    private MessageType type;
    private String content;
    private String email;

    public Message(MessageType type, String content, String email) {
        this.type = type;
        this.content = content;
        this.email = email;
    }

    public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("Message type: %s\nMessage: %s\nSender email: %s\n", this.getType(), this.getContent(), this.getEmail());
    }
}

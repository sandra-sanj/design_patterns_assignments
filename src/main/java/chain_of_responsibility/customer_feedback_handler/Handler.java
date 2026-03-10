package chain_of_responsibility.customer_feedback_handler;

public abstract class Handler {

    private Handler nextHandler;

    public void process(Message message) {
        if (nextHandler != null) {
            nextHandler.process(message);
        } else {
            System.out.println("No handler found. Message disappeared into the void.");
        }
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

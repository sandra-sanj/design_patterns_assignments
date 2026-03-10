package chain_of_responsibility.customer_feedback_handler;

// log and prioritize
public class DevelopmentSuggestionHandler extends Handler {

    @Override
    public void process(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("DevelopmentSuggestionHandler: Development suggestion logged.");
            System.out.println(message);
            return;
        }
        System.out.println("DevelopmentSuggestionHandler: Cannot handle, sending to next handler.");
        super.process(message);
    }

}

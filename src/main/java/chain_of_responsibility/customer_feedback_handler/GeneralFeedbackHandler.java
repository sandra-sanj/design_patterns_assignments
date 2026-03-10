package chain_of_responsibility.customer_feedback_handler;

// analyze and respond
public class GeneralFeedbackHandler extends Handler {

    @Override
    public void process(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("GeneralFeedbackHandler: Message analyzed and responded to.");
            System.out.println(message);
            return;
        }
        System.out.println("GeneralFeedbackHandler: Cannot handle, sending to next handler.");
        super.process(message);
    }

}

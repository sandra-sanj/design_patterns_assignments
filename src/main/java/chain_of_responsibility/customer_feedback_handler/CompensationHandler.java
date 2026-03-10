package chain_of_responsibility.customer_feedback_handler;

// review and approve or reject
public class CompensationHandler extends Handler {

    @Override
    public void process(Message message) {
        if (message.getType() == MessageType.COMPENSATION) {
            System.out.println("CompensationHandler: Compensation request reviewed. (Approve/Reject)");
            System.out.println(message);
            return;
        }
        System.out.println("CompensationHandler: Cannot handle, sending to next handler.");
        super.process(message);
    }

}

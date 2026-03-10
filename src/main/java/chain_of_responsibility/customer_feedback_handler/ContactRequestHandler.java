package chain_of_responsibility.customer_feedback_handler;

// forward to appropriate department
public class ContactRequestHandler extends Handler {

    @Override
    public void process(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("ContactRequestHandler: Message forwarded to appropriate department.");
            System.out.println(message);
            return;
        }
        System.out.println("ContactRequestHandler: Cannot handle, sending to next handler.");
        super.process(message);
    }

}

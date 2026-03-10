package chain_of_responsibility.customer_feedback_handler;

public class Main {

    public static void main(String[] args) {

        // chain: general -> contact -> development -> compensation

        Handler mainHandler;
        Handler generalHandler = new GeneralFeedbackHandler();
        Handler contactHandler = new ContactRequestHandler();
        Handler developmentHandler = new DevelopmentSuggestionHandler();
        Handler compensationHandler = new CompensationHandler();

        mainHandler = generalHandler;
        generalHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(developmentHandler);
        developmentHandler.setNextHandler(compensationHandler);

        String email = "email@email.com";
        Message message1 = new Message(MessageType.CONTACT_REQUEST, "I require contact", email);
        Message message2 = new Message(MessageType.COMPENSATION, "I need 1000€ back", email);
        Message message3 = new Message(MessageType.DEVELOPMENT_SUGGESTION, "This feature could be improved", email);
        Message message4 = new Message(MessageType.GENERAL_FEEDBACK, "I liked this experience", email);

        mainHandler.process(message1);
        //mainHandler.process(message2);
        //mainHandler.process(message3);
        //mainHandler.process(message4);

    }
}

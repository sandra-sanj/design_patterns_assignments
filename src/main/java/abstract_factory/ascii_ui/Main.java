package abstract_factory.ascii_ui;

public class Main {
    public static void main(String[] args) {
        //UIFactory factory = new AFactory();
        UIFactory factory = new BFactory();

        Button button = factory.createButton("example button");
        Checkbox checkbox = factory.createCheckbox("example checkbox");
        TextField textField = factory.createTextField("example textfield");

        button.display();
        checkbox.display();
        textField.display();

        System.out.println();

        button.setText("Change");
        button.display();

        button.setText("Change again");
        button.display();
    }
}

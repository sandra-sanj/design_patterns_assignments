package abstract_factory.ascii_ui;

public class TextFieldA extends TextField {
    private String text;

    public TextFieldA(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println(". " + this.text + " .");
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}

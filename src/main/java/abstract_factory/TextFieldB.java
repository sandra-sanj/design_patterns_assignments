package abstract_factory;

public class TextFieldB extends TextField {
    private String text;

    public TextFieldB(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("_ " + this.text + " _");
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}

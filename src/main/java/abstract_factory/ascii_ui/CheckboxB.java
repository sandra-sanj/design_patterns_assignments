package abstract_factory.ascii_ui;

public class CheckboxB extends Checkbox {
    private String text;

    public CheckboxB(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("{ " + this.text + " }");
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}

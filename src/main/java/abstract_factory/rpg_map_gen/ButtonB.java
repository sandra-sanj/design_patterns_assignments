package abstract_factory.rpg_map_gen;

public class ButtonB extends Button {
    private String text;

    public ButtonB(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("( " + this.text + " )");
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}

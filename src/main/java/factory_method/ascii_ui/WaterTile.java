package factory_method.ascii_ui;

public class WaterTile extends Tile {

    @Override
    public String getCharacter() {
        return "W";
    }

    @Override
    public String getType() {
        return "water";
    }

    @Override
    public void action() {

    }
}

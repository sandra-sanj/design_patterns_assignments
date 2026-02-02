package factory_method.ascii_ui;

public class RoadTile extends Tile {
    @Override
    public String getCharacter() {
        return "R";
    }

    @Override
    public String getType() {
        return "road";
    }

    @Override
    public void action() {

    }
}

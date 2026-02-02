package factory_method;

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

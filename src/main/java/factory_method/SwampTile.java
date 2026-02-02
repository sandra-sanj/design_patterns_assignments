package factory_method;

public class SwampTile extends Tile {

    @Override
    public String getCharacter() {
        return "S";
    }

    @Override
    public String getType() {
        return "swamp";
    }

    @Override
    public void action() {

    }
}

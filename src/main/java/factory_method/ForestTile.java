package factory_method;

public class ForestTile extends Tile {
    @Override
    public String getCharacter() {
        return "F";
    }

    @Override
    public String getType() {
        return "forest";
    }

    @Override
    public void action() {

    }
}

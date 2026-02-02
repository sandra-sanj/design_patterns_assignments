package factory_method.ascii_ui;

public class BuildingTile extends Tile {
    @Override
    public String getCharacter() {
        return "B";
    }

    @Override
    public String getType() {
        return "building";
    }

    @Override
    public void action() {

    }
}

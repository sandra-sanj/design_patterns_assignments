package factory_method.rpg_map_gen;

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

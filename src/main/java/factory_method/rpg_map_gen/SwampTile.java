package factory_method.rpg_map_gen;

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
